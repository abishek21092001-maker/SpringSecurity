package com.example.springsecurity.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.RefreshTokenEntity;
import com.example.springsecurity.Entity.UserEntity;
import com.example.springsecurity.repository.RefreshTokenRepositoy;

@Service
public class RefreshTokenService {
	@Autowired
	private RefreshTokenRepositoy repo;
	
	public RefreshTokenEntity createrefershtoken(UserEntity user) {
		
		repo.deleteByUser(user);
		RefreshTokenEntity ref = new RefreshTokenEntity();
		ref.setRefershtoken(UUID.randomUUID().toString());
		ref.setUser(user);
		return repo.save(ref);	
		
	}
	
	
	

}
