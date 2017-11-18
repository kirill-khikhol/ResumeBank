package tel_ran.bank_resume.model;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.entities.Account;
import tel_ran.bank_resume.interfaces.IAccounts;

public class AccountModel implements IAccounts {
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	@Override
	@Transactional
	public boolean createAccount(Account account) {
		// check account
		if (account == null || em.find(Account.class, account.getLogin()) != null) {
			return false;
		}
		// add account
		em.persist(account);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removeAccount(String login) {
		// check login
		if (login == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// remove account
		em.remove(account);
		return true;
	}
	
	@Override
	public boolean isExists(String login) {
		// check login
		if (login == null) { return false; }
		// is exist
		return em.find(Account.class, login) != null;
	}
	
	@Override
	public boolean checkPassword(String login, String password) {
		// check login and password
		if (login == null || password == null) { return false; }
		// check password
		String jpql = "select a from Account a where a.login = :login and a.password = :password)";
		return !em.createQuery(jpql).
				setParameter("login", login).setParameter("password", password).
				getResultList().isEmpty();
	}
	
	@Override
	public boolean isActive(String login) {
		// check login
		if (login == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// is activate
		return account.isActivate();
	}
	
	@Override
	public TypeRole getRole(String login) {
		// check login
		if (login == null) { return null; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return null; }
		// get role
		return account.getRole();
	}
	
	@Override
	@Transactional
	public boolean updatePassword(String login, String newPassword) {
		// check login and new password
		if (login == null || newPassword == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// set password
		account.setPassword(newPassword);
		return true;
	}
	
	@Override
	@Transactional
	public boolean activate(String login) {
		// check login
		if (login == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// activate
		account.activate();
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateTypeQuestion(String login, TypeQuestion typeQuestion, String question) {
		// check login, type question and question
		if (login == null || typeQuestion == null || question == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// update type question and question
		account.updateTypeQuestion(typeQuestion, question);
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateQuestion(String login, String question) {
		// check login and question
		if (login == null || question == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// update question
		account.setQuestion(question);
		return true;
	}
	
	@Override
	@Transactional
	public boolean updatePhone(String login, int phone) {
		// check login
		if (login == null) { return false; }
		// check account
		Account account = em.find(Account.class, login);
		if (account == null) { return false; }
		// update phone
		account.setPhone(phone);
		return true;
	}
}
