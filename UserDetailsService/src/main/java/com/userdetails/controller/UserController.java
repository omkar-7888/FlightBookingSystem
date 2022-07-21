package com.userdetails.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userdetails.model.UserDetails;
import com.userdetails.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserDetails userDetails){
		
		userService.addUser(userDetails);
		
		return ResponseEntity.ok("User Added");
	}
	@GetMapping("/findAllUSer")
	public List<UserDetails> findAllUser(){
		return userService.findAllUser();
	}
	
//	@GetMapping("/findUser/{email}")
//	public Optional<UserDetails> findUser(@RequestBody String email) {
//		return userService.findUser(email);
//	}
//	
	@PatchMapping("/updateUser")
	public String updateUser(@RequestBody UserDetails userDetails){
		return userService.updateUser(userDetails);

	}
	
//	@DeleteMapping("/deleteUser/{email}")
//	public ResponseEntity<?> deleteUser(@RequestBody String email){
//		userService.deleteUser(email);
//		
//		return ResponseEntity.ok("User Deleted Successfully");
//		
//	}
	
	
}
