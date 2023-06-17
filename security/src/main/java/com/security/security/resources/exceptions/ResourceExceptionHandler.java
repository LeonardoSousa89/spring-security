package com.security.security.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.security.security.services.exceptions.ResourceBadRequestException;
import com.security.security.services.exceptions.ResourceInternalServerErrorException;
import com.security.security.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFoundException(ResourceNotFoundException e, 
																  HttpServletRequest req){
		
		String error="Resource not found.";
		
		HttpStatus status=HttpStatus.NOT_FOUND;
		
		StandarError err=new StandarError(Instant.now(), 
										  status.value(), 
										  error, 
										  e.getMessage(), 
										  req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<StandarError> resourceBadRequestException(ResourceBadRequestException e,
																	HttpServletRequest req){
		
		String error="Bad request.";
		
		HttpStatus status=HttpStatus.BAD_REQUEST;
		
		StandarError err=new StandarError(Instant.now(), 
										  status.value(), 
										  error, 
										  e.getMessage(), 
										  req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	 
	@ExceptionHandler(ResourceInternalServerErrorException.class)
	public ResponseEntity<StandarError> resourceInternalServerErrorException(ResourceInternalServerErrorException e,
																			 HttpServletRequest req){
		
		String error="Server internal error.";
		
		HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
		
		StandarError err=new StandarError(Instant.now(), 
										  status.value(), 
										  error, 
										  e.getMessage(), 
										  req.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
