package tel_ran.bank_resume.api.dto;

public class ContactDTO {
	private String[] telNum;
	private String[] faxNum;
	private String eMail;
	private String personContact;

	public ContactDTO() {
	}

	public ContactDTO(String[] telNum, String[] faxNum, String eMail,
			String personContact) {
		super();
		this.telNum = telNum;
		this.faxNum = faxNum;
		this.eMail = eMail;
		this.personContact = personContact;
	}

	public String[] getTelNum() {
		return telNum;
	}

	public String[] getFaxNum() {
		return faxNum;
	}

	public String geteMail() {
		return eMail;
	}

	public String getPersonContact() {
		return personContact;
	}
}
