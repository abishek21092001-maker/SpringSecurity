package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	
	Optional<UserEntity>findByemail(String email);

}
