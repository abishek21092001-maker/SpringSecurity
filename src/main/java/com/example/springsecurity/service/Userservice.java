package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.RoleEntity;
import com.example.springsecurity.Entity.UserEntity;
import com.example.springsecurity.dto.RegisterRequestDto;
import com.example.springsecurity.dto.RegisterResponsedto;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.serviceimpl.UserServiceImp;

@Service
public class Userservice implements UserServiceImp{
	
	@Autowired
	private PasswordEncoder passwordencoder;
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;

	@Override
	public RegisterResponsedto save(RegisterRequestDto request) {
		
		UserEntity userentity = new UserEntity();
		
		userentity.setEmail(request.getEmail());
		userentity.setPassword(passwordencoder.encode(request.getPassword()));
		
		RoleEntity role = rolerepo.findById(request.getRole()).orElseThrow(() -> new RuntimeException("role not found"));
		userentity.setRole(role);
		
		UserEntity saved = repo.save(userentity);
		
		RegisterResponsedto response = new RegisterResponsedto();
		
		response.setId(saved.getId());
		response.setEmail(saved.getEmail());
		response.setPassword(saved.getPassword());
		response.setCreatedtime(saved.getCreatedtime());
		response.setUpdatetime(saved.getUpdatetime());
		response.setRoleid(saved.getRole());
		
		
		
		
		return response;
	}

}
