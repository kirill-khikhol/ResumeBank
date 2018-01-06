package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import javax.persistence.*;
import tel_ran.bank_resume.api.dto.ProjectDto;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class Project implements JobSeekerProfDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long proj_genVal;
	String nameProject;
	LocalDate endDate;
	String descriptionProject;
	@ManyToOne
	Experience experience;
	
	public Project() { }
	public Project(Experience experience, ProjectDto projectDto) {
		this.nameProject = projectDto.getNameProject();
		this.endDate = LocalDate.parse(projectDto.getEndDate());
		this.descriptionProject = projectDto.getDescriptionProject();
		this.experience = experience;
	}
	public <D,E> Project(D link, E entityDto) {
		try {
			ProjectDto projectDto = (ProjectDto) entityDto;
			Experience experience = (Experience) link;
			this.nameProject = projectDto.getNameProject();
			this.endDate = LocalDate.parse(projectDto.getEndDate());
			this.descriptionProject = projectDto.getDescriptionProject();
			this.experience = experience;
		} catch(ClassCastException e) {}
	}
	
	public String getNameProject() { return nameProject; }
	public LocalDate getEndDate() { return endDate; }
	public String getDescriptionProject() { return descriptionProject; }
	public Experience getExperience() { return experience; }
	
	public ProjectDto getProjectDto() {
		return new ProjectDto(nameProject, endDate.toString(), descriptionProject);
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			ProjectDto projectDto = (ProjectDto) entityDto;
			this.nameProject = projectDto.getNameProject();
			this.endDate = LocalDate.parse(projectDto.getEndDate());
			this.descriptionProject = projectDto.getDescriptionProject();
		} catch(ClassCastException e) {}
	}
}
