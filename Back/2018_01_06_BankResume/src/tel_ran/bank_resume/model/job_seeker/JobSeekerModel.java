package tel_ran.bank_resume.model.job_seeker;

import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.transaction.Transactional;
import org.hibernate.Session;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.job_seeker.*;
import tel_ran.bank_resume.entities.job_seeker.Verification;
import tel_ran.bank_resume.interfaces.job_seeker.*;

public class JobSeekerModel implements IJobSeeker, JobSeekerResponseType{
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	ObjectMapper mapper = new ObjectMapper();
	
	////    Profile methods    ////
	
	@Override
	@Transactional
	public String createJobSeekerProfile(JobSeekerProfileDto jspDto) {
		String login = jspDto.getLogin();
		JobSeekerProfile jsp = findJobSeekerProfile(login);
		if (jsp != null) { return jsp.isRemove() ? REMOVED : EXIST; }
		
		PersonData personData = new PersonData(login, jspDto.getPersonData());
		em.persist(personData);
		
		ProfessionalDataDto profDataDto = jspDto.getProfessionalData();
		ProfessionalData profData = new ProfessionalData(login, profDataDto);
		em.persist(profData);
		
		updateProfDataEntity(null, profDataDto.getEducations(), profData);
		updateProfDataEntity(null, profDataDto.getLanguages(), profData);
		updateProfDataEntity(null, profDataDto.getCoursesAndCertificates(), profData);
		updateProfDataEntity(null, profDataDto.getRecomendations(), profData);
		updateProfDataEntity(null, profDataDto.getExperiences(), profData);
		
		FieldsVisibility fieldsVisibility = new FieldsVisibility(login);
		em.persist(fieldsVisibility);
		
		jsp = new JobSeekerProfile(login, jspDto.getDownloadType(),
				personData  , profData , fieldsVisibility );
		em.persist(jsp);
		
		return OK;
	}
	
	@Override
	public String readJobSeekerProfile(AccountDto accountDto) {
		JobSeekerProfile jsp = findJobSeekerProfile(accountDto.getLogin());
		if (jsp == null) { return NO_FOUND; }
		if (jsp.isRemove()) { return REMOVED; }
		
		try {
			return mapper.writeValueAsString(jsp.getJobSeekerProfileDto());
		} catch (JsonProcessingException e) {
			return FALSE;
		}
	}
	
	@Override
	@Transactional
	public String updateJobSeekerProfile(JobSeekerProfileDto jspDto) {
		JobSeekerProfile jsp = findJobSeekerProfile(jspDto.getLogin());
		if (jsp == null) { return NO_FOUND; }
		if (jsp.isRemove()) { return REMOVED; }
		
		jsp.setDownloadType(jspDto.getDownloadType());
		jsp.getPersonData().update(jspDto.getPersonData());
		
		ProfessionalData profData = jsp.getProfessionalData();
		ProfessionalDataDto profDataDto = jspDto.getProfessionalData();
		em.refresh(profData);
		
		updateProfDataEntity(profData.getEducations(), profDataDto.getEducations(), profData);
		updateProfDataEntity(profData.getLanguages(), profDataDto.getLanguages(), profData);
		updateProfDataEntity(profData.getCousesAndSertificates(), profDataDto.getCoursesAndCertificates(), profData);
		updateProfDataEntity(profData.getRecomendations(), profDataDto.getRecomendations(), profData);
		updateProfDataEntity(profData.getExperiences(), profDataDto.getExperiences(), profData);
		
		profData.update(profDataDto);
		
		return OK;
	}
	
	@Override
	@Transactional
	public String removeJobSeekerProfile(AccountDto accountDto, boolean remove) {
		JobSeekerProfile jsp = findJobSeekerProfile(accountDto.getLogin());
		if (jsp != null) {
			jsp.setRemove(remove);
			for (CurriculumVitae cv : jsp.getCurriculumVitaes()) { cv.setEnable(false); }
			return OK;
		}
		return NO_FOUND;
	}
	
	////    CV methods    ////
	
	@Override
	@Transactional
	public String createJobSeekerCv(CurriculumVitaeDto cvDto) {
		if (cvDto == null) { return WRONG_REQUEST; }
		JobSeekerProfile jsp = findJobSeekerProfile(cvDto.getLogin());
		if (jsp == null) { return NO_FOUND; }
		CvType cvTypeDto;
		try {
			cvTypeDto = CvType.valueOf(cvDto.getCvType());
		} catch (IllegalArgumentException e) {
			return WRONG_REQUEST;
		}
		for (CurriculumVitae cv : jsp.getCurriculumVitaes()) {
			if (cv.getCvType().equals(cvTypeDto)) { return EXIST; }
		}
		Verification ver = new Verification();
		em.persist(ver);
		Skills skills = new Skills(cvDto.getSkillsType());
		em.persist(skills);
		em.persist(new CurriculumVitae(jsp, ver, skills, cvDto));
		return OK;
	}
	
	@Override
	public String readJobSeekerCv(CurriculumVitaeDto cvDto) {
		CurriculumVitae cv = findJobSeekerCv(cvDto);
		if (cv == null) { return NO_FOUND; }
		try {
			return mapper.writeValueAsString(cv.getCurriculumVitaeDto());
		} catch (JsonProcessingException e) {
			return FALSE;
		}
	}
	
	@Override
	public String readJobSeekerAllCv(CurriculumVitaeDto cvDto) {
		JobSeekerProfile jsp = findJobSeekerProfile(cvDto.getLogin());
		if (jsp == null) { return NO_FOUND; }
		try {
			List<CurriculumVitaeDto> cvsDto = new ArrayList<CurriculumVitaeDto>();
			for (CurriculumVitae cv : jsp.getCurriculumVitaes()) {
				cvsDto.add(cv.getCurriculumVitaeDto());
			}
			return mapper.writeValueAsString(cvsDto);
		} catch (JsonProcessingException e) {
			return FALSE;
		}
	}
	
	@Override
	@Transactional
	public String updateJobSeekerCv(CurriculumVitaeDto cvDto) {
		CurriculumVitae cv = findJobSeekerCv(cvDto);
		if (cv == null) { return NO_FOUND; }
		cv.update(cvDto);
		cv.getSkills().setSkills(cvDto.getSkillsType());
		return OK;
	}
	
	@Override
	@Transactional
	public String deleteJobSeekerCv(CurriculumVitaeDto cvDto) {
		CurriculumVitae cv = findJobSeekerCv(cvDto);
		if (cv == null) { return NO_FOUND; }
		em.remove(cv);
		return OK;
	}
	
	@Override
	@Transactional
	public String setEnableJobSeekerCv(CurriculumVitaeDto cvDto, boolean enable) {
		CurriculumVitae cv = findJobSeekerCv(cvDto);
		if (cv == null) { return NO_FOUND; }
		if (enable) { cv.enable(); } else { cv.disable(); }
		return OK;
	}
	
	@Override
	@Transactional
	public String enableJobSeekerAllCv(CurriculumVitaeDto cvDto) {
		JobSeekerProfile jsp = findJobSeekerProfile(cvDto.getLogin());
		if (jsp == null) { return NO_FOUND; }
		em.refresh(jsp);
		for (CurriculumVitae cv : jsp.getCurriculumVitaes()) { cv.enable(); }
		return OK;
	}
	
	@Override
	@Transactional
	public String verifyJobSeekerCv(CurriculumVitaeDto cvDto, String status) {
		CurriculumVitae cv = findJobSeekerCv(cvDto);
		if (cv == null) { return NO_FOUND; }
		cv.getVerification().setVerificationStatus(status);
		return OK;
	}
	
	////    fields visibility ////
	
	@Override
	@Transactional
	public String updateJobSeekerVisibility(FieldsVisibilityDto fvDto) {
		try {
			em.find(FieldsVisibility.class, fvDto.getLogin()).update(fvDto);
			return OK;
		} catch (NullPointerException | IllegalArgumentException  e) {
			return NO_FOUND;
		}
	}
	
	////    search job seekers    ////
	
	@Override
	public String searchJobSeekers(CurriculumVitaeDto cvDto) {
		Session session = em.unwrap(Session.class);
		
		boolean checkFerification = cvDto.getVerification().getVerificationStatus()
				.equals(VerificationStatus.YES);
		
		List<JobSeekerProfileDto> res = session.createQuery(
				"select cv from CurriculumVitae cv where cv.cvType = :cvType and "
				+ "cv.yearsInWork >= :yearsInWork", CurriculumVitae.class)
				.setParameter("cvType", CvType.valueOf(cvDto.getCvType()))
				.setParameter("yearsInWork", cvDto.getYearsInWork())
				.stream().filter(cv -> {
					if (cv.getJobSeekerProfile().isRemove()) { return false; }
					if (checkFerification) {
						if (!cv.getVerification().getVerificationStatus()
								.equals(VerificationStatus.YES)) {
							return false;
						}
					}
					List<String> skills = Arrays.asList(cv.getSkills().getSkills());
					for (String skill : cvDto.getSkillsType()) {
						if (!skills.contains(skill)) { return false; }
					}
					return true;
				})
				.map(cv -> cv.getJobSeekerProfile().getJobSeekerProfileDto())
				.collect(Collectors.toList());
		try {
			return mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {
			return FALSE;
		}
	}
	
	////    support methods    ////
	
	private CurriculumVitae findJobSeekerCv(CurriculumVitaeDto cvDto) {
		String jpql = "select cv from CurriculumVitae cv where cv.cvType = :cvType and "
				+ "cv.jobSeekerProfile.login = :login";
		try {
			return em.createQuery(jpql, CurriculumVitae.class).
					setParameter("login", cvDto.getLogin()).setParameter("cvType", CvType.valueOf(cvDto.getCvType()))
					.getSingleResult();
		} catch (IllegalArgumentException | PersistenceException e) {
			return null;
		}
	}
	
	private JobSeekerProfile findJobSeekerProfile(String login) {
		String jpql = "select jsp from JobSeekerProfile jsp where jsp.login = :login";
		try {
			return em.createQuery(jpql, JobSeekerProfile.class).setParameter("login", login)
					.getSingleResult();
		} catch (IllegalArgumentException | PersistenceException e) {
			return null;
		}
	}
	
	private <T extends JobSeekerProfDataEntity, E, D> void updateProfDataEntity(
			List<T> arrEnt, E[] arrEntDto, D link) {
		Class<? extends Object> clazz = arrEntDto.getClass();
		String entName = clazz.getSimpleName().substring(0, clazz.getSimpleName().length() - 5);
		
		int arrEntSize = 0;
		if (arrEnt != null) {
			arrEntSize = arrEnt.size();
			if (arrEntSize  > arrEntDto.length) {
				for (int i = arrEntSize - 1; i >= arrEntDto.length ; i--) { em.remove(arrEnt.get(i)); }
			}
		} else if (arrEntDto.length == 0) { return; }
		
		for (int i = 0; i < arrEntDto.length; i++) {
			Experience exp = null;
			if (arrEnt != null && arrEntSize > i) { arrEnt.get(i).update(arrEntDto[i]); }
			else {
				switch (entName) {
				case "Education": em.persist(new Education(link, arrEntDto[i])); break;
				case "Language": em.persist(new Language(link, arrEntDto[i])); break;
				case "CourseAndCertificate": em.persist(new CourseAndCertificate(link, arrEntDto[i])); break;
				case "Recomendation": em.persist(new Recomendation(link, arrEntDto[i])); break;
				case "Experience": {
					exp = new Experience(link, arrEntDto[i]);
					em.persist(exp);
					break;
				}
				case "Project": em.persist(new Project(link, arrEntDto[i])); break;
				default: throw new IllegalArgumentException("FALSE update job seeker. "
						+ "Entity " + entName + " no found");
				}
			}
			// update projects in experience
			if (entName.equals("Experience")) {
				try {
					exp = (exp == null) ? (Experience) arrEnt.get(i) : exp;
					ExperienceDto expDto = (ExperienceDto) arrEntDto[i];
					updateProfDataEntity(exp.getProjects() == null ? null : exp.getProjects(),
							expDto.getProjects(), exp);
				} catch (ClassCastException e) {}
			}
		}
	}
}