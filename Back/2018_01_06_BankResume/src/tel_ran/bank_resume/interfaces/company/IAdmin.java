package tel_ran.bank_resume.interfaces.company;

import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.company.*;

public interface IAdmin {

	public boolean addAdministrator(Admin administrator);

	public boolean isExist(String login);

	public boolean removeAdministrator(String login);

	public boolean updateName(String login, String newName);

	public boolean updateContact(String login, ContactDTO newContactDTO);

}
