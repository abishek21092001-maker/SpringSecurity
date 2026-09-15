package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.Entity.RefreshTokenEntity;
import com.example.springsecurity.Entity.UserEntity;
import com.example.springsecurity.dto.LoginRequestdto;
import com.example.springsecurity.dto.RefreshTokenDto;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.JwtServices;
import com.example.springsecurity.service.RefreshTokenService;

@RestController
@RequestMapping("/api/")
public class AuthController {
	
	@Autowired
	private JwtServices jwtfilter;
	
	@Autowired
	private RefreshTokenService refresh ;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@PostMapping("/login")
	public ResponseEntity<RefreshTokenDto> Login(@RequestBody LoginRequestdto request){
		Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken
				(request.getEmail(),
				 request.getPassword()));
		
		
		

		String acesstoken = jwtfilter.generatetoken(authentication);
		
		UserEntity user = userrepo.findByemail(request.getEmail()).orElseThrow(() -> new RuntimeException("Not found"));
		
		RefreshTokenEntity refreshtoken  = refresh.createrefershtoken(user);
		
		RefreshTokenDto dto = new RefreshTokenDto(acesstoken,refreshtoken.getRefershtoken());
		
		
		
		
		
	
		
		return ResponseEntity.ok(dto);		
	}
	
	
	

}
