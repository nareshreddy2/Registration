package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	
	@Query(value = "SELECT c.CITY_NAME FROM CITY c INNER JOIN STATE s ON c.STATE_ID = s.STATE_ID WHERE s.STATE_NAME = :stateName", nativeQuery = true)
	List<String> getCities(String stateName);

}
