package com.bookingdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookingdetails.model.BookingDetails;

public interface BookingRepository extends MongoRepository<BookingDetails, String> {
	
	
//public BookingDetails FindById(String id);
}
