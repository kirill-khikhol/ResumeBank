package tel_ran.bank_resume.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;
import tel_ran.bank_resume.entities.company.*;
import tel_ran.bank_resume.interfaces.company.*;

@RestController
@CrossOrigin(origins = "*")
public class CompanyWebService implements CompanyRequestType, CompanyResponseType {

	@Autowired
	ICompany companyBean;

	@RequestMapping(value = CREATE_COMPANY, method = RequestMethod.POST)
	public String createCompany(@RequestBody CompanyDTO company) {
		String result = null;
		if (company != null) {
			String login = company.getLogin();
			if (login != null) {
				Company c = companyBean.getCompany(login);
				if (c == null) {
					companyBean.createCompany(new Company(company));
					result = OK;
				} else {result = ALREADY_EXIST_IN_DB;}
			} else {result = WRONG_DATA;}
		} else {result = FALSE;}
		return result;
	}

	@RequestMapping(value = DELITE, method = RequestMethod.POST)
	public String delite(@RequestBody AccountDto account, boolean newIsDelited) {
		String result = FALSE;
		if (account != null) {
			String login = account.getLogin();
			if (login != null) {
				if (companyBean.updateIsDelited(login, newIsDelited)) {
					result = OK;
				}
			}
		}
		return result;
	}

	@RequestMapping(value = EDIT_PROFILE, method = RequestMethod.POST)
	public String editProfile(@RequestBody CompanyDTO company) {
		String result = null;
		if (company != null) {
			String login = company.getLogin();
			if (login != null) {
				Company c = companyBean.getCompany(login);
				if (c != null) {
					companyBean.updateAll(company);
					result = OK;
				} else {result = NOT_EXIST_IN_DB;}
			} else {result = WRONG_DATA;}
		} else {result = FALSE;}
		return result;
	}

	@RequestMapping(value = GET_PROFILE, method = RequestMethod.POST)
	public String getProfile(@RequestBody AccountDto account) {
		String result = null;
		if (account != null) {
			String login = account.getLogin();
			if (login != null) {
				ObjectMapper om = new ObjectMapper();
				Company c = companyBean.getCompany(login);
				if (c != null) {
					try {
						result = om.writeValueAsString(c);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {result = NOT_EXIST_IN_DB;}
			} else {result = WRONG_DATA;}
		} else {result = FALSE;}
		return result;
	}

	@RequestMapping(value = VERIFY, method = RequestMethod.POST)
	public String verify(@RequestBody AccountDto account, String newIsVerified) {
		String result = FALSE;
		if (account != null) {
			String login = account.getLogin();
			if (login != null) {
				if (companyBean.updateIsVarified(login, newIsVerified)) {
					result = OK;
				}
			}
		}
		return result;
	}

}
