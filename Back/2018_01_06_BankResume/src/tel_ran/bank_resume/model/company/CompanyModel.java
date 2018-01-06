package tel_ran.bank_resume.model.company;

import javax.persistence.*;
import javax.transaction.Transactional;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.company.*;
import tel_ran.bank_resume.interfaces.company.*;

public class CompanyModel implements ICompany {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Override
	@Transactional
	public boolean createCompany(Company company) {
		boolean result = false;
		// check
		if (company != null && em.find(Admin.class, company.getLogin()) == null) {
			// add account
			em.persist(company);
			result = true;
		}
		return result;
	}

//	@Override
//	@Transactional
//	public boolean removeCompany(String login) {
//		boolean result = false;
//		// check input data
//		if (login != null) {
//			Company company = em.find(Company.class, login);
//			if (company != null) {
//				// remove company
//				em.remove(company);
//				result = true;
//			}
//		}
//		return result;
//	}

	@Override
	public boolean isExist(String login) {
		boolean result = false;
		// check input data
		if (login != null) {
			if (em.find(Company.class, login) != null) {
				// remove company
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateName(String login, String newName) {
		return updateNameWot(login, newName);
	}
	public boolean updateNameWot(String login, String newName) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null && newName != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update name
				company.setName(newName);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateCompanyType(String login, String newCompanyType) {
		return updateCompanyTypeWot(login, newCompanyType);
	}
	public boolean updateCompanyTypeWot(String login, String newCompanyType) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null && newCompanyType != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update company type
				company.setCompanyType(newCompanyType);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateCompanySize(String login, String newCompanySize) {
		return updateCompanySizeWot(login, newCompanySize);
	}
	public boolean updateCompanySizeWot(String login, String newCompanySize) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null && newCompanySize != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update company size
				company.setComganySize(newCompanySize);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateLocation(String login, String[] newLocation) {
		return updateLocationWot(login, newLocation);
	}
	public boolean updateLocationWot(String login, String[] newLocation) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null && newLocation != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update location
				company.setLocation(newLocation);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateIsVarified(String login, String newIsVarified) {
		return updateIsVarifiedWot(login, newIsVarified);
	}
	public boolean updateIsVarifiedWot(String login, String newIsVarified) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update varified status
				company.setVerified(newIsVarified);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateIsDelited(String login, boolean newIsDelited) {
		return updateIsDelitedWot(login, newIsDelited);
	}
	public boolean updateIsDelitedWot(String login, boolean newIsDelited) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update Delited status
				company.setDelited(newIsDelited);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateAbout(String login, String newAbout) {
		return updateAboutWot(login, newAbout);
	}
	public boolean updateAboutWot(String login, String newAbout) { //Wot = without Transaction
		boolean result = false;
		// check input data
		if (login != null && newAbout != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				// update about
				company.setAbout(newAbout);
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean updateContact(String login, ContactDTO newContactDTO) {
		return updateContactWot(login, newContactDTO);
	}
	public boolean updateContactWot(String login, ContactDTO newContactDTO) { //Wot = without Transaction
		boolean result = false;
		if (login != null && newContactDTO != null) {
			Company company = em.find(Company.class, login);
			if (company != null) {
				company.getContact().setTelNum(newContactDTO.getTelNum()).setFaxNum(newContactDTO.getFaxNum())
						.seteMail(newContactDTO.geteMail()).setPersonContact(newContactDTO.getPersonContact());
				result = true;
			}
		}
		return result;
	}
	@Override
	@Transactional
	public boolean updateAll(CompanyDTO companyDTO) {
		boolean result = false;
		if (companyDTO != null) {
			String login = companyDTO.getLogin();
			if (login != null) {
				Company company = em.find(Company.class, companyDTO.getLogin());
				if (company != null) {
					company.setName(companyDTO.getName());
					company.setCompanyType(companyDTO.getCompanyType());
					company.setComganySize(companyDTO.getCompanySize());
					company.setLocation(companyDTO.getLocation());
					company.setVerified(companyDTO.getVerified());
					company.setDelited(companyDTO.isDelited());
					company.setAbout(companyDTO.getAbout());
					ContactDTO contactDTO= companyDTO.getContactDTO();
					if (contactDTO != null) {
						company.setContact(company.getContact().setTelNum(contactDTO.getTelNum())
																.setFaxNum(contactDTO.getFaxNum())
																.seteMail(contactDTO.geteMail())
																.setPersonContact(contactDTO.getPersonContact()));
					}
					result = true;
				}
			}
		}
		return result;
	}
	@Override
	public Company getCompany(String login) {
		Company result = null;
		// check input data
		if (login != null) {
			result = em.find(Company.class, login);

		}
		return result;
	}
}
