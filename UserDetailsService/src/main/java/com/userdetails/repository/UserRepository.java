package com.userdetails.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.userdetails.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {



	
	List<UserDetails> findAllByIdNotNullAndDeletedIsFalse();
	
 public  UserDetails findById(int id);


 public UserDetails findByFirstName(String username);

public void deleteById(int id);
 

	

	

}
