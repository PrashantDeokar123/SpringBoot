package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.JpaAndHibernateApplication;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
//import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.CourseSpringDataRepository;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Review;
@RunWith(Runner.class)
@SpringBootTest(classes=JpaAndHibernateApplication.class)
class CourseSpringDataRepositoryTest {

	

	Logger logger =LoggerFactory.getLogger(this.getClass());
	  
	   @Autowired
	   CourseSpringDataRepository repository;
	  @Autowired
	  EntityManager entityManager;
	  
	
	
	  /* @Test
	   public void findById_CoursePresent() {
		   
		   Optional<Course> courseoptional= repository.findById(53l);
		   
		   logger.info("find By Id ", courseoptional.isPresent());
		   assertTrue(courseoptional.isPresent());
	   }*/
	   
	   @Test
	   public void findById_CourseNotpresent() {
		   
		   Optional<Course> courseoptional= repository.findById(576211l);
		   
		   logger.info("find By Id ", courseoptional.isPresent());
		   assertTrue(courseoptional.isEmpty());
	   }
	   
	   @Test
	   public void insert_Course() {
		   
		   Course course= new Course("jpa repository");
		   repository.save(course);
		   course.setName("jpa repository updated");
		   repository.save(course);
		   
	   }
	   @Test
	   public void find_Course() {
		   
		  logger.info("find all course -> {}",repository.findAll());
		  logger.info("find all course -> {}",repository.count());

	   }
	   
	   @Test
	   public void sort() {
		   
		  Sort sort=  Sort.by(Sort.Direction.DESC, "name");
		  Sort sort1= Sort.by(Sort.Direction.ASC,"name");
		  logger.info("sorted courses -> {}",repository.findAll(sort));
		  logger.info("sorted courses -> {}",repository.findAll(sort1));
		 

	   }
	   
	   @Test
	   public void pagination() {
	  
	 org.springframework.data.domain.PageRequest pagerequest= org.springframework.data.domain.PageRequest.of(0, 2);
		 Page<Course> firstPage= repository.findAll(pagerequest);
		 logger.info("first page -> {}",firstPage.getContent());

		 
		 org.springframework.data.domain.Pageable nextpageable= firstPage.nextPageable();
		 Page<Course> next= repository.findAll(pagerequest);
		 logger.info("first page -> {}",next.getContent());
		 
	   }
	   @Test
	   public void findByName() {
		   
		   logger.info(" find By name",repository.findByName("jpa in 4 steps"));
		  
		 

	   }
	   
	 
		

}
