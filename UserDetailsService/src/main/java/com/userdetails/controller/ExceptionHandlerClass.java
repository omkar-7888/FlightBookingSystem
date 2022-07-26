package com.userdetails.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerClass{

	
	@ExceptionHandler(FindUserException.class)
	public ResponseEntity<?> handlefindUserException(FindUserException e,WebRequest req){
		return new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UpdateUserExcetion.class)
		public ResponseEntity<?> handleUpdateException(UpdateUserExcetion e,WebRequest req){
			return new ResponseEntity<> (e.toString(),HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(DeleteUserException.class)
	public ResponseEntity<?> handleDeleteException(DeleteUserException e , WebRequest req){
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}
	}
	

