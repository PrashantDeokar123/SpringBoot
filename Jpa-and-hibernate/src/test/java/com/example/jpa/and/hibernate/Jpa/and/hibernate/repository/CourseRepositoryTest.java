package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.JpaAndHibernateApplication;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
@RunWith(Runner.class)
@SpringBootTest(classes=JpaAndHibernateApplication.class)
class CourseRepositoryTest {

	Logger logger =LoggerFactory.getLogger(this.getClass());
	  
	   @Autowired
	   CourseRepository repository;
	  

	   
	   @Test
		void findById() {
			
			Course course =repository.findById(575);
			assertEquals("hibernate 1",course.getName());
		}
	   
	    @Test
	    @DirtiesContext
		void deleteById_basic() {
			repository.deleteById(580l);
			assertNull(repository.findById(580l));
			
		}
		
		@Test
		@DirtiesContext
		void saveMethod() {
			
			Course course= repository.findById(2);
			assertEquals("spring in 5 step",course.getName());
			
			course.setName("junit and unit testing in 15 step");
			repository.save(course);
			
			Course course1= repository.findById(2);
			assertEquals("junit and unit testing in 15 step", course1.getName());
			
		}
		
		

}
