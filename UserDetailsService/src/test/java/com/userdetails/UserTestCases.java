package com.userdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.userdetails.model.UserDetails;
import com.userdetails.service.UserService;

@SpringBootTest
public class UserTestCases {
	@Autowired
	private UserService service;
	
	@Test
	public void add() {
		UserDetails u=new UserDetails();
		u.setFirstName("surya");
		u.setLastName("singam");
		u.setPassword("surya123");
		u.setConfirmPassword("surya123");
		u.setEmail("surya123@gmail.com");
		service.addUser(u);
		Optional<UserDetails> u1=service.findUser(u.getEmail());
		assertNotNull(u1);
	}
	@Test
	public void get() {
		UserDetails u=new UserDetails();
		u.setFirstName("surya");
		u.setLastName("singam");
		u.setPassword("surya123");
		u.setConfirmPassword("surya123");
		u.setEmail("surya123@gmail.com");
		service.addUser(u);
		Optional<UserDetails> u1=service.findUser(u.getEmail());
		assertEquals("surya123@gmail.com",u1.get().getEmail());
	}
	@Test
	public void getAll() {
		List list=service.findAllUser();
		assertNotEquals(0, list.size());
	}
	@Test
	public void delete() {
		UserDetails u=new UserDetails();
		
		u.setFirstName("surya");
		u.setLastName("singam");
		u.setPassword("surya123");
		u.setConfirmPassword("surya123");
		u.setEmail("surya123@gmail.com");
		service.addUser(u);
		service.deleteUser("surya123@gmail.com");;
		Optional<UserDetails> u1=service.findUser("surya123@gmail.com");
		assertEquals(true,u1.isPresent());
	}
	@Test
	public void update() {
		UserDetails u=new UserDetails();
		u.setFirstName("surya");
		u.setLastName("singam");
		u.setPassword("surya123");
		u.setConfirmPassword("surya123");
		u.setEmail("surya123@gmail.com");
		service.addUser(u);
		u.setFirstName("rolex");
		service.updateUser(u);
		assertEquals("rolex",u.getFirstName());
		
	}

}
