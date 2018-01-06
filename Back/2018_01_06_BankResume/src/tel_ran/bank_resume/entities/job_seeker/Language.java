package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.LanguageDto;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class Language implements JobSeekerProfDataEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long lang_genVal;
	String languageName;
	String languageLevel;
	@ManyToOne
	ProfessionalData professionalData;
	
	public Language() { }
	public Language(ProfessionalData professionalData, LanguageDto languageDto) {
		this.languageName = languageDto.getLanguageName();
		this.languageLevel = languageDto.getLanguageLevel();
		this.professionalData = professionalData;
	}
	public <D,E> Language(D link, E entityDto) {
		try {
			LanguageDto langDto = (LanguageDto) entityDto;
			ProfessionalData professionalData = (ProfessionalData) link;
			this.languageName = langDto.getLanguageName();
			this.languageLevel = langDto.getLanguageLevel();
			this.professionalData = professionalData;
		} catch(ClassCastException e) {}
	}
	
	public String getLanguageLevel() { return languageLevel; }
	public void setLanguageLevel(String languageLevel) { this.languageLevel = languageLevel; }
	public String getLanguageName() { return languageName; }
	public void setLanguageName(String languageName) { this.languageLevel = languageName; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	
	public LanguageDto getLanguageDto() {
		LanguageDto langDto = new LanguageDto(languageName, languageLevel);
		return langDto;
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			LanguageDto langDto = (LanguageDto) entityDto;
			this.languageName = langDto.getLanguageName();
			this.languageLevel = langDto.getLanguageLevel();
		} catch(ClassCastException e) {}
	}
}
