package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;

import tel_ran.bank_resume.api.dto.CourseAndCertificateDto;
import tel_ran.bank_resume.api.dto.EducationDto;
import tel_ran.bank_resume.api.dto.ExperienceDto;
import tel_ran.bank_resume.api.dto.LanguageDto;
import tel_ran.bank_resume.api.dto.ProfessionalDataDto;
import tel_ran.bank_resume.api.dto.RecomendationDto;

import java.util.*;

@Entity
public class ProfessionalData {
	@Id
	String profData_login;
	String aboutMySelf;
	String linkedinUrl;
	@OneToMany(mappedBy="professionalData")
	List<Education> educations;
	@OneToMany(mappedBy="professionalData")
	List<Language> languages;
	@OneToMany(mappedBy="professionalData")
	List<CourseAndCertificate> cousesAndSertificates;
	@OneToMany(mappedBy="professionalData")
	List<Recomendation> recomendations;
	@OneToMany(mappedBy="professionalData")
	List<Experience> experiences;
	
	public ProfessionalData() { }
	public ProfessionalData(String login, ProfessionalDataDto professionalDataDto) {
		this.profData_login = login;
		this.aboutMySelf = professionalDataDto.getAboutMySelf();
		this.linkedinUrl = professionalDataDto.getLinkedinUrl();
	}
	
	public String getAboutMySelf() { return aboutMySelf; }
	public void setAboutMySelf(String aboutMySelf) { this.aboutMySelf = aboutMySelf; }
	public String getLogin() { return profData_login; }
	public String getLinkedinUrl() { return linkedinUrl; }
	public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }
	public List<Education> getEducations() { return educations; }
	public List<Language> getLanguages() { return languages; }
	public List<CourseAndCertificate> getCousesAndSertificates() { return cousesAndSertificates; }
	public List<Recomendation> getRecomendations() { return recomendations; }
	public List<Experience> getExperiences() { return experiences; }
	
	public ProfessionalDataDto getProfessionalDataDto() {
		return new ProfessionalDataDto(aboutMySelf, linkedinUrl, getEducationsDto(),
				getlanguagesDto(), getCoursesAndCertificatesDto(), getRecomendationsDto(),
				getExperiencesDto());
	}
	
	public void update(ProfessionalDataDto profDataDto) {
		this.aboutMySelf = profDataDto.getAboutMySelf();
		this.linkedinUrl = profDataDto.getLinkedinUrl();
	}
	
	private ExperienceDto[] getExperiencesDto() {
		int eSize = experiences.size();
		ExperienceDto[] experiencesDto = new ExperienceDto[eSize];
		for (int i = 0; i < eSize; i++) {
			experiencesDto[i] = experiences.get(i).getExperienceDto();
		}
		return experiencesDto;
	}
	private RecomendationDto[] getRecomendationsDto() {
		int rSize = recomendations.size();
		RecomendationDto[] recomendationsDto = new RecomendationDto[rSize];
		for (int i = 0; i < rSize; i++) {
			recomendationsDto[i] = recomendations.get(i).getRecomendationDto();
		}
		return recomendationsDto;
	}
	
	private CourseAndCertificateDto[] getCoursesAndCertificatesDto() {
		int cacSize = cousesAndSertificates.size();
		CourseAndCertificateDto[] coursesAndCertificatesDto = new CourseAndCertificateDto[cacSize];
		for (int i = 0; i < cacSize; i++) {
			coursesAndCertificatesDto[i] = cousesAndSertificates.get(i).getCourseAndCertificateDto();
		}
		return coursesAndCertificatesDto;
	}
	
	private LanguageDto[] getlanguagesDto() {
		int lSize = languages.size();
		LanguageDto[] languagesDto = new LanguageDto[lSize];
		for (int i = 0; i < lSize; i++) {
			languagesDto[i] = languages.get(i).getLanguageDto();
		}
		return languagesDto;
	}
	
	private EducationDto[] getEducationsDto() {
		int eSize = educations.size();
		EducationDto[] educationsDto = new EducationDto[eSize ];
		for (int i = 0; i < eSize; i++) {
			educationsDto[i] = educations.get(i).getEducationDto();
		}
		return educationsDto;
	}
}
