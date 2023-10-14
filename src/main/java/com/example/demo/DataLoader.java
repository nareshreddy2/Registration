package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.model.State;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.StateRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CountryRepository repo;
	
	@Autowired
	private StateRepository repo1;
	
	@Autowired
	private CityRepository repo2;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Country c1 = new Country("India");
		Country c2 = new Country("USA");
		Country c3 = new Country("Canada");
		
		List<Country> countries = Arrays.asList(c1,c2,c3);
		repo.saveAll(countries);
		
		State s1 = new State(101,1,"AP");
		State s2 = new State(102,1,"TG");
		State s3 = new State(103,1,"MP");
		
		State s4 = new State(104,2,"MN");
		State s5 = new State(105,2,"VA");
		State s6 = new State(106,2,"FL");
		
		State s7 = new State(107,3,"QB");
		State s8 = new State(108,3,"TO");
		State s9 = new State(109,3,"QW");
		
		List<State> states = Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9);
		repo1.saveAll(states);
		
		
		City city1 = new City(1,101,"Vizag");
		City city2 = new City(2,101,"Guntur");
		City city3 = new City(3,101,"Rajamandry");
		
		City city4 = new City(4,102,"Warangal");
		City city5 = new City(5,102,"Mlg");
		City city6 = new City(6,102,"Nlg");
		
		
		List<City> cities = Arrays.asList(city1,city2,city3,city4,city5,city6);
		repo2.saveAll(cities);
	}
}
