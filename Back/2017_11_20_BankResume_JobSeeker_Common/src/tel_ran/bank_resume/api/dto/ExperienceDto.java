package tel_ran.bank_resume.api.dto;

public class ExperienceDto {
	String companyName;
	String position;
	String startDate;
	String endDate;
	ProjectDto[] projects;
	
	public ExperienceDto() { }
	public ExperienceDto(String companyName, String position, String startDate, String endDate,
			ProjectDto[] projects) {
		this.companyName = companyName;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projects = projects;
	}
	
	public String getCompanyName() { return companyName; }
	public String getPosition() { return position; }
	public String getStartDate() { return startDate; }
	public String getEndDate() { return endDate; }
	public ProjectDto[] getProjects() { return projects; }
}
