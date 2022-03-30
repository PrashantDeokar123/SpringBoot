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
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Student;
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
	   
	   @Test
	   public void jpql_Course_Without_Student() {
		   
		   TypedQuery<Course> query= entityManager.createQuery("select c from Course c where c.students is empty", Course.class);
		    List<Course> resultList= query.getResultList();
		    logger.info("course without students",resultList);
		   
		   
	   }
		
      @Test
      public void jpql_Course_with_Atleast_2_Students() {
    	  
    	  TypedQuery<Course> query=entityManager.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
    	  
    	  List<Course> resultList= query.getResultList();
    	  logger.info("At Least 2 Students",resultList);
      }
      @Test 
      public void jpql_Course_Ordered_By_Student() {
    	  
    	  TypedQuery<Course> query= (TypedQuery<Course>) entityManager.createQuery("select c from Course c order By size(c.students) desc");
    	   List<Course> resultList =query.getResultList();
    	  
    	   logger.info("order by",resultList);
      }
      
      @Test
       public void find_Passport_Number_like() {
    	  
    	  TypedQuery<Student> query= (TypedQuery<Student>) entityManager.createQuery("select s from Student s where s.passport.number like '%123%'",Student.class);
    	  
    	  List<Student> resultList= query.getResultList();
    	  logger.info("get passport using like  cluse ",resultList);
    	  
      }
      @Test
      public void joins() {
    	  
    	  Query query= entityManager.createQuery("select c,s from Course c JOIN c.students s");
    	  List<Object[]> resultList= query.getResultList();
    	  logger.info(" resultList size-> {} ",resultList.size());
    	  for(Object[] result:resultList) {
    		  logger.info("Course{} Student{} ",result[0],result[1]);
    		  
    		  
    	  }
    	  
      }
      
		
	
		
		

}
