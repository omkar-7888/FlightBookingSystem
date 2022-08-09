package com.searchservice.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.searchservice.model.FlightDetails;
import com.searchservice.model.SearchDetails;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchController {

	@Autowired
	private RestTemplate restTemplate;
	
	//TO search the available flights on perticular Route
	@GetMapping("/searchFlight")
	public ResponseEntity<?> searchFlights(@RequestBody SearchDetails searchDetails) {
		
		FlightDetails[] listOfFlights = restTemplate.getForObject("http://FlightDetailsService/flights/getAllFlights", FlightDetails[].class);
	
		List filteredDetails=new ArrayList<>();
		
		for(FlightDetails f:listOfFlights) {
			if(f.getStartFrom().equals(searchDetails.getTravellingFrom())&&f.getDestination().equals(searchDetails.getGoingTo())) {
				filteredDetails.add(f);
			}
		}
		 
	
				
		return  ResponseEntity.ok(filteredDetails);
		
		
	}
	
	@RequestMapping("/getAll/{from}/{to}")
	public ResponseEntity<List<FlightDetails>> getFlightsInRangeAll(@PathVariable String from,@PathVariable String to){
		
		FlightDetails[] allFlights= restTemplate.getForObject("http://FlightDetailsService/flights/getAllFlights", FlightDetails[].class);
		
//		
		List filteredDetails=new ArrayList<>();
		
		for(FlightDetails f:allFlights) {
			if(f.getStartFrom().equals(from)&&f.getDestination().equals(to)) {
				filteredDetails.add(f);
			}
		}
		//List<FlightDetails> filteredList=allFlights.stream().filter((e)->e.getStartsFrom().equals(from)).collect(Collectors.toList());
		
		return ResponseEntity.ok(filteredDetails); 
	
}
}
