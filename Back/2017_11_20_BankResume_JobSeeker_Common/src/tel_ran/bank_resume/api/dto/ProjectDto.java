package tel_ran.bank_resume.api.dto;

public class ProjectDto {
	String nameProject;
	String endDate;
	String descriptionProject;
	
	public ProjectDto() { }
	public ProjectDto(String nameProject, String endDate, String descriptionProject) {
		this.nameProject = nameProject;
		this.endDate = endDate;
		this.descriptionProject = descriptionProject;
	}
	
	public String getNameProject() { return nameProject; }
	public String getEndDate() { return endDate; }
	public String getDescriptionProject() { return descriptionProject; }
}
