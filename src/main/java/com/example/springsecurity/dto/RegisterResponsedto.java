package com.example.springsecurity.dto;

import java.time.LocalDateTime;



public class RegisterResponsedto {
	
    public RegisterResponsedto() {
		super();
	}
	public RegisterResponsedto(Long id, String email, String password, LocalDateTime createdtime,
			LocalDateTime updatetime) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.createdtime = createdtime;
		this.updatetime = updatetime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
	}
	public LocalDateTime getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}
	private Long id;
	
	private String email;

	private String password;
	

	private LocalDateTime createdtime;
	private LocalDateTime updatetime;

}
