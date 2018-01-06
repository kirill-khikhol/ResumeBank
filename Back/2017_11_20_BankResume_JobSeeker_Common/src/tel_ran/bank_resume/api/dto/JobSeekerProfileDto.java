package tel_ran.bank_resume.api.dto;

public class JobSeekerProfileDto {
	String login;
	String downloadType;
	CurriculumVitaeDto[] curriculumVitae;
	PersonDataDto personData;
	ProfessionalDataDto professionalData;
	FieldsVisibilityDto fieldsVisibility;
	
	public JobSeekerProfileDto() { }
	public JobSeekerProfileDto(String login, String downloadType, CurriculumVitaeDto[] curriculumVitae,
			PersonDataDto personData, ProfessionalDataDto professionalData, FieldsVisibilityDto fieldsVisibility) {
		this.login = login;
		this.downloadType = downloadType;
		this.curriculumVitae = curriculumVitae;
		this.personData = personData;
		this.professionalData = professionalData;
		this.fieldsVisibility = fieldsVisibility;
	}
	
	public String getLogin() { return login; }
	public String getDownloadType() { return downloadType; }
	public CurriculumVitaeDto[] getCurriculumVitae() { return curriculumVitae; }
	public PersonDataDto getPersonData() { return personData; }
	public ProfessionalDataDto getProfessionalData() { return professionalData; }
	public FieldsVisibilityDto getFieldsVisibility() { return fieldsVisibility; }
}
