package com.bookingdetails.model;

import java.util.Date;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDetails {

	@Id
	
	private int id;
	private String email;
	private String Role="user";
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dateOfBirth;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public UserDetails() {
		super();
	}
	
	

}
