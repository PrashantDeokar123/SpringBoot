package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Subgraph;

import org.hibernate.graph.SubGraph;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.JpaAndHibernateApplication;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Review;

@RunWith(Runner.class)
@SpringBootTest(classes = JpaAndHibernateApplication.class)
class PerformanceTuningTest {

	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional
	void creatingNPlusOneProblem() {

		List<Course> courses = entityManager.createNamedQuery("Query_get",Course.class)
				.getResultList();
		for(Course course:courses) {
			
			logger.info("all courses and student ",course,course.getStudent());
			
		}
	}
		
		@Test
		@Transactional
		void solveingNPlusOneProblem_Entity_Graph() {
			EntityGraph<Course> EntityGraph = entityManager.createEntityGraph(Course.class);
			Subgraph<Object> subgraph=EntityGraph.addSubgraph("students");
			List<Course> courses = entityManager.createNamedQuery("Query_get",Course.class)
					.setHint("javax.persistence.loadgraph", EntityGraph)
					.getResultList();
			for(Course course:courses) {
				
				logger.info("all courses and student ",course,course.getStudent());
				
			}
		
	
	}
     
}
