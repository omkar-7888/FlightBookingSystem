package com.flightdetails.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FlightExceptionHandler {

	@ExceptionHandler(AddFlightException.class)
	public ResponseEntity<?> handleAddFlightException(AddFlightException e , WebRequest req){
		return new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FindFlightException.class)
	public ResponseEntity<?> handleFindFlightException(FindFlightException e , WebRequest req){
		return  new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateFlightException.class)
	public ResponseEntity<?> handleUpdateFlightException(UpdateFlightException e,WebRequest req){
		return new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeleteFlightException.class)
	public ResponseEntity<?> handleDeleteFlightException(DeleteFlightException e, WebRequest req){
		return new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
	}
}
