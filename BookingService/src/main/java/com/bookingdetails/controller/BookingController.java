package com.bookingdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.model.FlightDetails;
import com.bookingdetails.model.Login;
import com.bookingdetails.model.ResponseClass;
import com.bookingdetails.service.BookingService;
import com.bookingdetails.service.GenderService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addBooking/{flightId}")
	public ResponseEntity<?> addBooking(@RequestBody BookingDetails bookingDetails,@PathVariable String flightId) {
		
		if(genderService.checkGender(bookingDetails.getGender())) {
			
		
		 bookingService.addBooking(bookingDetails, flightId);
		}
		else {
			throw new AddBookingException();
		}
		
		return ResponseEntity.ok("Flight Booked");
		
		
		
		
	}
	@GetMapping("/find/{id}") // id=Flightid
	public BookingDetails find(@PathVariable String id){
		
		BookingDetails booking = bookingService.get(id);
		if(booking == null) {
			throw new FindBookingException();
		}
		
		return bookingService.get(id);
	}
	@GetMapping("/findAll")
	public List<BookingDetails> findAll(){
		return bookingService.findAll();
	}
	@PatchMapping("/update")
	public ResponseEntity<?> update (@RequestBody BookingDetails bookingDetails){
		bookingService.update(bookingDetails);
		return ResponseEntity.ok("Upated");
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@PathVariable String id){
		bookingService.Delete(id);
		
		return ResponseEntity.ok("Booking Deleted");
	}
	@RequestMapping("/login")
	public ResponseEntity<?> login (@RequestBody Login login){
		return bookingService.login(login);
	}
	//To get Booking details with the Passenger Name;
	@RequestMapping("/getBookingDetails/{id}") 
	public ResponseEntity<?> getBookingDetails(@PathVariable String id){
		FlightDetails[] flights = restTemplate.getForObject("http://localhost:8081/getAllFlights", FlightDetails[].class);
		BookingDetails booking = bookingService.get(id);
		ResponseClass response = new ResponseClass();
		
		for(FlightDetails f:flights) {
			if(booking.getFlightName().equals(f.getId())) {
				response.setFrom(f.getStartFrom());
				response.setTo(f.getDestination());
				response.setPassengerName(booking.getFirstName());
				response.setFlightName(f.getFlightName());
			}
		}
		if(response !=null) {
			return ResponseEntity.ok(response);
		}
		else 
			return ResponseEntity.ok("Booking Not Found");
		
	}
}
