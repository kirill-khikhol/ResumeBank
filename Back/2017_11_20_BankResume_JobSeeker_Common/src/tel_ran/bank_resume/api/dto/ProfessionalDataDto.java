package tel_ran.bank_resume.api.dto;

public class ProfessionalDataDto {
	String aboutMySelf;
	String linkedinUrl;
	EducationDto[] educations;
	LanguageDto[] languages;
	CourseAndCertificateDto[] coursesAndCertificates;
	RecomendationDto[] recomendations;
	ExperienceDto[] experiences;
	
	public ProfessionalDataDto() { }
	public ProfessionalDataDto(String aboutMySelf, String linkedinUrl, EducationDto[] educations,
			LanguageDto[] languages, CourseAndCertificateDto[] coursesAndCertificates,
			RecomendationDto[] recomendations, ExperienceDto[] experiences) {
		this.aboutMySelf = aboutMySelf;
		this.linkedinUrl = linkedinUrl;
		this.educations = educations;
		this.languages = languages;
		this.coursesAndCertificates = coursesAndCertificates;
		this.recomendations = recomendations;
		this.experiences = experiences;
	}
	
	public String getAboutMySelf() { return aboutMySelf; }
	public String getLinkedinUrl() { return linkedinUrl; }
	public EducationDto[] getEducations() { return educations; }
	public LanguageDto[] getLanguages() { return languages; }
	public CourseAndCertificateDto[] getCoursesAndCertificates() { return coursesAndCertificates; }
	public RecomendationDto[] getRecomendations() { return recomendations; }
	public ExperienceDto[] getExperiences() { return experiences; }
}
