package com.example.springsecurity.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class RefreshTokenEntity {
	
	public Long getId() {
		return id;
	}

	public RefreshTokenEntity() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefershtoken() {
		return refershtoken;
	}

	public void setRefershtoken(String refershtoken) {
		this.refershtoken = refershtoken;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public LocalDateTime getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDateTime expirydate) {
		this.expirydate = expirydate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public RefreshTokenEntity(Long id, String refershtoken, LocalDateTime createdate, LocalDateTime expirydate,
			UserEntity user) {
		super();
		this.id = id;
		this.refershtoken = refershtoken;
		this.createdate = createdate;
		this.expirydate = expirydate;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String refershtoken;
	
	@CreatedDate
	private LocalDateTime createdate;
	
	@Column(nullable = false)
	private LocalDateTime expirydate;
	
	@OneToOne
	@JoinColumn(name ="user_id")
	private UserEntity user;
	
	

}
