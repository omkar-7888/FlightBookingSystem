package com.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userdetails.repository.UserRepository;
import com.userdetails.security.UserDetailsImpl;

@Service 
public class UserSecurityDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.userdetails.model.UserDetails user=repo.findByFirstName(username);
		if(user==null) {
			throw new UsernameNotFoundException("not found");
		}
		return new UserDetailsImpl(user);
	}

}