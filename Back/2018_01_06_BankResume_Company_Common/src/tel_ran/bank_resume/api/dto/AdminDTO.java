package tel_ran.bank_resume.api.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminDTO implements Serializable {
	private String login;
	private String name;
	private ContactDTO contactDTO;

	public AdminDTO() {
	}

	public AdminDTO(String login, String name, ContactDTO contactDTO) {
		super();
		this.login = login;
		this.name = name;
		this.contactDTO = contactDTO;
	}

	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}

	public ContactDTO getContactDTO() {
		return contactDTO;
	}

}
