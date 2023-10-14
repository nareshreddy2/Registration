package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.binding.UserLogin;
import com.example.demo.model.UserLoginEntity;

public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Integer> {

	@Query("SELECT u FROM UserLoginEntity u where u.emailId=:email and u.password=:password")
	UserLoginEntity validateUser(String email, String password);

}