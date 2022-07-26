package com.userdetails.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdetails.model.UserDetails;
import com.userdetails.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void addUser(UserDetails userDetails) {
		
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String numbers = "01234567890123456789";
//		
//		String alphaNumeric = alphabet + numbers ;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		Random random = new Random();
//		
//		int length = 4;
//		for(int i = 0; i<length;i++) {
//			int index = random.nextInt(alphaNumeric.length());
//			
//			char randomChar = alphaNumeric.charAt(index);
//			
//			sb.append(randomChar);
//			
//		}
//		
//		String ranString = sb.toString();
//		
//		userDetails.set
		userRepo.save(userDetails);
	}
	
	public UserDetails findUser (int id) {
		 return userRepo.findById(id);
	}
	
	public Iterable<UserDetails> findAllUser(){
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
	
//	public void deleteUser( String email) {
//		userRepo.deleteById(email);
//	}
//	

	public void deleteUser (int id) {
		userRepo.deleteById(id);
	}

}
