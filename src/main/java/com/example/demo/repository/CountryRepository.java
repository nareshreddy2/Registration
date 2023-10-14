package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

//	@Query(value = "SELECT s.STATE_NAME  FROM STATE s inner join  COUNTRY c on c.COUNTRY_ID = s.COUNTRY_ID where COUNTRY_NAME = 'countryName'",nativeQuery=true)
//	List<String> getStates(String countryName);
	
	@Query(value = "SELECT s.STATE_NAME FROM STATE s INNER JOIN COUNTRY c ON c.COUNTRY_ID = s.COUNTRY_ID WHERE c.COUNTRY_NAME = :countryName", nativeQuery = true)
	List<String> getStates(@Param("countryName") String countryName);
}
