package com.bookingdetails.controller;

public class AddBookingException extends RuntimeException {

	public AddBookingException() {
		super ("Gender Must Be [Male,Female,Other]");
	}
	@Override
	public String toString() {
		return "Gender Must Be [Male,Female,Other]";
	}
}
