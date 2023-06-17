package com.security.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.security.entities.User;
import com.security.security.repositories.UserRepository;
import com.security.security.services.exceptions.ResourceBadRequestException;
import com.security.security.services.exceptions.ResourceInternalServerErrorException;
import com.security.security.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	public UserRepository repository;
	
	public void insertUser(User user) {
		
		if(user.getName() == null){

			user.setName("");

		}if(user.getEmail() == null){

			user.setEmail("");

		}if(user.getPassword() == null){

			user.setPassword("");
		}
		
		if(user.getEmail() == "" 	 ||
		   user.getEmail().isEmpty()) {
						
			throw new ResourceBadRequestException("email cannot be empty");
		}
		if(user.getPassword() == "" 	|| 
		   user.getPassword().isEmpty() ) {
						
			throw new ResourceBadRequestException("password cannot be empty");
		}
					
		User emailExists=repository.getUserByEmail(user.getEmail());
					
		if(emailExists != null) {
			
			throw new ResourceBadRequestException("email exists");
		}
		
		try {
			
			repository.save(user);
			
		}catch (Exception e) {
			
			throw new ResourceInternalServerErrorException("i am sorry, there is an error with server");
		}

	}
	
	public void login() {
		
	}
	
	public List<User> findAll() {
		List<User> users=repository.findAll();
		
		if(users.isEmpty()) {
			
			throw new ResourceNotFoundException("no data");
		}
		
		try {
			
			return users;
			
		}catch (Exception e) {
			
			throw new ResourceInternalServerErrorException("i am sorry, there is an error with server");
			
		}
	}
	
	public User getUserById(long id){
		
		User userExists=repository.findById(id)
								  .orElseThrow(()-> new ResourceNotFoundException("user not found"));
		
		try {
			
			return userExists;

		}catch (Exception e) {
			
			throw new ResourceInternalServerErrorException("i am sorry, there is an error with server");
			
		}
			
	}
	
	public User getUserByEmail(String email) {
			
		User userExists=repository.getUserByEmail(email);
		
		if(userExists == null) {
			
			throw new ResourceNotFoundException("user not found");
		
		}
		
		
		try {
			
			return userExists;

		}catch (Exception e) {
			
			throw new ResourceInternalServerErrorException("i am sorry, there is an error with server");
			
		}
	}
	
}
