package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import javax.persistence.*;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.CurriculumVitaeDto;

@Entity
@Table(indexes= {@Index(name="cvType_id", columnList="cvType")})
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long cv_genVal;
	int yearsInWork;
	@OneToOne(cascade=CascadeType.REMOVE)
	Skills skills;
	String[] companyName;
	@OneToOne(cascade=CascadeType.REMOVE)
	Verification verification;
	@Column(name="cvType", nullable = false)
	@Enumerated(EnumType.STRING)
	CvType cvType;
	@Column(nullable = false)
	boolean enable = true;
	LocalDate dateOfEnable = LocalDate.now();
	int minSalary;
	@ManyToOne()
	JobSeekerProfile jobSeekerProfile;
	
	public CurriculumVitae() { }
	public CurriculumVitae(JobSeekerProfile jobSeekerProfile, Verification verification, Skills skills,
			CurriculumVitaeDto curriculumVitaeDto) {
		this.yearsInWork = curriculumVitaeDto.getYearsInWork();
		this.cvType = CvType.valueOf(curriculumVitaeDto.getCvType());
		this.skills = skills;
		this.companyName = curriculumVitaeDto.getCompanyName();
		this.verification = verification;
		
		this.minSalary = curriculumVitaeDto.getMinSalary();
		this.jobSeekerProfile = jobSeekerProfile;
	}
	
	public int getYearsInWork() { return yearsInWork; }
	public void setYearsInWork(int yearsInWork) { this.yearsInWork = yearsInWork; }
	public Skills getSkills() { return skills; }
	public String[] getCompanyName() { return companyName; }
	public void setCompanyName(String[] companyName) { this.companyName = companyName; }
	public Verification getVerification() { return verification; }
	public boolean isEnable() { return enable; }
	public void setEnable(boolean enable) { this.enable = enable; }
	public LocalDate getDateOfEnable() { return dateOfEnable; }
	public void setDateOfEnable(LocalDate dateOfEnable) { this.dateOfEnable = dateOfEnable; }
	public CvType getCvType() { return cvType; }
	public int getMinSalary() { return minSalary; }
	public void setMinSalary(int minSalary) { this.minSalary = minSalary; }
	public JobSeekerProfile getJobSeekerProfile() { return jobSeekerProfile; }
	
	public CurriculumVitaeDto getCurriculumVitaeDto() {
		return new CurriculumVitaeDto(jobSeekerProfile.getLogin(), yearsInWork, skills.getSkills(),
				companyName, verification.getVerificationDto(), cvType.toString(),
				dateOfEnable != null ? dateOfEnable.toString() : "", enable, minSalary);
	}
	
	public void update(CurriculumVitaeDto cvDto) {
		this.yearsInWork = cvDto.getYearsInWork();
		this.companyName = cvDto.getCompanyName();
		this.minSalary = cvDto.getMinSalary();
	}
	
	public void enable() {
		this.enable = true;
		this.dateOfEnable = LocalDate.now();
	}
	
	public void disable() {
		this.enable = false;
		this.dateOfEnable = null;
	}
}