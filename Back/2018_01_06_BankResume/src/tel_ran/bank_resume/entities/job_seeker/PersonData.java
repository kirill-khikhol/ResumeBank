package tel_ran.bank_resume.entities.job_seeker;

import java.time.LocalDate;
import javax.persistence.*;
import tel_ran.bank_resume.api.dto.PersonDataDto;

@Entity
public class PersonData {
	@Id
	@Column(nullable=false)
	String persData_login;
	@Column(nullable=false)
	String firstName;
	@Column(nullable=false)
	String lastName;
	@Column(nullable=false)
	LocalDate birthDate;
	@Column(nullable=false)
	int phone;
	@Column(nullable=false)
	String location;
	@Column(nullable=false)
	String photoUrl;
	
	public PersonData() { };
	public PersonData(String login, PersonDataDto personDataDto) {
		this.persData_login = login;
		this.firstName = personDataDto.getFirstName();
		this.lastName = personDataDto.getLastName();
		this.birthDate = LocalDate.parse(personDataDto.getBirthDate());
		this.phone = personDataDto.getPhone();
		this.location = personDataDto.getLocation();
		this.photoUrl = personDataDto.getPhotoUrl();
	}
	
	public int getPhone() { return phone; }
	public void setPhone(int phone) { this.phone = phone; }
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	public String getPhotoUrl() { return photoUrl; }
	public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
	public String getPersData_login() { return persData_login; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public LocalDate getBirthDate() { return birthDate; }
	
	public PersonDataDto getPersonDataDto() {
		return new PersonDataDto(firstName, lastName, birthDate.toString(), phone, location, photoUrl);
	}
	
	public void update(PersonDataDto persDataDto) {
		this.firstName = persDataDto.getFirstName();
		this.lastName = persDataDto.getLastName();
		this.phone = persDataDto.getPhone();
		this.location = persDataDto.getLocation();
		this.photoUrl = persDataDto.getPhotoUrl();
	}
}
