package tel_ran.bank_resume.api.dto;

public class PersonDataDto {
	String firstName;
	String lastName;
	String birthDate;
	int phone;
	String location;
	String photoUrl;
	
	public PersonDataDto() { }
	public PersonDataDto(String firstName, String lastName, String birthDate, int phone,
			String location, String photoUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.location = location;
		this.photoUrl = photoUrl;
	}
	
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getBirthDate() { return birthDate; }
	public int getPhone() { return phone; }
	public String getLocation() { return location; }
	public String getPhotoUrl() { return photoUrl; };
}
