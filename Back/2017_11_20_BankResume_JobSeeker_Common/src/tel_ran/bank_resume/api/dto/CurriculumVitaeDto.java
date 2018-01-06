package tel_ran.bank_resume.api.dto;

public class CurriculumVitaeDto {
	String login;
	int yearsInWork;
	String[] skillsType;
	String[] companyName;
	VerificationDto verification;
	String cvType;
	String dateOfEnable;
	boolean enable;
	int minSalary;
	
	public CurriculumVitaeDto() { }
	public CurriculumVitaeDto(String login, int yearsInWork, String[] skillsType, String[] companyName, VerificationDto verification,
			String cvType, String dateOfEnable, boolean enable, int minSalary) {
		this.login = login;
		this.yearsInWork = yearsInWork;
		this.skillsType = skillsType;
		this.companyName = companyName;
		this.verification = verification;
		this.cvType = cvType;
		this.dateOfEnable = dateOfEnable;
		this.enable = enable;
		this.minSalary = minSalary;
	}
	
	public int getYearsInWork() { return yearsInWork; }
	public String[] getSkillsType() { return skillsType; }
	public String[] getCompanyName() { return companyName; }
	public VerificationDto getVerification() { return verification; }
	public String getCvType() { return cvType; }
	public String getLogin() { return login; }
	public String getDateOfEnable() { return dateOfEnable; }
	public boolean isEnable() { return enable; }
	public int getMinSalary() { return minSalary; }
}
