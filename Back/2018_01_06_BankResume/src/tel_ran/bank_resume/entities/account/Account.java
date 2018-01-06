package tel_ran.bank_resume.entities.account;

import java.time.LocalDate;

import javax.persistence.*;

import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;


@Entity
public class Account {
	@Id
	@GeneratedValue
	private int genVal;
	private String login;
	private String password;
	private String salt;
	private TypeRole role;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean activate;
	private LocalDate dateCreate;
	private TypeQuestion typeQuestion;
	private String question;
	private int phone;
	
	public Account() { }
	public Account(FullAccountDto accountDto, String password, String salt) {
		this.login = accountDto.getLogin();
		this.password = password;
		this.salt = salt;
		this.role = accountDto.getRole();
		activate = false;
		dateCreate = LocalDate.now();
		this.typeQuestion = accountDto.getTypeQuestion();
		this.question = accountDto.getQuestion();
		this.phone = accountDto.getPhone();
	}
	
	public String getPassword() { return password; }
	public String getSalt() { return salt; }
	public boolean isActivate() { return activate; }
	public LocalDate getDateCreate() { return dateCreate; }
	public TypeQuestion getTypeQuestion() { return typeQuestion; }
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question; }
	public int getPhone() { return phone; }
	public void setPhone(int phone) { this.phone = phone; }
	public String getLogin() { return login; }
	public TypeRole getRole() { return role; }
	
	public void activate() { activate = true; }
	public void updateDateCreate() { this.dateCreate = LocalDate.now(); }
	public void updateTypeQuestion(TypeQuestion typeQuestion, String question) {
		this.typeQuestion = typeQuestion;
		this.question = question;
	}
	public void updatePassword(String password, String salt) {
		this.password = password;
		this.salt = salt;
	}
}
