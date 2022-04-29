package com.sha.serverside.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sha.serverside.model.CourseStudent;
import com.sha.serverside.repository.CourseStudentRepository;

@Service
@Transactional
public class CourseStudentServiceImpl implements CourseStudentService{

	@Autowired
	private CourseStudentRepository courseStudentRepository;
	
	@Override
	public CourseStudent saveCourseStudnet(CourseStudent courseStudent) {
		return courseStudentRepository.save(courseStudent);
	}
	
	@Override
	public List<CourseStudent> findAllCourseofStudent(Long studentId){
		return courseStudentRepository.findByStudentId(studentId);
	}
	@Override
	public List<CourseStudent> findAllStudnetofInstructor(Long instructorId){
		return courseStudentRepository.findByCourseInstructor(instructorId);
	}
	@Override
	public List<CourseStudent> findAllEnrollments(){
		return courseStudentRepository.findAll();
	}
	
}
