package com.example.springsecurity.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.Entity.RefreshTokenEntity;
import com.example.springsecurity.Entity.UserEntity;
import com.example.springsecurity.dto.RefreshTokenDto;
import com.example.springsecurity.repository.RefreshTokenRepositoy;
import com.example.springsecurity.service.JwtServices;
import com.example.springsecurity.service.RefreshTokenService;

@RestController
@RequestMapping("/api/")
public class RefreshTokenController {
	
	@Autowired
	private RefreshTokenRepositoy refreshrepo;
	
	@Autowired
	private RefreshTokenService refreshserv;
	
	@Autowired
	private JwtServices jwt;
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refrestoken(@RequestBody RefreshTokenDto response){
		
		
		
	    String refreshtoken = response.getRefreshtoken();
	    
		RefreshTokenEntity token = refreshrepo.findByrefershtoken(refreshtoken).orElseThrow(() -> new RuntimeException("not found"));
		UserEntity user = token.getUser();
		
		refreshserv.checkExpiry(token);
		

		Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), null);
		
		 String acesstoken = jwt.generatetoken(auth);
		
		
		return ResponseEntity.ok(acesstoken);
		
	}

}
