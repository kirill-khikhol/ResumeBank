package tel_ran.bank_resume.entities.company;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.*;

@Entity
public class Company {
	@Id
	private String login;
	private String name;
	private String companyType;
	private String comganySize;
	private String[] location;
//	@Column(columnDefinition = "boolean default false", nullable = false)
	private String verified;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean isDelited;
	private String about;
	@OneToOne (optional= false, cascade = CascadeType.ALL)
	private Contact contact;
	

	public Company() {
	}

	public Company(CompanyDTO companyDTO) {
		this.login = companyDTO.getLogin();
		this.name = companyDTO.getName();
		this.companyType = companyDTO.getCompanyType();
		this.comganySize = companyDTO.getCompanySize();
		this.location = companyDTO.getLocation();
		this.verified = companyDTO.getVerified();
		this.isDelited = companyDTO.isDelited();
		this.about = companyDTO.getAbout();
		this.contact = new Contact(login, companyDTO.getContactDTO());
	}

	public String getLogin() {return login;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getCompanyType() {return companyType;}
	public void setCompanyType(String companyType) {this.companyType = companyType;}

	public String getComganySize() {return comganySize;}
	public void setComganySize(String comganySize) {this.comganySize = comganySize;}

	public String[] getLocation() {return location;}
	public void setLocation(String[] location) {this.location = location;}

	public String getVerified() {return verified;}
	public void setVerified(String varified) {this.verified = varified;}
	
	public boolean isDelited() {return isDelited;}
	public void setDelited(boolean isDelited) {this.isDelited = isDelited;}

	public String getAbout() {return about;}
	public void setAbout(String about) {this.about = about;}

	public Contact getContact() {return contact;}
	public void setContact(Contact contact) {this.contact = contact;}
}
