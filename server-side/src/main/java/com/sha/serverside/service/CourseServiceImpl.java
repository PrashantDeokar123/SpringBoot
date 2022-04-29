package com.sha.serverside.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sha.serverside.model.Course;
import com.sha.serverside.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	 @Override
	public Course addCourse(Course course) {
		return (Course) courseRepository.save(course);
	}
	 @Override
	public Course updateCourse(Course course) {
		return (Course) courseRepository.save(course);
	}
	 @Override
	 public void deleteCourse(Long courseId) {
		 courseRepository.deleteById(courseId);
	 }
	 @Override
	 public List<Course> findAllCourses(){
		 return courseRepository.findAll();
	 }
}
