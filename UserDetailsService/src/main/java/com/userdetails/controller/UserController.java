package com.userdetails.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userdetails.jwtutil.JwtUtil;
import com.userdetails.model.JwtRequest;
import com.userdetails.model.JwtResponse;
import com.userdetails.model.UserDetails;
import com.userdetails.service.UserSecurityDetailsService;
import com.userdetails.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserSecurityDetailsService userServicee;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserDetails userDetails){
		
		
		if(userDetails.getPassword().equals(userDetails.getConfirmPassword())) {
		userService.addUser(userDetails);
		
		} 
		else {
			return ResponseEntity.ok("Check Your Password");
		}
		
		return ResponseEntity.ok("User Added");
	}
	@GetMapping("/findAllUser")
	public Iterable<UserDetails> findAllUser(){
		return userService.findAllUser();
	}
	@GetMapping("/")
	public String show(){
		return "Welcome To Flight Booking";
	}
	
	@GetMapping("/findUser/{id}")
	public UserDetails findUser(@PathVariable int id) {
		
		UserDetails user = userService.findUser(id);
		if(user==null) {
			throw new FindUserException();
		}
		return userService.findUser(id);
	}
	
	@PatchMapping("/updateUser")
	public String updateUser(@RequestBody UserDetails userDetails){
		
		UserDetails user= userService.findUser(userDetails.getId());
		
		if(user==null) {
			throw new UpdateUserExcetion();
		}
		
		return userService.updateUser(userDetails);

	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		
		UserDetails user= userService.findUser(id);
		
		if(user==null) {
			throw new DeleteUserException();
		}
		
		userService.deleteUser(id);
		
		return ResponseEntity.ok("User Deleted Successfully");
		
	}
	@PostMapping("/auth")
	public ResponseEntity<?> generateToken (@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();
	
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch (UsernameNotFoundException e){
	e.printStackTrace();
	throw new Exception("Bad Credentials");
			
		}
		
		org.springframework.security.core.userdetails.UserDetails userDetails = userServicee.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
}
