package com.user.agent.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.user.agent.entities.User;
import com.user.agent.repositories.UserRepository;
import com.user.agent.services.exceptions.ResourceBadRequestException;
import com.user.agent.services.exceptions.ResourceNotFoundException;

@Service
public class UserServices {

	@Autowired
	UserRepository repository;
	
	public void registerAgent(User agent) {
		try {
			repository.save(agent);
			
		}catch (DataIntegrityViolationException e) {
			
			throw new ResourceBadRequestException("check all fields, can't field empty and verify if email is already registered");
		}
	}
	
	
	public void updateData(User newAgentData, User agent) {
		
		newAgentData.setPhone(agent.getPhone());
		newAgentData.setEmail(agent.getEmail());
		newAgentData.setCorp_office(agent.getCorp_office());
		newAgentData.setCorp_state(agent.getCorp_state());
		newAgentData.setCorp_city(agent.getCorp_city());
		newAgentData.setStatus(agent.getStatus());
	}
	
	
	public void updateAgent(User agent, long id) {
		
		try {
			
			User newAgentData=getAgentById(id);
			updateData(newAgentData, agent);
			
			repository.save(newAgentData);
			
		}catch (DataIntegrityViolationException e) {
			
			throw new ResourceBadRequestException("check all fields, can't field empty and verify if email is already registered");
			
			
		}catch (NoSuchElementException e) {
			
			throw new ResourceNotFoundException("agent not found");
			
		}
		
	}
	
	
	public Page<User> getAllAgents(PageRequest pagination){
			
			return repository.getAllAgents(pagination);
			
	}
	
	
	public User getAgentById(long id){
		try {
			
			return repository.findById(id).get();
			
		}catch (NoSuchElementException e) {
			
			throw new ResourceNotFoundException("agent not found");
		}
	}
	
}


