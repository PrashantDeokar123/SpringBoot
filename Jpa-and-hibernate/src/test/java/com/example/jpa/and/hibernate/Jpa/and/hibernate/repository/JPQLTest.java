package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
class JPQLTest {

	Logger logger =LoggerFactory.getLogger(this.getClass());
	  
	   @Autowired
	  EntityManager entityManager;
	
	   @Test 
	   public void jpql_basic() {
		   Query query =entityManager.createNamedQuery("Query_get",Course.class);
		   List resultList= query.getResultList(); 
	    logger.info("Select c From Course c -> {}",resultList);
	   
	   }
	   @Test
	   public void jpql_type() {
		   TypedQuery<Course>query=entityManager.createNamedQuery("Query_get",Course.class);
		   List resultList= query.getResultList(); 
		    logger.info("Select c From Course c -> {}",resultList);
	   }
		
		
	
		
		

}
