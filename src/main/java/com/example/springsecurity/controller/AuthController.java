package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dto.LoginRequestdto;

@RestController
@RequestMapping("/api/")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody LoginRequestdto request){
		authmanager.authenticate(new UsernamePasswordAuthenticationToken
				(request.getEmail(),
				 request.getPassword()));
	
		
		return ResponseEntity.ok("Sucessfully");		
	}
	
	
	

}
