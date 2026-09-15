package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.Entity.RefreshTokenEntity;
import com.example.springsecurity.Entity.UserEntity;

public interface RefreshTokenRepositoy extends JpaRepository<RefreshTokenEntity,Long>{
	
	Void deleteByUser(UserEntity user);

	Optional<RefreshTokenEntity> findByuser(UserEntity user);
	
	Optional<RefreshTokenEntity>findByrefershtoken(String refershtoken);

}
