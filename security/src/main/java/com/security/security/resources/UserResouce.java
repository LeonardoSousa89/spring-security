package com.security.security.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.security.entities.User;
import com.security.security.entities.dto.UserDTO;
import com.security.security.services.UserService;


@RestController
@RequestMapping(value = "/clients")
public class UserResouce {
	
	@Autowired
	public UserService service;
	
	@PostMapping(value = "/insert-client")
	public ResponseEntity<Object> insertUser(@RequestBody User user){
		
		service.insertUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body("user created with success.");
	}
	
	/*public ResponseEntity<Object> login(){
		
	}*/
	
	@GetMapping(value = "/all-clients")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users=service.findAll();
		
		List<UserDTO> usersDTO=users.stream()
									.map(user -> new UserDTO(user))
									.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
	}	
	
	@GetMapping(value = "/client/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable long id) throws Exception{
			User user=service.getUserById(id);
			UserDTO userDTO=new UserDTO(user);
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
	
	@GetMapping(value = "/client")
	public ResponseEntity<UserDTO> getUserByEmail(@RequestParam(value = "email", required = true) String email) throws Exception{
			User user=service. getUserByEmail(email);
			UserDTO userDTO=new UserDTO(user);
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
}
