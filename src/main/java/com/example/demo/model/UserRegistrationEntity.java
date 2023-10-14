package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullName;
	private String password;
	private String emailId;
	private Long phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private String gender;
	private String ssn;
	private String activeSw;
	private String country;
	private String state;
	private String city;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;

	public UserRegistrationEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationEntity(String fullName, String password, String emailId, Long phoneNumber, LocalDate dob,
			String gender, String ssn, String country,String state, String city, String activeSw,
			LocalDate updatedDate, LocalDate createdDate) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.gender = gender;
		this.ssn = ssn;
		this.country = country;
		this.state = state;
		this.city = city;
		this.activeSw = activeSw;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", fullName=" + fullName + ", password=" + password + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn
				+ ", activeSw=" + activeSw + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate + "]";
	}

}