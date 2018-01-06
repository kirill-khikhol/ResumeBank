package tel_ran.bank_resume.interfaces.job_seeker;

import tel_ran.bank_resume.api.dto.*;

public interface IJobSeeker {
	public String createJobSeekerProfile(JobSeekerProfileDto jspDto);
	public String readJobSeekerProfile(AccountDto accountDto);
	public String updateJobSeekerProfile(JobSeekerProfileDto jspDto);
	public String removeJobSeekerProfile(AccountDto accountDto, boolean remove);
	
	
	public String createJobSeekerCv(CurriculumVitaeDto cvDto);
	public String readJobSeekerCv(CurriculumVitaeDto cvDto);
	public String readJobSeekerAllCv(CurriculumVitaeDto cvDto);
	public String updateJobSeekerCv(CurriculumVitaeDto cvDto);
	public String deleteJobSeekerCv(CurriculumVitaeDto cvDto);
	
	public String setEnableJobSeekerCv(CurriculumVitaeDto cvDto, boolean enable);
	public String enableJobSeekerAllCv(CurriculumVitaeDto cvDto);
	public String verifyJobSeekerCv(CurriculumVitaeDto cvDto, String status);
	
	public String updateJobSeekerVisibility(FieldsVisibilityDto fvDto);
	
	public String searchJobSeekers(CurriculumVitaeDto cvDto);
}
