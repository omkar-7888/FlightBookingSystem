package com.flightdetails.controller;

public class UpdateFlightException extends RuntimeException{

	public UpdateFlightException() {
		super("Flight Not Found To Update Please Check Flight Id Again"
				+ "Thank You!!!");
	}
	
	@Override
	public String toString() {
		return "Flight Not Found To Update Please Check Flight Id Again"
				+ "Thank You!!!";
	}
}
