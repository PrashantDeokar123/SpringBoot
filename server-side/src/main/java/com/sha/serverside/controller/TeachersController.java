package com.sha.serverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.model.User;
import com.sha.serverside.service.CourseStudentService;

@RestController
public class TeachersController {
	
	@Autowired
	private CourseStudentService courseStudentService;
	
	public ResponseEntity<?> findAllStudentofInstructor(@PathVariable Long teacherId){
		List<User> student= courseStudentService.
				findAllCourseofStudent(teacherId).stream().
				map(cs -> cs.getStudent()).collect(Collectors.toList());
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	
}
