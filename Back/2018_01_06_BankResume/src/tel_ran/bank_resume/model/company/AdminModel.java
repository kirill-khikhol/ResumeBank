package tel_ran.bank_resume.model.company;

import javax.persistence.*;
import javax.transaction.Transactional;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.company.*;
import tel_ran.bank_resume.interfaces.company.*;

public class AdminModel implements IAdmin {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Override
	@Transactional
	public boolean addAdministrator(Admin admin) {
		boolean result = false;
		// check account
		if (admin != null && em.find(Admin.class, admin.getLogin()) == null) {
			// add account
			em.persist(admin);
			result = true;
		}
		return result;
	}

	@Override
	public boolean isExist(String login) {
		boolean result = false;
		// check admin
		if (login != null) {
			if (em.find(Admin.class, login) != null) {
				// remove admin
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean removeAdministrator(String login) {
		boolean result = false;
		// check admin
		if (login != null) {
			Admin admin = em.find(Admin.class, login);
			if (admin != null) {
				// remove admin
				em.remove(admin);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateName(String login, String newName) {
		boolean result = false;
		if (login != null && newName != null) {
			Admin admin = em.find(Admin.class, login);
			if (admin != null) {
				admin.setName(newName);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateContact(String login, ContactDTO newContactDTO) {
		boolean result = false;
		if (login != null && newContactDTO != null) {
			Admin admin = em.find(Admin.class, login);
			if (admin != null) {
				admin.getContact().setTelNum(newContactDTO.getTelNum()).setFaxNum(newContactDTO.getFaxNum())
						.seteMail(newContactDTO.geteMail()).setPersonContact(newContactDTO.getPersonContact());
				result = true;
			}
		}
		return result;
	}

}
