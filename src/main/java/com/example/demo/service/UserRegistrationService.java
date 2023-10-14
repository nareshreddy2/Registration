package com.example.demo.service;

import java.util.List;

import com.example.demo.binding.UserRegistration;

public interface UserRegistrationService {

	public boolean ValidateAccount(String emailId, String password);
	
	public String saveOrUpdateUserAccount(UserRegistration user);

	public List<String> getCountries();

	public List<String> getStates(String countryName);

	public List<String> getCities(String stateName);

	public boolean ValidateEmail(String emailId);
}
