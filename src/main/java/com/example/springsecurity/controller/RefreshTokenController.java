package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.Entity.RefreshTokenEntity;
import com.example.springsecurity.dto.RefreshTokenDto;
import com.example.springsecurity.repository.RefreshTokenRepositoy;

@RestController
@RequestMapping("/api/")
public class RefreshTokenController {
	
	@Autowired
	private RefreshTokenRepositoy refreshrepo;
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refrestoken(@RequestBody RefreshTokenDto response){
		
		String refreshtoken = response.getRefreshtoken();
		RefreshTokenEntity token = refreshrepo.findByrefershtoken(refreshtoken).orElseThrow(() -> new RuntimeException("not found"));
		
		
		return ResponseEntity.ok("");
		
	}

}
