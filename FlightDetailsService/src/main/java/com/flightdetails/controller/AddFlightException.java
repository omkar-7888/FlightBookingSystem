package com.flightdetails.controller;

public class AddFlightException extends RuntimeException {

	public AddFlightException() {
		super("Invalid Flight Name");
	}
	
	@Override
	public String toString() {
		return "Invalid Flight Name";
	}
}
