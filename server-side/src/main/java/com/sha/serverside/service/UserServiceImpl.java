package com.sha.serverside.service;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sha.serverside.model.User;
import com.sha.serverside.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public  User saveUser(User user) {
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username).orElse(null);
	}
    @Override
	public List<User> findByAll(){
		return userRepository.findAll();
	}
    @Override
    public User updateUser(User user) {
    	return userRepository.save(user);
    }

	@Override
	public User findByUsername(String username, HttpStatus ok) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(Principal user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

	

