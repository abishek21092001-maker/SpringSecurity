package com.example.springsecurity.dto;

import java.time.LocalDateTime;

public class roleresponsedto {
	
public roleresponsedto() {
		super();
	}

public roleresponsedto(Long id, String role, String description, LocalDateTime createdat, LocalDateTime updatedat) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}

private Long id;

private String role;

private String description;


private LocalDateTime createdat;

private LocalDateTime updatedat;

}
