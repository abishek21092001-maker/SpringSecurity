package com.example.springsecurity.securityconfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springsecurity.service.JwtServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtServices jwtservice;
	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authentication");
		
		String token = header.substring(7);
		
		if(!header.startsWith("bearer ") || header != null) {
			filterChain.doFilter(request, response);
			
		}
		
		String username = jwtservice.extractusername(token);
		
		if( username!= null && SecurityContextHolder.getContext().getAuthentication() != null) {
			
			
			
			
			
			
		}
		
		
		
	}
	
	

}
