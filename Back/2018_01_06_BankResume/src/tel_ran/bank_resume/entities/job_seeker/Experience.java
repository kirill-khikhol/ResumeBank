package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class Experience implements JobSeekerProfDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long exp_genVal;
	String companyName;
	String position;
	LocalDate startDate;
	LocalDate endDate;
	@OneToMany(mappedBy="experience",cascade=CascadeType.REMOVE)
	List<Project> projects;
	@ManyToOne
	ProfessionalData professionalData;
	
	public Experience() { }
	public Experience(ProfessionalData professionalData, ExperienceDto experinceDto) {
		this.companyName = experinceDto.getCompanyName();
		this.position = experinceDto.getPosition();
		this.startDate = LocalDate.parse(experinceDto.getStartDate());
		this.endDate = LocalDate.parse(experinceDto.getEndDate());
		this.professionalData = professionalData;
	}
	public <D,E> Experience(D link, E entityDto) {
		try {
			ExperienceDto experienceDto = (ExperienceDto) entityDto;
			ProfessionalData professionalData = (ProfessionalData) link;
			this.companyName = experienceDto.getCompanyName();
			this.position = experienceDto.getPosition();
			this.startDate = LocalDate.parse(experienceDto.getStartDate());
			this.endDate = LocalDate.parse(experienceDto.getEndDate());
			this.professionalData = professionalData;
		} catch(ClassCastException e) {}
	}
	
	public String getCompanyName() { return companyName; }
	public String getPosition() { return position; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getEndDate() { return endDate; }
	public List<Project> getProjects() { return projects; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	
	public ExperienceDto getExperienceDto() {
		return new ExperienceDto(companyName, position, startDate.toString(), endDate.toString(),
				getProjectsDto());
	}
	
	private ProjectDto[] getProjectsDto() {
		int pSize = projects.size();
		ProjectDto[] projectsDto = new ProjectDto[pSize];
		for (int i = 0; i < pSize; i++) {
			projectsDto[i] = projects.get(i).getProjectDto();
		}
		return projectsDto;
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			ExperienceDto experienceDto = (ExperienceDto) entityDto;
			this.companyName = experienceDto.getCompanyName();
			this.position = experienceDto.getPosition();
			this.startDate = LocalDate.parse(experienceDto.getStartDate());
			this.endDate = LocalDate.parse(experienceDto.getEndDate());
		} catch(ClassCastException e) {}
	}
}
