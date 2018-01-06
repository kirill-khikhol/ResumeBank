package tel_ran.bank_resume.entities.company;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.*;

@Entity
public class Admin {
	@Id
	private String login;
	private String name;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Contact contact;

	public Admin() {
	}

	public Admin(AdminDTO adminDTO) {
		super();
		this.login = adminDTO.getLogin();
		this.name = adminDTO.getName();
		this.contact = new Contact(login, adminDTO.getContactDTO());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
