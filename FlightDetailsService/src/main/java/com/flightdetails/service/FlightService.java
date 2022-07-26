package com.flightdetails.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.flightdetails.model.FlightDetails;
import com.flightdetails.repository.FlightRepository;

@Service
public class FlightService  {
	
	
	@Autowired
	private FlightRepository flightRepository;
	
	public void addFlight(FlightDetails flightdDetails) {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "012345678901234567890";
		
		String alphaNumeric = alphabet + numbers ;
		
		StringBuilder sb = new StringBuilder();
		
		Random random = new Random();
		
		int length = 4;
		for(int i = 0; i<length;i++) {
			int index = random.nextInt(alphaNumeric.length());
			
			char randomChar = alphaNumeric.charAt(index);
			
			sb.append(randomChar);
			
		}
		
		String ranString = sb.toString();
		
		flightdDetails.setId(ranString);
		
		flightRepository.save(flightdDetails);
		
	}
	
		
		
		
	
	public List<FlightDetails> getAllFlight() {
		return flightRepository.findAll();
	}
	public FlightDetails getFlight(String flightName) {
		return flightRepository.findByFlightName(flightName);
	}
	public FlightDetails FindbyId(String id) {
		return flightRepository.findById(id);
	}
	
	public String updateFlight (FlightDetails flightDetails) {
		
		FlightDetails update = flightRepository.findById(flightDetails.getId());
		
		if(update!=null) {
			flightRepository.save(flightDetails);
			return "Flight Updated";
		}
		else {
			return "Not  Updated";
		}
		
	}
	public void deleteFlight(String id) {
		flightRepository.deleteById(id);
	}





	

	
	
	
	
	
	
	

}
