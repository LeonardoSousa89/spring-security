package com.user.agent.services.exceptions;

public class ResourceInternalServerErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceInternalServerErrorException(String msg) {
		super(msg);
	}
}
