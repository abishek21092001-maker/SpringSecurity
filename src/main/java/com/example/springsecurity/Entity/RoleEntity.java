package com.example.springsecurity.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity {
	
	public RoleEntity() {
		super();
	}

	public RoleEntity(Long id, String role, String description, LocalDateTime createdat, LocalDateTime updatedat) {
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;
	
    
	private String role;
	
	private String description;
	
	@CreatedDate
	private LocalDateTime createdat;
	
	@LastModifiedDate
	private LocalDateTime updatedat;

}
