package tel_ran.bank_resume.entities.company;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.*;

@Entity
public class Contact {
	@Id
	private String login;
	private String[] telNum;
	private String[] faxNum;
	private String eMail;
	private String personContact;

	public Contact() {
	}

	public Contact(String login, ContactDTO contactDTO) {
		this.login = login;
		this.telNum = contactDTO.getTelNum();
		this.faxNum = contactDTO.getFaxNum();
		this.eMail = contactDTO.geteMail();
		this.personContact = contactDTO.getPersonContact();
	}

	public String getLogin() {return login;}
	public Contact setLogin(String login) {
		this.login = login;
		return this;
	}

	public String[] getTelNum() {return telNum;}
	public Contact setTelNum(String[] telNum) {
		this.telNum = telNum;
		return this;
	}

	public String[] getFaxNum() {return faxNum;}
	public Contact setFaxNum(String[] faxNum) {
		this.faxNum = faxNum;
		return this;
	}

	public String geteMail() {return eMail;}
	public Contact seteMail(String eMail) {
		this.eMail = eMail;
		return this;
	}

	public String getPersonContact() {return personContact;}
	public Contact setPersonContact(String personContact) {
		this.personContact = personContact;
		return this;
	}
}
