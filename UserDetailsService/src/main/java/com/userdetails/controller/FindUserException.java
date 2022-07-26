package com.userdetails.controller;

public class FindUserException extends RuntimeException{

	public FindUserException () {
		super ("Check Your User Id , Id is Not Present in Database");
	}
	
	@Override
	
	public String toString() {
		return "Check Your User Id , Id is Not Present in Database";
	}
}
