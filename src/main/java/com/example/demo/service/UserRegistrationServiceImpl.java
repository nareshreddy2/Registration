package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.UserLogin;
import com.example.demo.binding.UserRegistration;
import com.example.demo.model.Country;
import com.example.demo.model.UserLoginEntity;
import com.example.demo.model.UserRegistrationEntity;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.repository.UserRegisterRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	private UserLoginRepository repo;
	
	@Autowired
	private UserRegisterRepository repo1;
	
	@Autowired
	private CountryRepository repo2;
	
	@Autowired
	private CityRepository repo3;
	
	public boolean ValidateAccount(String emailId, String password) {

		UserLoginEntity user = repo.validateUser(emailId,password);
		
		 if(user!=null) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	@Override
	public String saveOrUpdateUserAccount(UserRegistration user) {
		Integer id = user.getId();
        
		if(id==null) {
			user.setActiveSw("Y");
		}
		
		UserRegistrationEntity u = new UserRegistrationEntity(user.getFullName(),user.getPassword()
				,user.getEmailId(),user.getPhoneNumber(),user.getDob(),user.getGender(),user.getSsn(),
				user.getCountry(),user.getState(),user.getCity(),
				user.getActiveSw(), user.getCreatedDate(),user.getUpdatedDate());
		
		repo1.save(u);
		String emailId = u.getEmailId();
		String password = u.getPassword();
	

		if (id == null) {
			saveUser(emailId,password);
			return "user record saved";
			
		} else {
			return "user record updated";
		}
	}

	private void saveUser(String emailId, String password) {

		 repo.validateUser(emailId,password);
		
		 UserLoginEntity u = new UserLoginEntity(password, emailId);
		 repo.save(u);
		
	}

	@Override
	public List<String> getCountries() {
		
		 List<Country> list = repo2.findAll();
		 return list.stream().map(Country::getCountryName).collect(Collectors.toList());
	}

	@Override
	public List<String> getStates(String countryName) {

		 List<String> states = repo2.getStates(countryName);
		 
		 return states;
	}

	@Override
	public List<String> getCities(String stateName) {

		List<String> cities = repo3.getCities(stateName);
		
		return cities;
	}

	@Override
	public boolean ValidateEmail(String emailId) {
		return true;
	}

}
