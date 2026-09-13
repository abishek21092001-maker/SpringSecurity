package com.example.springsecurity.dto;



public class rolerequestdto {

	
	public rolerequestdto() {
		super();
	}

	public rolerequestdto(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String role;
	
	private String description;
	


}
