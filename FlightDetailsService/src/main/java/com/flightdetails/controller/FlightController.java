package com.flightdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightService;


@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody  FlightDetails flightDetails){
		flightService.addFlight(flightDetails);
		 return ResponseEntity.ok("Flight Added");
		
	}
	@GetMapping("/getAllFlights")
	public List<FlightDetails> getAllFlights(){
		
		 return flightService.getAllFlight();
	}
	
	@GetMapping("/getFlight/{name}")
	public FlightDetails getFlight(@RequestBody String name){
		
		return flightService.getFlight(name);
		
	}
	
	@PatchMapping("/updateFlight")
	public ResponseEntity<?> updateFlight(@RequestBody FlightDetails flightDetails){
		flightService.updateFlight(flightDetails);
		
		return ResponseEntity.ok("Flight Updated Successfully");
	}
	
	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<?> deleteFlight(@RequestBody int id){
		flightService.deleteFlight(id);
		
		return ResponseEntity.ok("Flight Deleted Successfully");
	}
	
}
