package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	private int stateId;
	private int countryId;
	private String stateName;

	public State() {
		// TODO Auto-generated constructor stub
	}

	public State(int stateId, int countryId, String stateName) {
		super();
		this.stateId = stateId;
		this.countryId = countryId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
