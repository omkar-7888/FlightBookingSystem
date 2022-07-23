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

 public  UserDetails findById(int id);

 public  Optional<UserDetails> findById(String email);

public void deleteById(String email);

 public UserDetails findByFirstName(String username);
 

	

	

}
