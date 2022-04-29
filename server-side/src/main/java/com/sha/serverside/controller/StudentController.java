package com.sha.serverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.model.Course;
import com.sha.serverside.model.CourseStudent;
import com.sha.serverside.service.CourseStudentService;

@RestController
public class StudentController {

	@Autowired
	private CourseStudentService courseStudentService;
	
	@GetMapping("/api/student/course/studentId")
	public ResponseEntity<?> findAllCoursesofStudent(@PathVariable Long studentId){
		
		List<Course> courseList=courseStudentService.findAllCourseofStudent(studentId).
				stream().map(cs -> cs.getCourse()).collect(Collectors.toList());
		
		   return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
	@PostMapping("/api/studnet/enroll")
	public ResponseEntity<?> enroll(@RequestBody CourseStudent courseStudent){
		
		return new ResponseEntity<>(CourseStudentService.saveCourseStudent(courseStudent),HttpStatus.CREATED);
	}
}
