package tel_ran.bank_resume.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.interfaces.job_seeker.IJobSeeker;

@RestController
@CrossOrigin(origins="*")
public class JobSeekerWebService implements JobSeekerRequestType, JobSeekerResponseType{
	@Autowired
	IJobSeeker jobSeekers;
	
	////    job seeker profile request    ////
	
	@RequestMapping(value=CREATE_PROFILE, method=RequestMethod.POST)
	public String createJobSeekerProfile(@RequestBody JobSeekerProfileDto jspDto) {
		return jobSeekers.createJobSeekerProfile(jspDto);
	}
	
	@RequestMapping(value=READ_PROFILE, method=RequestMethod.POST)
	public String readeJobSeekerProfile(@RequestBody AccountDto accountDto) {
		return jobSeekers.readJobSeekerProfile(accountDto);
	}
	
	@RequestMapping(value=UPDATE_PROFILE, method=RequestMethod.POST)
	public String updateJobSeekerProfile(@RequestBody JobSeekerProfileDto jspDto) {
		return jobSeekers.updateJobSeekerProfile(jspDto);
	}
	
	@RequestMapping(value=DELETE_PROFILE, method=RequestMethod.POST)
	public String deleteJobSeekerProfile(@RequestBody AccountDto accountDto) {
		return jobSeekers.removeJobSeekerProfile(accountDto, true);
	}
	
	@RequestMapping(value=RESTORE_PROFILE, method=RequestMethod.POST)
	public String restoreJobSeekerProfile(@RequestBody AccountDto accountDto) {
		return jobSeekers.removeJobSeekerProfile(accountDto, false);
	}
	
	////    job seeker cv request    ////
	
	@RequestMapping(value=CREATE_CV, method=RequestMethod.POST)
	public String createJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.createJobSeekerCv(cvDto);
	}
	
	@RequestMapping(value=READ_CV, method=RequestMethod.POST)
	public String readJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.readJobSeekerCv(cvDto);
	}
	
	@RequestMapping(value=READ_ALL_CV, method=RequestMethod.POST)
	public String readJobSeekerAllCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.readJobSeekerAllCv(cvDto);
	}
	
	@RequestMapping(value=UPDATE_CV, method=RequestMethod.POST)
	public String updateJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.updateJobSeekerCv(cvDto);
	}
	
	@RequestMapping(value=DELETE_CV, method=RequestMethod.POST)
	public String deleteJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.deleteJobSeekerCv(cvDto);
	}
	
	@RequestMapping(value=ENABLE_CV, method=RequestMethod.POST)
	public String enableJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.setEnableJobSeekerCv(cvDto, true);
	}
	
	@RequestMapping(value=ENABLE_ALL_CV, method=RequestMethod.POST)
	public String enableJobSeekerAllCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.enableJobSeekerAllCv(cvDto);
	}
	
	@RequestMapping(value=DISABLE_CV, method=RequestMethod.POST)
	public String disableJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.setEnableJobSeekerCv(cvDto, false);
	}
	
	@RequestMapping(value=VER_CV_IN_PROC, method=RequestMethod.POST)
	public String verifeJobSeekerCv(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.verifyJobSeekerCv(cvDto, VerificationStatus.IN_PROGRESS);
	}
	
	////    job seeker fields visibility request    ////
	
	@RequestMapping(value=UPDATE_VISIBILITY, method=RequestMethod.POST)
	public String updateJobSeekerVisibility(@RequestBody FieldsVisibilityDto fvDto) {
		return jobSeekers.updateJobSeekerVisibility(fvDto);
	}
	
	////    search job seeker request    ////
	
	@RequestMapping(value=SEARCH_JOB_SEEKERS, method=RequestMethod.POST)
	public String searchJobSeekers(@RequestBody CurriculumVitaeDto cvDto) {
		return jobSeekers.searchJobSeekers(cvDto);
	}
}
