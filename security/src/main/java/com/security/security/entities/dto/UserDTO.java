package com.security.security.entities.dto;

import com.security.security.entities.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
	
	private long id;
	
	private String name;
		
	private String email;

	public UserDTO(User user) {
		this.id = user.getUserId();
		this.name = user.getName();
		this.email = user.getEmail();
	}
}
