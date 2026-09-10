package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dto.RegisterRequestDto;
import com.example.springsecurity.dto.RegisterResponsedto;
import com.example.springsecurity.serviceimpl.UserServiceImp;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	@Autowired
	private UserServiceImp userservice;
	
	@PostMapping
	public RegisterResponsedto savename(@RequestBody RegisterRequestDto request) {
		
		return userservice.save(request);
	}
	
	 
	
	

}
