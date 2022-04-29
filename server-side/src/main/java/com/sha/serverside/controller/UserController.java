package com.sha.serverside.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.jwt.JwtTokenProvider;
import com.sha.serverside.model.CourseStudent;
import com.sha.serverside.model.Role;
import com.sha.serverside.model.User;
import com.sha.serverside.service.CourseService;
import com.sha.serverside.service.CourseStudentService;
import com.sha.serverside.service.UserService;

@RestController
public class UserController {
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserService userService;
	
	@Autowired 
	private CourseService courseService;
	
	@Autowired 
	private CourseStudentService  courseStudentService;
	
	@PostMapping("/api/user/registration")
	public ResponseEntity<?> register(@RequestBody User user){
		if(userService.findByUsername(user.getUsername()) !=null) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		user.setRole(Role.STUDENT);
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
		
	}
	@GetMapping("/api/user/login")
	public ResponseEntity<?> getUsername(Principal principal){
		
		if(principal == null) {
			return ResponseEntity.ok(principal);
		}
		UsernamePasswordAuthenticationToken authenticationToken=(UsernamePasswordAuthenticationToken)principal;
		User user=userService.findByUsername(authenticationToken.getName());
		user.setToken(tokenProvider.generateToken(authenticationToken.getName()));
		return new ResponseEntity<>(userService.findByUsername(principal.getName()),HttpStatus.OK);
		
		
	}
	
	@PostMapping("/api/user/enroll")
	public ResponseEntity<?>enrollcourse(@RequestBody CourseStudent courseStudent){
		return new  ResponseEntity<>(courseStudentService.saveCourseStudnet(courseStudent),
				HttpStatus.CREATED);
	}
	@GetMapping("/api/user/course")
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok(courseService.findAllCourses());
	}
	
}
