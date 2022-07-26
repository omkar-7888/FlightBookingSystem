package com.flightdetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightService;


@SpringBootTest
public class AddFlightTest {
	
	@Autowired
	private FlightService flightService;

	
	@Test
	public void testAdd() {
		
		FlightDetails fDetails = new FlightDetails();
		
		fDetails.setFlightName("IndiGo");
		fDetails.setStartFrom("Mumbai");
		fDetails.setDestination("Pune");
		fDetails.setId("10T2");
		
		flightService.addFlight(fDetails);
		
		FlightDetails flight_Test = flightService.getFlight(fDetails.getFlightName());
		assertNotNull(flight_Test);
		

		
	}
	@Test
	public void testFind() {
		
		FlightDetails flightDetails = new FlightDetails();
		
		FlightDetails flightDetailsTest = flightService.getFlight("IndiGo");
		
		assertEquals("IndiGo", flightDetailsTest.getFlightName());
		
	}
	@Test
	public void findAll() {
		List<FlightDetails> flightDetails = flightService.getAllFlight();
		assertEquals("IndiGo",flightDetails.get(0).getFlightName());
		assertEquals("Boeing-323",flightDetails.get(1).getFlightName());
		assertEquals("flight-102",flightDetails.get(2).getFlightName());
		
	}
	
	@Test
	public void deleteTest() {
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setFlightName("IndiGoo");
		flightDetails.setStartFrom("Mumbai");
		flightDetails.setDestination("Kolkata");
		flightDetails.setId("100E");

		flightService.addFlight(flightDetails);
		flightService.deleteFlight("100E");
		FlightDetails fd = flightService.getFlight("IndiGoo");
		assertNull(fd);


		
	}
	@Test
	public void updateTest() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
