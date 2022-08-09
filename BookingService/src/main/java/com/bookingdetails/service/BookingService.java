package com.bookingdetails.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.model.Login;
import com.bookingdetails.model.UserDetails;
import com.bookingdetails.repository.BookingRepository;

@Service
public class BookingService {
	 
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public boolean status =true;	
	
	public ResponseEntity<?> addBooking(BookingDetails bookingDetails,String flightId) {
		
		if(status==true) {
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
			
			bookingDetails.setId("B"+ranString);
//			UserDetails[] userDetails = restTemplate.getForObject("http://localhost:8082/findAllUser", UserDetails[].class);
//			for(UserDetails u:userDetails) {
//				
//			}
			
			bookingDetails.setFlightName(flightId);
			bookingRepo.save(bookingDetails);
			return ResponseEntity.ok("Booking Successfull...HAPPY JOURNEY");
			
		}
		else
		{
			return ResponseEntity.ok(" Please Login For Booking");
		}
		
	}
	
	public ResponseEntity<?> login(Login login){
		UserDetails[] userDetails = restTemplate.getForObject("http://localhost:8082/findAllUser", UserDetails[].class);
		for(UserDetails u:userDetails) {
			if(u.getFirstName().equals(login.getUserName())&& u.getPassword().equals(login.getPassword())) {
				status=true;
			}
		}
		if(status==true) {
			return ResponseEntity.ok("Logged in SuccessFully)");
		}
		else {
			return ResponseEntity.ok("Please Register Befor Login");
		}
	}

	public Optional<BookingDetails> get(String id){
		return bookingRepo.findById(id);
	}
	
	public void update(BookingDetails bookingDetails) {
		Optional<BookingDetails> booking= bookingRepo.findById(bookingDetails.getId());
		if(booking!=null) {
			bookingRepo.save(bookingDetails);
		}
	}
	public void Delete(String id) {
		bookingRepo.deleteById(id);
	}
	
	public List<BookingDetails> findAll(){
		return bookingRepo.findAll();	}
}
