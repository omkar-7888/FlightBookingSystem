package com.bookingdetails.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class BookingDetails {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String Gender;
	private String flightId;
	

	public String getFlightName() {
		return flightId;
	}
	public void setFlightName(String flightName) {
		this.flightId = flightName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public BookingDetails() {
		super();
	}
	
	
}
