package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import javax.persistence.*;
import tel_ran.bank_resume.api.dto.CourseAndCertificateDto;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class CourseAndCertificate implements JobSeekerProfDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long course_genVal;
	String nameOfCourse;
	LocalDate endDate;
	@ManyToOne
	ProfessionalData professionalData;
	
	public CourseAndCertificate() { }
	public CourseAndCertificate(ProfessionalData professionalData, CourseAndCertificateDto courseAndCertificateDto) {
		this.nameOfCourse = courseAndCertificateDto.getNameOfCourse();
		this.endDate = LocalDate.parse(courseAndCertificateDto.getEndDate());
		this.professionalData = professionalData;
	}
	public <D, E> CourseAndCertificate(D link, E entityDto) {
		try {
			CourseAndCertificateDto courseAndCertificateDto = (CourseAndCertificateDto) entityDto;
			ProfessionalData professionalData = (ProfessionalData) link;
			this.nameOfCourse = courseAndCertificateDto.getNameOfCourse();
			this.endDate = LocalDate.parse(courseAndCertificateDto.getEndDate());
			this.professionalData = professionalData;
		} catch (ClassCastException e) {}
	}
	
	public String getNameOfCourse() { return nameOfCourse; }
	public LocalDate getEndDate() { return endDate; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	
	public CourseAndCertificateDto getCourseAndCertificateDto() {
		return new CourseAndCertificateDto(nameOfCourse, endDate.toString());
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			CourseAndCertificateDto courseAndCertificateDto = (CourseAndCertificateDto) entityDto;
			this.nameOfCourse = courseAndCertificateDto.getNameOfCourse();
			this.endDate = LocalDate.parse(courseAndCertificateDto.getEndDate());
		} catch(ClassCastException e) {}
	}
}
