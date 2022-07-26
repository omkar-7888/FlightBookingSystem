package com.bookingdetails.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(AddBookingException.class)
	public ResponseEntity<?> handleAddBookingException(AddBookingException e,WebRequest req){
		
		return new ResponseEntity<> (e.toString(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FindBookingException.class)
	public ResponseEntity<?> handleFindBookingException(FindBookingException e,WebRequest req){
		
		return new ResponseEntity<> (e.toString(), HttpStatus.NOT_FOUND);
	}

}
