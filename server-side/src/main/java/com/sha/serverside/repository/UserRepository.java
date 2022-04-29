package com.sha.serverside.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.serverside.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);
		
	
}