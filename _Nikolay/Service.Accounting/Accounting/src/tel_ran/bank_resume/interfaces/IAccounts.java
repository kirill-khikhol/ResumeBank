package tel_ran.bank_resume.interfaces;

import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.entities.Account;

public interface IAccounts {
	public boolean createAccount(Account account);
	public boolean removeAccount(String login);
	public boolean isExists(String login);
	public boolean checkPassword(String login, String password);
	public boolean isActive(String login);
	public TypeRole getRole(String login);
	public boolean updatePassword(String login, String newPassword);
	public boolean activate(String login);
	public boolean updateTypeQuestion(String login, TypeQuestion typeQuestion, String question);
	public boolean updateQuestion(String login, String question);
	public boolean updatePhone(String login, int phone);
}
