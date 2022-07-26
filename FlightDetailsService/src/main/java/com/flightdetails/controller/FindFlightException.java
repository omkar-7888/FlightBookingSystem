package com.flightdetails.controller;

public class FindFlightException extends RuntimeException{

	public  FindFlightException() {
		
		super ("Flight Is Not Available");
	}
	
	@Override
	
	public String toString() {
		return "Flight Is Not Available";
	}
}
