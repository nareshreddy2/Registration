package com.example.demo.binding;

public class ResetPassword {

	private String password;
	private String emailId;
	private String confirmPassword;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public ResetPassword() {
	}
	public ResetPassword(String password, String emailId, String confirmPassword) {
		super();
		this.password = password;
		this.emailId = emailId;
		this.confirmPassword = confirmPassword;
	}
	
	
}