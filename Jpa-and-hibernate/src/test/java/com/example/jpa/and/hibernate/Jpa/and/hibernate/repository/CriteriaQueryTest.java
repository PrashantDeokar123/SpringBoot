package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
class CriteriaQueryTest {

	Logger logger =LoggerFactory.getLogger(this.getClass());
	  
	   @Autowired
	  EntityManager entityManager;
	
    	  
		@Test
		public void criteriaBuilder() {

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Course> cq = cb.createQuery(Course.class);
			Root<Course> courseRoot = cq.from(Course.class);

			TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));

			List<Course> resultList = query.getResultList();
			logger.info("get passport using like  cluse ", resultList);

		}
		
		  
				@Test
				public void criteriaBuilderUsedLike() {

					CriteriaBuilder cb = entityManager.getCriteriaBuilder();
					CriteriaQuery<Course> cq = cb.createQuery(Course.class);
					Root<Course> courseRoot = cq.from(Course.class);

					Predicate like100step= cb.like(courseRoot.get("name"),"%100 steps");
					cq.where(like100step);
					TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));

					List<Course> resultList = query.getResultList();
					logger.info("Typed Query ", resultList);

				}
		      
				@Test
				public void allCoursesWithoutStudents() {

					CriteriaBuilder cb = entityManager.getCriteriaBuilder();
					CriteriaQuery<Course> cq = cb.createQuery(Course.class);
					Root<Course> courseRoot = cq.from(Course.class);

					Predicate studentIsEmpty= cb.isEmpty(courseRoot.get("students"));
					cq.where(studentIsEmpty);
					TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));

					List<Course> resultList = query.getResultList();
					logger.info("Typed Query ", resultList);

				}
      
		
				@Test
				public void joins() {

					CriteriaBuilder cb = entityManager.getCriteriaBuilder();
					CriteriaQuery<Course> cq = cb.createQuery(Course.class);
					Root<Course> courseRoot = cq.from(Course.class);
                    Join<Object, Object> join= courseRoot.join("students");
					
					TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));

					List<Course> resultList = query.getResultList();
					logger.info("Typed Query ", resultList);

				}
	
		
		
}

