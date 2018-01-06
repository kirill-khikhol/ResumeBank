package tel_ran.bank_resume.api;

public interface JobSeekerRequestType {
	String CREATE_PROFILE = "/jobSeeker/createProfile";
	String READ_PROFILE = "/jobSeeker/readProfile";
	String UPDATE_PROFILE = "/jobSeeker/updateProfile";
	String DELETE_PROFILE = "/jobSeeker/deleteProfile";
	String RESTORE_PROFILE = "/jobSeeker/restoreProfile";
	
	String CREATE_CV = "/jobSeeker/createCv";
	String READ_CV = "/jobSeeker/readCv";
	String READ_ALL_CV = "/jobSeeker/readAllCv";
	String UPDATE_CV = "/jobSeeker/updateCv";
	String DELETE_CV = "/jobSeeker/deleteCv";
	String ENABLE_CV = "/jobSeeker/enableCv";
	String ENABLE_ALL_CV = "/jobSeeker/enableAllCv";
	String DISABLE_CV = "/jobSeeker/disableCv";
	String VER_CV_IN_PROC = "/jobSeeker/verifyCv/inProcess";
	
	String UPDATE_VISIBILITY = "/jobSeeker/updateVisibility";
	
	String SEARCH_JOB_SEEKERS = "/company/searchJobSeekers";
}
