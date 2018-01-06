package tel_ran.bank_resume.api.dto;

public class LanguageDto {
	String languageName;
	String languageLevel;
	
	public LanguageDto() { }
	public LanguageDto(String languageName, String languageLevel) {
		this.languageName = languageName;
		this.languageLevel = languageLevel;
	}
	
	public String getLanguageLevel() { return languageLevel; }
	public String getLanguageName() { return languageName; }
}
