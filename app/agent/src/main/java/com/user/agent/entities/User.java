package com.user.agent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.user.agent.enumerables.AgentStatus;
import com.user.agent.enumerables.Office;
import com.user.agent.enumerables.USCities;
import com.user.agent.enumerables.USStates;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	@Column(unique = true, nullable = false) private String email;
	private Office corp_office;
	private USStates corp_state;
	private USCities corp_city;
	private AgentStatus status;
}
