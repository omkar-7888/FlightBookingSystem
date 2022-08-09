package com.userdetails.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


//@Document(collection = "UserDetails")
@Entity

@Table(name = "user_details")

@SQLDelete(sql = "UPDATE user_details SET deleted = true WHERE id=?")

public class UserDetails {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String Role="user";
	private String firstName;
	private String lastName;
	@Id
	private String email;
	private String password;
	private String confirmPassword;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE; //FALSE = Not Deleted TRUE = Deleted
	
	
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
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
