package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Review;

import ch.qos.logback.classic.Logger;

@Repository
@Transactional
public class CourseRepository {
private Logger logger=(Logger) LoggerFactory.getLogger(this.getClass());
     @Autowired
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
 
 public void ReviewForCourse() {
	 
	 Course course=entityManager.find(Course.class,1213l);
	 logger.info("course",course);
	 logger.info("review of course",course.getReview());
	 
	 Review review=new Review("1","great hands-stuff.");
	 Review review1=new Review("2","great");
	
	 course.addReview(review);
	 review.setCourse(course);
	 
	 course.addReview(review1);
	 review1.setCourse(course);
	entityManager.persist(review);
	 entityManager.persist(review1);
	 
	 
	 
 }
 public void addReviewForCourse(long courseid, List<Review> reviews) {
	 
	 Course course=findById(courseid);
	 logger.info("course",course);
	 logger.info("review of course",course.getReview());
	 
	for(Review review: reviews) {
	
	 course.addReview(review);
	 review.setCourse(course);
	 
	
	entityManager.persist(review);
	 
 }
  
	
 }
	
}
