package com.sha.serverside.service;

import java.util.List;

import com.sha.serverside.model.Course;

public interface CourseService {

	Course addCourse(Course course);

	List<Course> findAllCourses();

	Course updateCourse(Course course);

	void deleteCourse(Long courseId);

}
