package tel_ran.bank_resume.api.dto;

public class EducationDto {
	String nameUniversity;
	String nameSpeciality;
	String educationDegree;
	String startDate;
	String endDate;
	
	public EducationDto() { }
	public EducationDto(String nameUniversity, String nameSpeciality, String educationDegree,
			String startDate, String endDate) {
		this.nameUniversity = nameUniversity;
		this.nameSpeciality = nameSpeciality;
		this.educationDegree = educationDegree;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getNameUniversity() { return nameUniversity; }
	public String getNameSpeciality() { return nameSpeciality; }
	public String getEducationDegree() { return educationDegree; }
	public String getStartDate() { return startDate; }
	public String getEndDate() { return endDate; }
}
