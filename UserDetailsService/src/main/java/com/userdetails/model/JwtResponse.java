package com.userdetails.model;

public class JwtResponse {


	String token;

	public String getToken() {
		return token;
	}
	
	public JwtResponse(String token) {
			this.token=token;
		}
}
