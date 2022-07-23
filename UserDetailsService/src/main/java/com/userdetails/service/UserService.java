package com.userdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdetails.model.UserDetails;
import com.userdetails.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void addUser(UserDetails userDetails) {
		
		userRepo.save(userDetails);
	}
	
	public Optional<UserDetails> findUser (String email) {
		 return userRepo.findById(email);
	}
	
	public List<UserDetails> findAllUser(){
		 return userRepo.findAll();
	}
	
	
	

public String updateUser(UserDetails userDetails) {
		
		UserDetails update = userRepo.findById(userDetails.getId());
				
		if(update!=null) {
			
		userRepo.save(userDetails);
		return "updated";
		}
		else
			return "not updated";
	}
	
	public void deleteUser( String email) {
		userRepo.deleteById(email);
	}
	

}
