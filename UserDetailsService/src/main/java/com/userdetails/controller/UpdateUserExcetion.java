package com.userdetails.controller;

public class UpdateUserExcetion extends RuntimeException{
	
	public UpdateUserExcetion() {
	super ( "User Not found to Update Check User Id Again");
	}
	
	@Override
	public String toString() {
		return "User Not found to Update Check User Id Again";
	}

}
