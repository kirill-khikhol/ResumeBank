package tel_ran.bank_resume.controller.web;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.Account;
import tel_ran.bank_resume.interfaces.IAccounts;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@RestController
public class AccountWebService implements AccountRequestType, AccountResponseType {
	private static final String REGISTRATION_URL = "http://localhost:8080/activation/";
	private static final String MAIL_FROM = "resumeBankActivate@gmail.com";
	private static final String MAIL_FROM_USERNAME = "resumeBankActivate";
	private static final String MAIL_FROM_PASSWORD = "qan8SP20";
	
	@Autowired
	IAccounts accounts;
	
	@RequestMapping(value=LOGIN, method=RequestMethod.POST)
	public String login(@RequestBody AccountDto account) {
		// check data
		if (account == null) { return WRONG_DATA; }
		// check login and password
		String login = account.getLogin();
		String password = account.getPassword();
		if (login == null || password == null) { return WRONG_DATA; }
		if (!accounts.checkPassword(login, password)) { return WRONG_CREDENTIALS; }
		// check activate
		if (!accounts.isActive(login)) { return NOT_ACTIVATED; }
		// get role
		return accounts.getRole(login).toString();
	}
	
	@RequestMapping(value=IS_EXISTS, method=RequestMethod.POST)
	public String isExists(@RequestBody AccountDto account) {
		// check data
		if (account == null) { return WRONG_DATA; }
		// is exists
		return accounts.isExists(account.getLogin()) ? OK : FALSE;
	}
	
	@RequestMapping(value=REGISTRATION, method=RequestMethod.POST)
	public String registrationCompany(@RequestBody FullAccountDto accountDto) {
		// check data
		if (accountDto == null || !checkAccount(accountDto)) { return WRONG_DATA; }
		// is exists
		if (accounts.isExists(accountDto.getLogin())) { return WRONG_CREDENTIALS; }
		// create account
		Account account = new Account(accountDto);
		if (accounts.createAccount(account)) {
			if (sendActivationRequestToEmail(account.getLogin())) { return NOT_ACTIVATED; }
			else {
				accounts.removeAccount(account.getLogin());
				return NO_SEND_EMAIL;
			}
		}
		return FALSE;
	}
	
	@RequestMapping(value=ACTIVATION)
	public void activation(@PathVariable(TOKEN) String token) {
		// check data
		if (token == null) { return; }
		// check login
		String login = new String(Base64.decodeBase64(token));
		if (accounts.activate(login)) {
			sendEmailUsingGMailSMTP(login,
					"Hello, " + login + " registered.");
		}
	}
	
	private boolean sendActivationRequestToEmail(String login) {
		String encodeStr = Base64.encodeBase64String(login.getBytes());
		return sendEmailUsingGMailSMTP(login,
				"Hello, link for registration: " + REGISTRATION_URL + encodeStr);
	}
	
	private boolean sendEmailUsingGMailSMTP(String to, String messageText) {
		// Sender's email ID needs to be mentioned
		String from = MAIL_FROM;
		final String username = MAIL_FROM_USERNAME;
		final String password = MAIL_FROM_PASSWORD;
		
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		// Get the Session object.
		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(to));
			// Set Subject: header field
			message.setSubject("Registration on Resume Bank");
			// Now set the actual message
			message.setText(messageText);
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println("ERROR: MessagingException " + e);
			return false;
		}
		return true;
	}
	
	private boolean checkAccount(FullAccountDto a) {
		if (a.getLogin() == null || a.getPassword() == null || a.getRole() == null ||
				a.getTypeQuestion() == null || a.getQuestion() == null) {
			return false;
		}
		return true;
	}
}
