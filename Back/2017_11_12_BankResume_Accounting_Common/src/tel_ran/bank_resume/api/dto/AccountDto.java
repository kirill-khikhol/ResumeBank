package tel_ran.bank_resume.api.dto;

public class AccountDto {
	String login;
	String password;
	
	public AccountDto() { }
	public AccountDto(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() { return login; }
	public String getPassword() { return password; }
}
