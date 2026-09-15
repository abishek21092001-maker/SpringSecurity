package com.example.springsecurity.dto;

public class RefreshTokenDto {
	public RefreshTokenDto() {
		super();
	}
	public String getAcesstoken() {
		return acesstoken;
	}
	public void setAcesstoken(String acesstoken) {
		this.acesstoken = acesstoken;
	}
	public String getRefreshtoken() {
		return refreshtoken;
	}
	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}
	public RefreshTokenDto(String acesstoken, String refreshtoken) {
		super();
		this.acesstoken = acesstoken;
		this.refreshtoken = refreshtoken;
	}
	private String acesstoken;
	private String refreshtoken;
	

}
