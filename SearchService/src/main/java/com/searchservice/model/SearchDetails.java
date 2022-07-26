package com.searchservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SearchDetails")
public class SearchDetails {

	private String travellingFrom;
	private String goingTo;
	
	public String getTravellingFrom() {
		return travellingFrom;
	}
	public void setTravellingFrom(String travellingFrom) {
		this.travellingFrom = travellingFrom;
	}
	public String getGoingTo() {
		return goingTo;
	}
	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}
	
	public SearchDetails() {
		super();
	}
	
	
}
