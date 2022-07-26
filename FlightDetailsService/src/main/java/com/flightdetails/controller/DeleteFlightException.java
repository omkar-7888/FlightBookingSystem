package com.flightdetails.controller;

public class DeleteFlightException extends RuntimeException {

	public DeleteFlightException() {
		super ("Please Check Flight Id Again ,Id is Not present In Databse");
	}
	
	@Override
	
	public String toString() {
		return "Please Check Flight Id Again ,Id is Not present In Databse";
	}
}
