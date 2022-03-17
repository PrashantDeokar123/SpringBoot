package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {

     @PersistenceContext
	 EntityManager entityManager;
	
	   public Course findById(long id) {
	   return entityManager.find(Course.class,id);
	}
	   

	   public void deleteById(long id) {
	  			  Course course= findById(id);
	  			  entityManager.remove(course);
	  		   }
	   
	   public Course save(Course course) {
		   if(course.getId() <0) {
			   entityManager.persist(course);
			  //insert 
		   }else {
			   entityManager.merge(course);
			   //update
		   }
		   return course;
		   
	   }
	
	

	
}
