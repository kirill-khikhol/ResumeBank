package tel_ran.bank_resume.api.dto;

public class RecomendationDto {
	String firstName;
	String lastName;
	String companyName;
	String position;
	int phone;
	
	public RecomendationDto() { }
	public RecomendationDto(String firstName, String lastName, String companyName, String position, int phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.position = position;
		this.phone = phone;
	}
	
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getCompanyName() { return companyName; }
	public String getPosition() { return position; }
	public int getPhone() { return phone; }
}
