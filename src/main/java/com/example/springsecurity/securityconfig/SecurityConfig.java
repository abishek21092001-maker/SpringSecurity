package com.example.springsecurity.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springsecurity.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationmanager(AuthenticationConfiguration config) {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authenticationprovider(CustomUserDetailsService userdetails,PasswordEncoder passwordencoder) {
		
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userdetails);
		dao.setPasswordEncoder(passwordencoder);
		
		return dao;
		
	}
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		
		return http.build();
	}

}
