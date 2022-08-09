package com.flightdetails.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightList;
import com.flightdetails.service.FlightService;


@RestController
@CrossOrigin("*")
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightList flightListt;
	
	@PostMapping("/addFlight")
	
	public ResponseEntity<?> addFlight(@RequestBody  FlightDetails flightDetails) throws AddFlightException{
		
		
		if(flightListt.checkFlight(flightDetails.getFlightName())) {
			
			flightService.addFlight(flightDetails);
		}
		else {
			
			throw new AddFlightException();
		}
		
		 return ResponseEntity.ok("Flight Added");
		
	}
	@GetMapping("/getAllFlights")
	public List<FlightDetails> getAllFlights(){
		
		 return flightService.getAllFlight();
	}
	
	@GetMapping("/getFlight/{id}")
	public FlightDetails getFlight(@PathVariable String id) {
		
		FlightDetails flight = flightService.getFlight(id);
		
		if (flight==null) {
			
			throw new FindFlightException();
		}
		
		return flightService.FindbyId(id);
		
	}
	
	@PatchMapping("/updateFlight")
	public ResponseEntity<?> updateFlight(@RequestBody FlightDetails flightDetails){
		
		FlightDetails details = flightService.FindbyId(flightDetails.getId());
		
		if(details==null) {
			
			throw new UpdateFlightException();
		}
		flightService.updateFlight(flightDetails);
		
		return ResponseEntity.ok("Flight Updated Successfully");
	}
	
	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable String id){
		
		FlightDetails details = flightService.FindbyId(id);
		
		if(details == null) {
			
			throw new DeleteFlightException();
		}
		
		flightService.deleteFlight(id);
		
		return ResponseEntity.ok("Flight Deleted Successfully");
	}
	
}
