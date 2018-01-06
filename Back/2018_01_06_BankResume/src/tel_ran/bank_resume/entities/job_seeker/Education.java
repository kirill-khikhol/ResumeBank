package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import javax.persistence.*;
import tel_ran.bank_resume.api.dto.EducationDto;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class Education implements JobSeekerProfDataEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long edu_genVal;
	String nameUniversity;
	String nameSpeciality;
	String educationDegree;
	LocalDate startDate;
	LocalDate endDate;
	@ManyToOne
	ProfessionalData professionalData;
	
	public Education() { }
	public Education(ProfessionalData professionalData, EducationDto educationDto) {
		this.nameUniversity = educationDto.getNameUniversity();
		this.nameSpeciality = educationDto.getNameSpeciality();
		this.educationDegree = educationDto.getEducationDegree();
		this.startDate = LocalDate.parse(educationDto.getStartDate());
		this.endDate = LocalDate.parse(educationDto.getEndDate());
		this.professionalData = professionalData;
	}
	public <D, E> Education(D link, E entityDto) {
		try {
			EducationDto educationDto = (EducationDto) entityDto;
			ProfessionalData professionalData = (ProfessionalData) link;
			this.nameUniversity = educationDto.getNameUniversity();
			this.nameSpeciality = educationDto.getNameSpeciality();
			this.educationDegree = educationDto.getEducationDegree();
			this.startDate = LocalDate.parse(educationDto.getStartDate());
			this.endDate = LocalDate.parse(educationDto.getEndDate());
			this.professionalData = professionalData;
		} catch(ClassCastException e) {}
	}
	
	public String getNameUniversity() { return nameUniversity; }
	public String getNameSpeciality() { return nameSpeciality; }
	public String getEducationDegree() { return educationDegree; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getEndDate() { return endDate; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	
	public EducationDto getEducationDto() {
		return new EducationDto(nameUniversity, nameSpeciality, educationDegree,
				startDate.toString(), endDate.toString());
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			EducationDto eduDto = (EducationDto) entityDto;
			this.nameUniversity = eduDto.getNameUniversity();
			this.nameSpeciality = eduDto.getNameSpeciality();
			this.educationDegree = eduDto.getEducationDegree();
			this.startDate = LocalDate.parse(eduDto.getStartDate());
			this.endDate = LocalDate.parse(eduDto.getEndDate());	
		} catch(ClassCastException e) {}
	}
}
