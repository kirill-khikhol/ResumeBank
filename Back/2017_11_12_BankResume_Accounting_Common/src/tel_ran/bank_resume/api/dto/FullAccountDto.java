package tel_ran.bank_resume.api.dto;

import tel_ran.bank_resume.api.*;

public class FullAccountDto extends AccountDto {
	String newPassword;
	TypeRole role;
	TypeQuestion typeQuestion;
	String question;
	int phone;
	
	public FullAccountDto() { }
	public FullAccountDto(String login, String password, TypeRole role, String newPassword,
			TypeQuestion typeQuestion, String question, int phone) {
		super(login, password);
		this.newPassword = newPassword;
		this.role = role;
		this.typeQuestion = typeQuestion;
		this.question = question;
		this.phone = phone;
	}
	
	public String getNewPassword() { return newPassword; }
	public TypeRole getRole() { return role; }
	public TypeQuestion getTypeQuestion() { return typeQuestion; }
	public String getQuestion() { return question; }
	public int getPhone() { return phone; }
}
