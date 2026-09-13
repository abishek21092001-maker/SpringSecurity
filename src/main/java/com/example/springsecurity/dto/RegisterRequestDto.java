package com.example.springsecurity.dto;

import com.example.springsecurity.Entity.RoleEntity;

public class RegisterRequestDto {
	public RegisterRequestDto() {
		super();
	}
	public RegisterRequestDto(String email, Long role, String password) {
		super();
		this.email = email;
		this.role = role;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String email;
	
	private Long role;
	private String password;
	
	

}
