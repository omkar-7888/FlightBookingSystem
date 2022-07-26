package com.bookingdetails.controller;

public class FindBookingException extends RuntimeException {
	
	public FindBookingException() {
		
	
	super("Check Flight Id Again");
	}
	
	@Override
	public String toString() {
		return "Check Flight Id Again";
	}
}
