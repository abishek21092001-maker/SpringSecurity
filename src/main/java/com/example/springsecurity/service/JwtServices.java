package com.example.springsecurity.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServices {
	
	final String  Secret_key = "8f3c9a7e2d1b6f4a9c8e7d2f1a6b5c3e9d8f7a2b4c6e1d3f5a8b9c2d7e4f6";
	
	
	public String generatetoken(String email) {
		
		return Jwts.builder()
				.subject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000*60*30))
				.signWith(signedkey())
				.compact();
	}


	private SecretKey signedkey() {
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(Secret_key.getBytes(StandardCharsets.UTF_8));
	}
	
	public String extractusername(String token) {
		
	return Jwts.parser()
			.verifyWith(signedkey())
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.getSubject();
	}
	
	public boolean isvalid(UserDetails userdetails, String token) {
		return extractusername(token).equals(userdetails.getUsername()) || !isnotexpired(token);
	}


	private boolean isnotexpired(String token) {
		Date exp = Jwts.parser()
				.verifyWith(signedkey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getExpiration();
		return exp.before(new Date());
	}

}
