package com.example.springsecurity.service;



import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
		RefreshTokenEntity ref = new RefreshTokenEntity()	;
		ref.setRefershtoken(UUID.randomUUID().toString());
		ref.setExpirydate(LocalDateTime.now().plusDays(7));
		ref.setUser(user);
		return repo.save(ref);	
		
	}
	
	public RefreshTokenEntity checkExpiry(RefreshTokenEntity refershtoken) {
		
		if(refershtoken.getExpirydate().isBefore(LocalDateTime.now())) {
			repo.delete(refershtoken);
			throw new RuntimeException(
                    "Refresh token expired"
            );
			
			
		}
		
		return refershtoken;
		
	}

	

	
	
	

}
