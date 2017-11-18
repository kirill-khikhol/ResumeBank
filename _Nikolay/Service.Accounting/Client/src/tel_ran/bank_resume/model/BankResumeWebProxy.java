package tel_ran.bank_resume.model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.*;
import tel_ran.bank_resume.api.*;
import tel_ran.bank_resume.api.dto.*;

public class BankResumeWebProxy implements AccountRequestType, AccountResponseType {
	private static final String URL = "http://localhost:8080";
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	
	public String login(AccountDto account) {
		try {
			HttpEntity<AccountDto> requestEntity = new HttpEntity<AccountDto>(account, headers);
			return restTemplate.exchange(URL + LOGIN, HttpMethod.POST, requestEntity,
					String.class).getBody();
		} catch (RestClientException e) {
			System.out.println("ERROR: " + e.getMessage());
			return null;
		}
	}
	
	public String isExists(AccountDto account) {
		return postRequest(IS_EXISTS, account, new ParameterizedTypeReference<String>() {});
	}
	
	public String registration(FullAccountDto account) {
		return postRequest(REGISTRATION, account, new ParameterizedTypeReference<String>() {});
	}
	
	// request methods
//	private <T> LibraryCodes postRequest(String nameRequest, T bodyRequest) {
//		return postRequest(nameRequest, bodyRequest, new ParameterizedTypeReference<LibraryCodes>() {});
//	}
	
	private <T> boolean postRequest(String nameRequest, T bodyRequest) {
		Boolean request = postRequest(nameRequest, bodyRequest, new ParameterizedTypeReference<Boolean>() {});
		return request != null ? request : false;
	}
	
	private <T, E> E postRequest(String nameRequest, T bodyRequest, ParameterizedTypeReference<E> responseType) {
		try {
			HttpEntity<T> requestEntity = new HttpEntity<T>(bodyRequest, headers);
			return restTemplate.exchange(URL + nameRequest, HttpMethod.POST, requestEntity,
					responseType).getBody();
		} catch (RestClientException e) {
			System.out.println("ERROR: " + e.getMessage());
			return null;
		}
	}
	
	private <T> T getRequest(String nameRequest, ParameterizedTypeReference<T> responseType) {
		try {
			return restTemplate.exchange(URL + nameRequest, HttpMethod.GET, requestEntity,
					responseType).getBody();
		} catch (RestClientException e) {
			System.out.println("ERROR: " + e.getMessage());
			return null;
		}
	}
	
	private <T> boolean getRequest(String nameRequest, String nameParam, String bodyParam) {
		Boolean request = getRequest(nameRequest, nameParam, bodyParam,
				new ParameterizedTypeReference<Boolean>() { });
		return request != null ? request : false;
	}
	
	private <T> T getRequest(String nameRequest, String nameParam, String bodyParam,
			ParameterizedTypeReference<T> responseType) {
		try {
			return restTemplate.exchange(URL + nameRequest + "?" + nameParam + "=" + bodyParam,
					HttpMethod.GET, requestEntity, responseType).getBody();
		} catch (RestClientException e) {
			System.out.println("ERROR: " + e.getMessage());
			return null;
		}
	}
}
