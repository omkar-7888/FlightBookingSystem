
package com.flightdetails.model;

import java.util.Date;


import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "FlightDetails")
public class FlightDetails {
	
	private String flightName;
	private String startFrom;
	private String destination;
	@JsonFormat(pattern = "DD-MM-YY")
	private Date flightDate;
	private String id;
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
	public void setId(String id) {
		this.id = id;
	}
	public FlightDetails() {
		super();
	}
	
	

}
