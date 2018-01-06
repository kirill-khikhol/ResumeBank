package tel_ran.bank_resume.model.account;

import java.math.BigInteger;
import java.security.*;
import java.util.*;
import javax.persistence.*;
import javax.transaction.Transactional;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.account.*;
import tel_ran.bank_resume.interfaces.account.*;

public class AccountModel implements IAccounts, AccountResponseType {
	private static final int N_RANDOM_PASSWORD = 6;
	private static final char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
	private static final Random gen = new Random();
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	@Override
	@Transactional
	public boolean createAccount(FullAccountDto accountDto) {
		if (accountIsExists(accountDto.getLogin())) { return false; }
		
		String salt = generatingSalt();
		Account account = new Account(accountDto, createPasswordWithSalt(
				accountDto.getPassword(), salt), salt);
		em.persist(account);
		return true;
	}
	
	@Override
	public boolean checkPassword(AccountDto accountDto) {
		String jpql = "select a.password, a.salt from Account a where a.login = :login";
		try {
			Object[] res = (Object[]) em.createQuery(jpql)
					.setParameter("login",accountDto.getLogin()).getSingleResult();
			return ((String)res[0]).equals(md5Hex
					(md5Hex(accountDto.getPassword()).concat((String)res[1])));
		} catch (RuntimeException e) { return false; }
	}
	
	@Override
	public String getRole(AccountDto accountDto) {
		String jpql = "select a.role, a.activate from Account a where a.login = :login";
		try {
			Object[] res = (Object[]) em.createQuery(jpql).setParameter("login", accountDto.getLogin()).getSingleResult();
			if (!(boolean)res[1]) { return NOT_ACTIVATED; }
			return ((TypeRole)res[0]).toString();
		} catch (RuntimeException e) {
			return FALSE;
		}
	}
	
	@Override
	public boolean isExists(String login) { return accountIsExists(login); }
	
	@Override
	public boolean checkQuestion(FullAccountDto accountDto) {
		String jpql = "select count(a) > 0 from Account a where a.login = :login and "
				+ "a.typeQuestion = :typeQuestion and a.question = :question";
		try {
			return (boolean) em.createQuery(jpql).setParameter("login", accountDto.getLogin())
					.setParameter("typeQuestion", accountDto.getTypeQuestion())
					.setParameter("question", accountDto.getQuestion()).getSingleResult();
		} catch (RuntimeException e) { return false; }
	}
	
	@Override
	public boolean isActive(String login) {
		String jpql = "select a.activate from Account a where a.login = :login";
		try {
			return (boolean) em.createQuery(jpql).setParameter("login", login).getSingleResult();
		} catch (RuntimeException e) { return false; }
	}
	
	@Override
	@Transactional
	public boolean updateDateCreate(String login) {
		String jpql = "select a from Account a where a.login = :login";
		try {
			Account account = (Account) em.createQuery(jpql).setParameter("login",login).getSingleResult();
			account.updateDateCreate();
			return true;
		} catch (RuntimeException e) { return false; }
	}
	
	@Override
	@Transactional
	public String generateNewPassword(String login) {
		Account account = readAccount(login);
		if (account == null) { return null; }
		String password = generatingSalt();
		String salt = generatingSalt();
		account.updatePassword(createPasswordWithSalt(password, salt), salt);
		return password;
	}
	
	@Override
	@Transactional
	public boolean activate(String login) {
		Account account = readAccount(login);
		if (account == null) { return false; }
		account.activate();
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateTypeQuestion(FullAccountDto accountDto) {
		Account account = readAccount(accountDto.getLogin());
		if (account == null) { return false; }
		account.updateTypeQuestion(accountDto.getTypeQuestion(), accountDto.getQuestion());
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateQuestion(FullAccountDto accountDto) {
		Account account = readAccount(accountDto.getLogin());
		if (account == null) { return false; }
		account.setQuestion(accountDto.getQuestion());
		return true;
	}
	
	@Override
	@Transactional
	public boolean updatePhone(FullAccountDto accountDto) {
		Account account = readAccount(accountDto.getLogin());
		if (account == null) { return false; }
		account.setPhone(accountDto.getPhone());
		return true;
	}
	
	@Override
	@Transactional
	public boolean removeAccount(String login) {
		Account account = readAccount(login);
		if (account == null) { return false; }
		em.remove(account);
		return true;
	}
	
	////    support methods    ////
	
	private boolean accountIsExists(String login) {
		String jpql = "select count(a) > 0 from Account a where a.login = :login";
		try {
			return (boolean) em.createQuery(jpql).setParameter("login", login)
					.getSingleResult();
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	private String generatingSalt() {
		StringBuffer newPassword = new StringBuffer();
		int count = 0;
		while (count < N_RANDOM_PASSWORD) {
			newPassword.append(characters[gen.nextInt(characters.length)]);
			count++;
		}
		return newPassword.toString();
	}
	
	private String createPasswordWithSalt(String password, String salt) {
		return md5Hex(md5Hex(password).concat(salt));
	}
	
	private static String md5Hex(String str) {
		MessageDigest messageDigest = null;
	    byte[] digest = new byte[0];
	    try {
	        messageDigest = MessageDigest.getInstance("MD5");
	        messageDigest.reset();
	        messageDigest.update(str.getBytes());
	        digest = messageDigest.digest();
	    } catch (NoSuchAlgorithmException e) { return null; }
	    BigInteger bigInt = new BigInteger(1, digest);
	    String md5Hex = bigInt.toString(16);
	    while( md5Hex.length() < 32 ){ md5Hex = "0" + md5Hex; }
	    return md5Hex;
	}
	
	private Account readAccount(String login) {
		String jpql = "select a from Account a where a.login = :login";
		try {
			return (Account) em.createQuery(jpql).setParameter("login",login)
					.getSingleResult();
		} catch (RuntimeException e) { return null; }
	}
}
