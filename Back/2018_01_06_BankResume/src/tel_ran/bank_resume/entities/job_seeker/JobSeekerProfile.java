package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.*;
import java.util.*;

@Entity
@Table(indexes={@Index(name="jsp_login_id",columnList="jsp_login")})
public class JobSeekerProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int jsp_genVal;
	@Column(name="jsp_login", unique=true, nullable=false)
	String login;
	@Column(columnDefinition = "boolean default false", nullable = false)
	boolean remove;
	@Column(nullable=false, columnDefinition="varchar(3) default 'doc'")
	String downloadType;
	@OneToMany(mappedBy="jobSeekerProfile")
	List<CurriculumVitae> curriculumVitaes;
	@OneToOne
	PersonData personData;
	@OneToOne
	ProfessionalData professionalData;
	@OneToOne
	FieldsVisibility fieldsVisibility;
	
	public JobSeekerProfile() { }
	public JobSeekerProfile(String login, String downloadType, PersonData personData,
			ProfessionalData professionalData, FieldsVisibility fieldsVisibility) {
		this.login = login;
		this.downloadType = downloadType;
		this.personData = personData;
		this.professionalData = professionalData;
		this.fieldsVisibility = fieldsVisibility;
	}
	
	public boolean isRemove() { return remove; }
	public void setRemove(boolean remove) { this.remove = remove; }
	public String getDownloadType() { return downloadType; }
	public void setDownloadType(String downloadType) { this.downloadType = downloadType; }
	public PersonData getPersonData() { return personData; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	public FieldsVisibility getFieldsVisibility() { return fieldsVisibility; }
	public String getLogin() { return login; }
	public List<CurriculumVitae> getCurriculumVitaes() { return curriculumVitaes; }
	
	public JobSeekerProfileDto getJobSeekerProfileDto() {
		return new JobSeekerProfileDto(login, downloadType, getCurriculumVitaesDto(),
				personData.getPersonDataDto(), professionalData.getProfessionalDataDto(),
				fieldsVisibility.getFieldsVisibilityDto());
	}
	
	private CurriculumVitaeDto[] getCurriculumVitaesDto() {
		int cvSize = curriculumVitaes.size();
		CurriculumVitaeDto[] curriculumVitaesDto = new CurriculumVitaeDto[cvSize];
		for (int i = 0; i < cvSize; i++) {
			curriculumVitaesDto[i] = curriculumVitaes.get(i).getCurriculumVitaeDto();
		}
		return curriculumVitaesDto;
	}
}
