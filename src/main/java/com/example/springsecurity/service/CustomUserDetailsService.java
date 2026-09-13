package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.UserEntity;
import com.example.springsecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userentity = repo.findByemail(email).orElseThrow(() -> new UsernameNotFoundException("Email id is not found"));
		return User.builder()
				.username(userentity.getEmail())
				.password(userentity.getPassword())
				.roles(userentity.getRole().getRole())
				.build();
	}

}
