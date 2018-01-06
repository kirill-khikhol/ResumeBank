package tel_ran.bank_resume.interfaces.company;

import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.company.*;

public interface ICompany {
	public boolean createCompany(Company company);

//	public boolean removeCompany(String login);

	public Company getCompany(String login);

	public boolean isExist(String login);

	public boolean updateName(String login, String newName);

	public boolean updateCompanyType(String login, String newCompanyType);

	public boolean updateCompanySize(String login, String newCompanySize);

	public boolean updateLocation(String login, String[] newLocation);

	public boolean updateIsVarified(String login, String newIsVarified);

	public boolean updateIsDelited(String login, boolean newIsDelited);

	public boolean updateAbout(String login, String newAbout);

	public boolean updateContact(String login, ContactDTO newContactDTO);

	boolean updateAll(CompanyDTO companyDTO);

}
