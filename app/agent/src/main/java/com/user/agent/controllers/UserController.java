package com.user.agent.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.agent.DTO.UserDTO;
import com.user.agent.entities.User;
import com.user.agent.services.UserServices;

@RestController
@RequestMapping(value = "/FBI/agency")
public class UserController {

	@Autowired
	UserServices service;
	
	@PostMapping(value = "/register/agent")
	public ResponseEntity<Object> registerAgent(@RequestBody User agent){
		
		service.registerAgent(agent);
		return ResponseEntity.status(HttpStatus.CREATED).body("Agent registered");
	}
	
	
	@PutMapping(value = "/update/{id}/agent")
	public ResponseEntity<Object> updateAgent(@RequestBody User user, @PathVariable long id){
		
		service.updateAgent(user, id);
		return ResponseEntity.status(HttpStatus.OK).body("updated agent data");
	}
	
	
	@GetMapping(value = "/get-all/agent")
	public ResponseEntity<List<UserDTO>> getAllAgents(
				@RequestParam(name="page", defaultValue="0", required=true) int page,
				@RequestParam(name="size", defaultValue="5", required=true) int size
			){
		
		PageRequest pagination=PageRequest.of(page, size);
		Page<User> list_of_agents=service.getAllAgents(pagination);
		List<UserDTO> list_of_agentsDTO=list_of_agents.stream()
													  .map(agent -> new UserDTO(agent))
													  .collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(list_of_agentsDTO);
	}
	
	@GetMapping(value = "/get/{id}/agent")
	public ResponseEntity<UserDTO> getAgentById(@PathVariable long id){
		
		User agent=service.getAgentById(id);
		UserDTO agentDTO=new UserDTO(agent);
		
		return ResponseEntity.status(HttpStatus.OK).body(agentDTO);
	}
}
