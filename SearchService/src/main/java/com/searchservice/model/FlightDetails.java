package com.searchservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDetails {

	private String id;
	private String flightName;
	private String startFrom;
	private String destination;
	@JsonFormat(pattern = "dd-MM-yyy")
	private Date flightDate;
	
	
	
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getId() {
		return id;
	}
	public FlightDetails() {
		super();
	}
}
