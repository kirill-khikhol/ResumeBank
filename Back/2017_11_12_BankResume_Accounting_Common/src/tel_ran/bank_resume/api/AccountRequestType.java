package tel_ran.bank_resume.api;

public interface AccountRequestType {
	String LOGIN = "/account/login";
	String IS_EXISTS = "/account/isExist";
	String CHECK_QUESTION = "/account/checkQuestion";
	String RE_ACTIVATION = "/account/reActivation";
	String RESTORE_PASSWORD = "/account/restotrePassword";
	String REGISTRATION = "account/registration";
	String TOKEN = "token";
	String ACTIVATION = "account/activation/{" + TOKEN + "}";
	
}
