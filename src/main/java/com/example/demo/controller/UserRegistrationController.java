package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.binding.ForgotLogin;
import com.example.demo.binding.ResetPassword;
import com.example.demo.binding.UserLogin;
import com.example.demo.binding.UserRegistration;
import com.example.demo.service.UserRegistrationService;
import com.example.demo.utils.EmailUtils;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService service;
	@Autowired
	private EmailUtils emailUtils;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("user", new UserLogin());
		return "index";
	}

	@GetMapping("/login-user")
	public String ValidateAccount(@ModelAttribute("user") UserLogin user, Model model) {
		boolean userValid = service.ValidateAccount(user.getEmailId(), user.getPassword());
		if (userValid) {
			model.addAttribute("saved", "Valid User");
			model.addAttribute("user", new UserLogin());
			return "index";
		} else {
			model.addAttribute("saved", "In-Valid User");
			return "index";
		}
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new UserRegistration());
		List<String> countries = service.getCountries();
		model.addAttribute("countries",countries);

		return "register";
	}

	@PostMapping("/save-user")
	public String saveUserAccount(@ModelAttribute("user") UserRegistration userAcc, Model model) {
		String savedUser = service.saveOrUpdateUserAccount(userAcc);
		model.addAttribute("saved", savedUser);
		if (savedUser.equals("user record updated")) {
			model.addAttribute("pass", "pass");
		}
		model.addAttribute("user", new UserRegistration());
		boolean email = emailUtils.sendEmail();
		System.out.println(email);
		return "index";
	}

	
	@GetMapping("/getStates/{countryName}")
	@ResponseBody
	public List<String> getStates(@PathVariable String countryName, Model model) {
		model.addAttribute("user", new UserRegistration());
		List<String> states = service.getStates(countryName);
		model.addAttribute("states",states);
		return states;
	}
	
	@GetMapping("/getCities/{stateName}")
	@ResponseBody
	public List<String> getCities(@PathVariable String stateName, Model model) {
		model.addAttribute("user", new UserRegistration());
		List<String> cities = service.getCities(stateName);
		model.addAttribute("states",cities);
		return cities;
	}
	
	
	@GetMapping("/forgot")
	public String forgot(Model model) {
		model.addAttribute("user", new ForgotLogin());
		return "forgot";
	}
	
	@PostMapping("/forgot-user")
	public String forgotUserAccount(@ModelAttribute("user") ResetPassword user, Model model) {
		boolean userValid = service.ValidateEmail(user.getEmailId());
		if (userValid) {
			model.addAttribute("valid", "Valid User");
			model.addAttribute("user", new ResetPassword());
			return "forgot-user";
		} else {
			model.addAttribute("valid", "In-Valid User");
			return "index";
		}
	}
	
	@PostMapping("/forgot-newuser")
	public String forgotNewUserAccount(@ModelAttribute("forgotuser") ResetPassword user, Model model) {
		boolean userValid = service.ValidateEmail(user.getEmailId());
		if (userValid) {
			model.addAttribute("valid", "Valid User");
			model.addAttribute("user", new ResetPassword());
			return "index";
		} else {
			model.addAttribute("valid", "In-Valid User");
			return "index";
		}
	}
}
