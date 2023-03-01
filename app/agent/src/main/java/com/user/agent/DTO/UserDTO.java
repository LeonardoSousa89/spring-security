package com.user.agent.DTO;

import com.user.agent.entities.User;
import com.user.agent.enumerables.AgentStatus;
import com.user.agent.enumerables.Office;
import com.user.agent.enumerables.USCities;
import com.user.agent.enumerables.USStates;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

	private String name;
	private String phone;
	private String email;
	private Office corp_office;
	private USStates corp_state;
	private USCities corp_city;
	private AgentStatus status;
	
	public UserDTO(User agent) {
		this.name=agent.getName();
		this.phone=agent.getPhone();
		this.email=agent.getEmail();
		this.corp_office=agent.getCorp_office();
		this.corp_state=agent.getCorp_state();
		this.corp_city=agent.getCorp_city();
		this.status=agent.getStatus();
	}
}
