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

 public void delete(long id) {
	 
	Course course= findById(id);
	 entityManager.remove(course);

 }
 public void entityManager() {
	 
	 Course course1= new Course("hibernate 1");
	 entityManager.persist(course1);
	 entityManager.flush();
	 
	 entityManager.detach(course1);
	 course1.setName("one to one mapping-updated");
	 
	 Course course2= new Course("hibernate 2");
	 entityManager.persist(course2);
	 entityManager.flush();
	 
	 entityManager.detach(course2);
	 course2.setName("one to many mapping-updated");
	 
 }
	

	
}
