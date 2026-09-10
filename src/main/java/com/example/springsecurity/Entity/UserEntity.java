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
public class UserEntity {
	
	
	public UserEntity() {
		super();
	}
	public UserEntity(Long id, String email, String password, LocalDateTime createdtime, LocalDateTime updatetime) {
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@CreatedDate
	private LocalDateTime createdtime;
	@LastModifiedDate
	private LocalDateTime updatetime;

}
