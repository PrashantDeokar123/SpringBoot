package com.sha.serverside.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.serverside.model.CourseStudent;

public interface CourseStudentRepository  extends JpaRepository<CourseStudent,Long>{

	List<CourseStudent>findByCourseInstructor(Long instructor);
	
	List<CourseStudent>findByStudentId(Long studentId);
}
