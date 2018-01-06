package tel_ran.bank_resume.api.dto;

public class VerificationDto {
	String date;
	String verificationStatus;
	
	public VerificationDto() { }
	public VerificationDto(String date, String verificationStatus) {
		this.date = date;
		this.verificationStatus = verificationStatus;
	}
	
	public String getDate() { return date; }
	public String getVerificationStatus() { return verificationStatus; }
}
