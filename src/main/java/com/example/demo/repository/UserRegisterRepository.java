package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserRegistrationEntity;

public interface UserRegisterRepository extends JpaRepository<UserRegistrationEntity, Integer>{

}
