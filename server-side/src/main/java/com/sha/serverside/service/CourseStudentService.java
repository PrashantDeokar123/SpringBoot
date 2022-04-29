package com.sha.serverside.service;

import java.util.List;

import com.sha.serverside.model.CourseStudent;

public interface CourseStudentService {

	//Object saveCourseStudent = null;

	CourseStudent saveCourseStudnet(CourseStudent courseStudent);

	List<CourseStudent> findAllCourseofStudent(Long studentId);

	List<CourseStudent> findAllStudnetofInstructor(Long instructorId);

	List<CourseStudent> findAllEnrollments();

	static Object saveCourseStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	static Object saveCourseStudent(CourseStudent courseStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
