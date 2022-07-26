package com.userdetails.controller;

public class DeleteUserException extends RuntimeException {

	public DeleteUserException() {
		super ("Please Check User Id Again,Id is not present in Database");
	}
	
	@Override
	public String toString() {
		return "Please Check User Id Again,Id is not present in Database";
	}
}
