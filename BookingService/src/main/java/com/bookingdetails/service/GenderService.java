package com.bookingdetails.service;

import java.util.ArrayList;

public class GenderService {

	public boolean checkGender(String str) {
ArrayList<String> gender = new ArrayList<String>();
		
			gender.add("Male");
			gender.add("Female");
			gender.add("Other");
		
		
		boolean ans = gender.contains(str);
		
		return ans;

		
	}
}
