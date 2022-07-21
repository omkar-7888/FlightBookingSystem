package com.flightdetails.service;

import java.util.List;
import java.util.Optional;

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
		flightRepository.save(flightdDetails);
		
		
	}
	public List<FlightDetails> getAllFlight() {
		return flightRepository.findAll();
	}
	public FlightDetails getFlight(String flightName) {
		return flightRepository.findByFlightName(flightName);
	}
	public void updateFlight (FlightDetails flightDetails) {
		flightRepository.save(flightDetails);
	}
	public void deleteFlight(int id) {
		flightRepository.deleteById(id);
	}
	
	
	
	
	
	
	

}
