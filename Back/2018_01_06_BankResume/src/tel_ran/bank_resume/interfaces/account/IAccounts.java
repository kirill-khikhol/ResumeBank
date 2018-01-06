package tel_ran.bank_resume.interfaces.account;

import tel_ran.bank_resume.api.dto.*;

public interface IAccounts {
	public boolean createAccount(FullAccountDto accountDto);
	public boolean checkPassword(AccountDto accountDto);
	public String getRole(AccountDto accountDto);
	public boolean isExists(String login);
	public boolean checkQuestion(FullAccountDto accountDto);
	public boolean isActive(String login);
	public boolean updateDateCreate(String login);
	public String generateNewPassword(String login);
	public boolean activate(String login);
	public boolean updateTypeQuestion(FullAccountDto accountDto);
	public boolean updateQuestion(FullAccountDto accountDto);
	public boolean updatePhone(FullAccountDto accountDto);
	public boolean removeAccount(String login);
}