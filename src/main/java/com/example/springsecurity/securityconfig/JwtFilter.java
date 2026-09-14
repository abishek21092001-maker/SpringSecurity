package com.example.springsecurity.securityconfig;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springsecurity.service.JwtServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	private final JwtServices jwtservice;
	
	public JwtFilter(JwtServices jwtservice) {
		this.jwtservice = jwtservice;
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");

	    // No JWT → continue the request
	    if (header == null || !header.startsWith("Bearer ")) {
	        filterChain.doFilter(request, response);
	        return;
	    }
		
		String token =header.substring(7);
		
		String email = jwtservice.extractusername(token);
		
		String role = jwtservice.extractroles(token);
		System.out.println(role);
		
		if(SecurityContextHolder.getContext().getAuthentication() == null && email != null){
		
		if(!jwtservice.isnotexpired(token)) {
			
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
			
			UsernamePasswordAuthenticationToken Authenticate = new UsernamePasswordAuthenticationToken(email,null,List.of(authority));
			
			SecurityContextHolder.getContext().setAuthentication(Authenticate);
			
			
			
			
			
		}
		}
		
		
		
		filterChain.doFilter(request, response);
		
		
		
	}
	

}
