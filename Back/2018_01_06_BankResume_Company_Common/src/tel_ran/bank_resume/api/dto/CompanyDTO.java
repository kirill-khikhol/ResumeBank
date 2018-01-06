package tel_ran.bank_resume.api.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CompanyDTO implements Serializable {
	private String login;
	private String name;
	private String companyType;
	private String companySize;
	private String[] location;
	private String verified;
	private boolean isDelited;
	private String about;
	private ContactDTO contactDTO;

	public CompanyDTO() {}
	public CompanyDTO(String login, String name, String companyType, String companySize, String[] location,
			String verified, boolean isDelited, String about,ContactDTO contactDTO) {
		super();
		this.login = login;
		this.name = name;
		this.companyType = companyType;
		this.companySize = companySize;
		this.location = location;
		this.verified = verified;
		this.isDelited = isDelited;
		this.about = about;
		this.contactDTO = contactDTO;
	}

	public String getLogin() { return login; }

	public String getName() { return name; }

	public String getCompanyType() { return companyType; }

	public String getCompanySize() { return companySize; }

	public String[] getLocation() { return location; }

	public String getVerified() { return verified; }
	
	public boolean isDelited() { return isDelited; }

	public String getAbout() { return about; }
	
	public ContactDTO getContactDTO() { return contactDTO; }

	

}
