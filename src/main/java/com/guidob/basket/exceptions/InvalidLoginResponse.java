package com.guidob.basket.exceptions;

public class InvalidLoginResponse {
	private String username;
	private String password;
	
	public InvalidLoginResponse() {
		this.username = "Invalid Username G";
		this.password = "Invalid Password G";
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
