package com.flightdetails.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightdetails.model.FlightDetails;

@Repository
public interface FlightRepository extends MongoRepository<FlightDetails, Integer> {

	

FlightDetails findByFlightName(String userName);


FlightDetails findById(String id);


void deleteById(String id);

	
}
