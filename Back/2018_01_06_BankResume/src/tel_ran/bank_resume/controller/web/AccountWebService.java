package tel_ran.bank_resume.controller.web;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.interfaces.account.*;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@RestController
@CrossOrigin(origins="*")
public class AccountWebService implements AccountRequestType, AccountResponseType {
	private static final int N_ATTEMPTS_SEND = 3;
	
	private static String REGISTRATION_URL;
	private static String MAIL_FROM;
	private static String MAIL_FROM_USERNAME;
	private static String MAIL_FROM_PASSWORD;
	
	@Value("${registrationUrl}")
	public void setRegistrationUrl(String registrationUrl) { REGISTRATION_URL = registrationUrl; }
	@Value("${mailFrom}")
	public void setMailFrom(String mailFrom) { MAIL_FROM = mailFrom; }
	@Value("${mailFromUserName}")
	public void setMailFromUserName(String mailFromUserName) { MAIL_FROM_USERNAME = mailFromUserName; }
	@Value("${mailFromPassword}")
	public void setMailFromPassword(String mailFromPassword) { MAIL_FROM_PASSWORD = mailFromPassword; }
	
	@Autowired
	IAccounts accounts;
	
	@RequestMapping(value=REGISTRATION, method=RequestMethod.POST)
	public String registration(@RequestBody FullAccountDto accountDto) {
		if (accounts.createAccount(accountDto)) {
			if (sendActivationRequestToEmail(accountDto.getLogin())) { return NOT_ACTIVATED; }
			else {
				accounts.removeAccount(accountDto.getLogin());
				return NO_SEND_EMAIL;
			}
		}
		return FALSE;
	}
	
	@RequestMapping(value=LOGIN, method=RequestMethod.POST)
	public String login(@RequestBody AccountDto accountDto) {
		if (!accounts.checkPassword(accountDto)) { return WRONG_CREDENTIALS; }
		return accounts.getRole(accountDto);
	}
	
	@RequestMapping(value=IS_EXISTS, method=RequestMethod.POST)
	public String isExists(@RequestBody AccountDto account) {
		return accounts.isExists(account.getLogin()) ? OK : FALSE;
	}
	
	@RequestMapping(value=CHECK_QUESTION, method=RequestMethod.POST)
	public String checkQuestion(@RequestBody FullAccountDto accountDto) {
		return accounts.checkQuestion(accountDto) ? OK : FALSE;
	}
	
	@RequestMapping(value=RE_ACTIVATION, method=RequestMethod.POST)
	public String reActivation(@RequestBody AccountDto accountDto) {
		if (!accounts.isExists(accountDto.getLogin())) { return WRONG_CREDENTIALS; }
		if (sendActivationRequestToEmail(accountDto.getLogin())) {
			if (accounts.updateDateCreate(accountDto.getLogin())) { return OK; }
		}
		return NO_SEND_EMAIL;
	}
	
	@RequestMapping(value=RESTORE_PASSWORD, method=RequestMethod.POST)
	public String restorePassword(@RequestBody AccountDto accountDto) {
		if (!accounts.isExists(accountDto.getLogin())) { return WRONG_CREDENTIALS; }
		String newPassword = accounts.generateNewPassword(accountDto.getLogin());
		if (newPassword != null) {
			if (sendEmailUsingGMailSMTP(accountDto.getLogin(), "Hello, new password: " + newPassword)) {
				return OK;
			} return NO_SEND_EMAIL;
		}
		return FALSE;
	}
	
	@RequestMapping(value=ACTIVATION)
	public void activation(@PathVariable(TOKEN) String loginEncode) {
		// check data
		if (loginEncode == null) { return; }
		// check login
		String login = new String(Base64.decodeBase64(loginEncode));
		if (accounts.activate(login)) {
			sendEmailUsingGMailSMTP(login, "Hello, " + login + " registered.");
		}
	}
	
	////    send email methods    ////
	
	private boolean sendActivationRequestToEmail(String login) {
		String encodeStr = Base64.encodeBase64String(login.getBytes());
		return sendEmailUsingGMailSMTP(login,
				"Hello, link for registration: " + REGISTRATION_URL + encodeStr);
	}
	
	private boolean sendEmailUsingGMailSMTP(String to, String messageText) {
		// Sender's email ID needs to be mentioned
		String from = MAIL_FROM;
		String username = MAIL_FROM_USERNAME;
		String password = MAIL_FROM_PASSWORD;
		
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
		
		int count = 0;
		do {
			try {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);
				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));
				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
				// Set Subject: header field
				message.setSubject("Resume Bank");
				// Now set the actual message
				message.setText(messageText);
				// Send message
				Transport.send(message);
				return true;
			} catch (MessagingException e) {
				System.out.println("ERROR: MessagingException " + e);
				count++;
			}
		} while (count < N_ATTEMPTS_SEND);
		return false;
	}
}
