package tel_ran.bank_resume.entities.job_seeker;

import javax.persistence.*;

@Entity
public class Skills {
	@Id
	@GeneratedValue
	long skills_id;
	String[] skills;
	
	public Skills() { }
	public Skills(String[] skills) {
		this.skills = skills;
	}
	
	public String[] getSkills() { return skills; }
	public void setSkills(String[] skills) { this.skills = skills; }
}
