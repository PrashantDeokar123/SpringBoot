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
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.JpaAndHibernateApplication;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Review;

@RunWith(Runner.class)
@SpringBootTest(classes = JpaAndHibernateApplication.class)
class CourseRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	@Autowired
	EntityManager entityManager;

	@Test
	void findById() {

		Course course = repository.findById(582);
		assertEquals("hibernate 2", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById_basic() {
		repository.deleteById(185l);
		assertNull(repository.findById(185l));

	}

	@Test
	@DirtiesContext
	void saveMethod() {

		Course course = repository.findById(584);
		assertEquals("hibernate 1", course.getName());

		course.setName("junit and unit testing in 15 step");
		repository.save(course);

		Course course1 = repository.findById(584);
		assertEquals("junit and unit testing in 15 step", course1.getName());

	}

	@Test
	void entityManager() {

		repository.entityManager();
	}

	@Test
	@Transactional
	public void retriveReviewForCourse() {

		Course course = repository.findById(1110);
		logger.info("find review for course", course.getReview());
	}

	@Test
	@Transactional
	public void retriveCourseForReview() {

		Review review = entityManager.find(Review.class, 2001l);
		logger.info("find review for course", review.getCourse());
	}

	@Test
	@Transactional
	public void firstLevelCaching() {

		Course course = repository.findById(53l);
		System.out.println("retrieve course first" + course);
		logger.info("retrieve course first", course);

		Course course1 = repository.findById(53l);
		logger.info("retrieve course again ", course1);
		System.out.println("retrieve course again" + course1);

	}

}
