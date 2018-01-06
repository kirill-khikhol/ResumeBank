package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.FieldsVisibilityDto;

@Entity
public class FieldsVisibility {
	@Id
	String fieldsVis_login;
	boolean email = true;
	boolean firstName = true;
	boolean lastName = true;
	boolean birthDate = true;
	boolean phone = true;
	boolean location = true;
	boolean photo = true;
	boolean aboutMyself = true;
	boolean linkedin = true;
	boolean educations = true;
	boolean languages = true;
	boolean coursesAndCertificates = true;
	boolean recomendations = true;
	boolean experiences = true;
	boolean projects = true;
	boolean minSalary = true;
	
	public FieldsVisibility() { }
	public FieldsVisibility(String login) {
		this.fieldsVis_login = login;
	}
	
	public String getFieldsVis_login() { return fieldsVis_login; }
	public boolean isEmail() { return email; }
	public void setEmail(boolean email) { this.email = email; }
	public boolean isFirstName() { return firstName; }
	public void setFirstName(boolean firstName) { this.firstName = firstName; }
	public boolean isLastName() { return lastName; }
	public void setLastName(boolean lastName) { this.lastName = lastName; }
	public boolean isBirthDate() { return birthDate; }
	public void setBirthDate(boolean birthDate) { this.birthDate = birthDate; }
	public boolean isPhone() { return phone; }
	public void setPhone(boolean phone) { this.phone = phone; }
	public boolean isLocation() { return location; }
	public void setLocation(boolean location) { this.location = location; }
	public boolean isPhoto() { return photo; }
	public void setPhoto(boolean photo) { this.photo = photo; }
	public boolean isAboutMyself() { return aboutMyself; }
	public void setAboutMyself(boolean aboutMyself) { this.aboutMyself = aboutMyself; }
	public boolean isLinkedin() { return linkedin; }
	public void setLinkedin(boolean linkedin) { this.linkedin = linkedin; }
	public boolean isEducations() { return educations; }
	public void setEducations(boolean educations) { this.educations = educations; }
	public boolean isLanguages() { return languages; }
	public void setLanguages(boolean languages) { this.languages = languages; }
	public boolean isCoursesAndCertificates() { return coursesAndCertificates; }
	public void setCoursesAndCertificates(boolean coursesAndCertificates) { this.coursesAndCertificates = coursesAndCertificates; }
	public boolean isRecomendations() { return recomendations; }
	public void setRecomendations(boolean recomendations) { this.recomendations = recomendations; }
	public boolean isExperiences() { return experiences; }
	public void setExperiences(boolean experiences) { this.experiences = experiences; }
	public boolean isProjects() { return projects; }
	public void setProjects(boolean projects) { this.projects = projects; }
	public boolean isMinSalary() { return minSalary; }
	public void setMinSalary(boolean minSalary) { this.minSalary = minSalary; }
	
	public FieldsVisibilityDto getFieldsVisibilityDto() {
		return new FieldsVisibilityDto(fieldsVis_login, email, firstName, lastName, birthDate, phone,
				location, photo, aboutMyself, linkedin, educations, languages,
				coursesAndCertificates, recomendations, experiences, projects, minSalary);
	}
	
	public void update(FieldsVisibilityDto fvDto) {
		this.email = fvDto.isEmail();
		this.firstName = fvDto.isFirstName();
		this.lastName = fvDto.isLastName();
		this.birthDate = fvDto.isBirthDate();
		this.phone = fvDto.isPhone();
		this.location = fvDto.isLocation();
		this.photo = fvDto.isPhoto();
		this.aboutMyself = fvDto.isAboutMyself();
		this.linkedin = fvDto.isLinkedin();
		this.educations = fvDto.isEducations();
		this.languages = fvDto.isLanguages();
		this.coursesAndCertificates = fvDto.isCoursesAndCertificates();
		this.recomendations = fvDto.isRecomendations();
		this.experiences = fvDto.isExperiences();
		this.projects = fvDto.isProjects();
		this.minSalary = fvDto.isMinSalary();
	}
}
