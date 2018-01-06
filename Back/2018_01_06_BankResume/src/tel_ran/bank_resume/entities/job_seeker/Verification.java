package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;

import tel_ran.bank_resume.api.VerificationStatus;
import tel_ran.bank_resume.api.dto.VerificationDto;
import java.time.LocalDate;

@Entity
public class Verification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long ver_genVal;
	LocalDate date;
	String examinerName;
	int result;
	String comment;
	@Column(nullable=false)
	String verificationStatus = VerificationStatus.NO;
	
	public Verification() { }
	public Verification(VerificationDto verificationDto) {
		this.date = LocalDate.parse(verificationDto.getDate());
		this.verificationStatus = verificationDto.getVerificationStatus();
	}
	
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	public int getResult() { return result; }
	public void setResult(int result) { this.result = result; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	public String getVerificationStatus() { return verificationStatus; }
	public void setVerificationStatus(String verificationStatus) { this.verificationStatus = verificationStatus; }
	public String getExaminerName() { return examinerName; }
	public void setExaminerName(String examinerName) { this.examinerName = examinerName; }
	
	public VerificationDto getVerificationDto() {
		return new VerificationDto(date != null ? date.toString() : "", verificationStatus);
	}
}
