package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.JpaAndHibernateApplication;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
@RunWith(Runner.class)
@SpringBootTest(classes=JpaAndHibernateApplication.class)
class CourseRepositoryTest {

	  
	   @Autowired
	   CourseRepository repository;
	   
	   @Test
		void findById() {
			
			Course course =repository.findById(2);
			assertEquals("spring in 5 step",course.getName());
		}
	   
	    @Test
	    @DirtiesContext
		void deleteById_basic() {
			repository.deleteById(230l);
			assertNull(repository.findById(230l));
			
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
