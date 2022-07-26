package com.flightdetails.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class FlightList {

	
	public boolean checkFlight(String str) {
		

		ArrayList<String> flightNames = new ArrayList<String>();
		
		flightNames.add("IndiGo");
		flightNames.add("Air India");
		flightNames.add("SpiceJet");
		flightNames.add("Go First");
		flightNames.add("AirAsia India");
		flightNames.add("Vistara");
		flightNames.add("Alliance Air");
		flightNames.add("TruJet");
		
		boolean ans = flightNames.contains(str);
		
		return ans;
		
		
	}
		
		
		
		
	
}
