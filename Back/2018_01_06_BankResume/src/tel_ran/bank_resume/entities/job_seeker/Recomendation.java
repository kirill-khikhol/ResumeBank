package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;
import tel_ran.bank_resume.api.dto.RecomendationDto;
import tel_ran.bank_resume.interfaces.job_seeker.JobSeekerProfDataEntity;

@Entity
public class Recomendation implements JobSeekerProfDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long rec_genVal;
	String firstName;
	String lastName;
	String companyName;
	String position;
	int phone;
	@ManyToOne
	ProfessionalData professionalData;
	
	public Recomendation() { }
	public Recomendation(ProfessionalData professionalData, RecomendationDto recomendationDto) {
		this.firstName = recomendationDto.getFirstName();
		this.lastName = recomendationDto.getLastName();
		this.companyName = recomendationDto.getCompanyName();
		this.position = recomendationDto.getPosition();
		this.phone = recomendationDto.getPhone();
		this.professionalData = professionalData;
	}
	public <D, E> Recomendation(D link, E entityDto) {
		try {
			RecomendationDto recomendationDto = (RecomendationDto) entityDto;
			ProfessionalData professionalData = (ProfessionalData) link;
			this.firstName = recomendationDto.getFirstName();
			this.lastName = recomendationDto.getLastName();
			this.companyName = recomendationDto.getCompanyName();
			this.position = recomendationDto.getPosition();
			this.phone = recomendationDto.getPhone();
			this.professionalData = professionalData;
		} catch(ClassCastException e) {}
	}
	
	public String getCompanyName() { return companyName; }
	public void setCompanyName(String companyName) { this.companyName = companyName; }
	public String getPosition() { return position; }
	public void setPosition(String position) { this.position = position; }
	public int getPhone() { return phone; }
	public void setPhone(int phone) { this.phone = phone; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public ProfessionalData getProfessionalData() { return professionalData; }
	
	public RecomendationDto getRecomendationDto() {
		return new RecomendationDto(firstName, lastName, companyName, position, phone);
	}
	
	@Override
	public <E> void update(E entityDto) {
		try {
			RecomendationDto recomendationDto = (RecomendationDto) entityDto;
			this.firstName = recomendationDto.getFirstName();
			this.lastName = recomendationDto.getLastName();
			this.companyName = recomendationDto.getCompanyName();
			this.position = recomendationDto.getPosition();
			this.phone = recomendationDto.getPhone();
		} catch(ClassCastException e) {}
	}
}
