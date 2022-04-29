package com.sha.serverside.service;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.sha.serverside.model.User;

public interface UserService {



	List<User> findByAll();

	User updateUser(User user);





	User findByUsername(String username);


	User saveUser(User user);

	User saveUser(Principal user);

	User findByUsername(String username, HttpStatus ok);


	

}
