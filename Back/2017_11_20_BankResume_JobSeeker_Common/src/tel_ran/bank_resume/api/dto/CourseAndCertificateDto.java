package tel_ran.bank_resume.api.dto;

public class CourseAndCertificateDto {
	String nameOfCourse;
	String endDate;
	
	public CourseAndCertificateDto() { }
	public CourseAndCertificateDto(String nameOfCourse, String endDate) {
		this.nameOfCourse = nameOfCourse;
		this.endDate = endDate;
	}
	
	public String getNameOfCourse() { return nameOfCourse; }
	public String getEndDate() { return endDate; }
}
