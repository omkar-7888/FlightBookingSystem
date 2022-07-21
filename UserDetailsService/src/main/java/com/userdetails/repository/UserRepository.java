package com.userdetails.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userdetails.model.UserDetails;

//public interface UserRepository extends MongoRepository<UserDetails, String> {
//
//	
//
//	
//
//}

public interface UserRepository extends MongoRepository<UserDetails, Integer> {

 UserDetails findById(int id);

	

	

}
