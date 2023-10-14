package com.example.demo.binding;

public class UserLogin {

	private String password;
	private String emailId;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserLogin(String password, String emailId) {
		super();
		this.password = password;
		this.emailId = emailId;
	}
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}
	
}
