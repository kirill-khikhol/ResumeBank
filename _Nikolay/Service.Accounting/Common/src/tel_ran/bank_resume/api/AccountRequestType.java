package tel_ran.bank_resume.api;

public interface AccountRequestType {
	String LOGIN = "/login";
	String IS_EXISTS = "/isExists";
	String REGISTRATION = "/registration";
	String TOKEN = "token";
	String ACTIVATION = "/activation/{" + TOKEN + "}";
	
}
