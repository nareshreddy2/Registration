package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	private int cityId;
	private int stateId;
	private String cityName;
	
	public City() {
	}
	
	public City(int cityId, int stateId, String cityName) {
		super();
		this.cityId = cityId;
		this.stateId = stateId;
		this.cityName = cityName;
	}
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

	
	
}
