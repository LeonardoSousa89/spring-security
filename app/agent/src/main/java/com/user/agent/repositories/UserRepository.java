package com.user.agent.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.agent.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM agents")
	Page<User> getAllAgents(Pageable pagination);
}
