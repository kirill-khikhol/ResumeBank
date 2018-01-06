package tel_ran.bank_resume.api.dto;

public class FieldsVisibilityDto {
	String login;
	boolean email;
	boolean firstName;
	boolean lastName;
	boolean birthDate;
	boolean phone;
	boolean location;
	boolean photo;
	boolean aboutMyself;
	boolean linkedin;
	boolean educations;
	boolean languages;
	boolean coursesAndCertificates;
	boolean recomendations;
	boolean experiences;
	boolean projects;
	boolean minSalary;
	
	public FieldsVisibilityDto() { }
	public FieldsVisibilityDto(String login, boolean email, boolean firstName, boolean lastName, boolean birthDate,
			boolean phone, boolean location, boolean photo, boolean aboutMyself, boolean linkedin, boolean educations,
			boolean languages, boolean coursesAndCertificates, boolean recomendations, boolean experiences,
			boolean projects, boolean minSalary) {
		this.login = login;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.location = location;
		this.photo = photo;
		this.aboutMyself = aboutMyself;
		this.linkedin = linkedin;
		this.educations = educations;
		this.languages = languages;
		this.coursesAndCertificates = coursesAndCertificates;
		this.recomendations = recomendations;
		this.experiences = experiences;
		this.projects = projects;
		this.minSalary = minSalary;
	}
	
	public String getLogin() { return login; }
	public boolean isEmail() { return email; }
	public boolean isFirstName() { return firstName; }
	public boolean isLastName() { return lastName; }
	public boolean isBirthDate() { return birthDate; }
	public boolean isPhone() { return phone; }
	public boolean isLocation() { return location; }
	public boolean isPhoto() { return photo; }
	public boolean isAboutMyself() { return aboutMyself; }
	public boolean isLinkedin() { return linkedin; }
	public boolean isEducations() { return educations; }
	public boolean isLanguages() { return languages; }
	public boolean isCoursesAndCertificates() { return coursesAndCertificates; }
	public boolean isRecomendations() { return recomendations; }
	public boolean isExperiences() { return experiences; }
	public boolean isProjects() { return projects; }
	public boolean isMinSalary() { return minSalary; }
}
