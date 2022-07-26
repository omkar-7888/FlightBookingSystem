package com.userdetails.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.userdetails.model.UserDetails;



public interface UserRepository extends CrudRepository<UserDetails, Integer> {


	//@Query("select UserDetails from UserDetails userDetails where UserDetails.deleted=:false and Order by UserDetails.id DESC ")
	//List<UserDetails> findAllUser();
	
 public  UserDetails findById(int id);


 public UserDetails findByFirstName(String username);

public void deleteById(int id);
 

	

	

}
