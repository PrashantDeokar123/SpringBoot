package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Address;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Passport;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Student;

@RunWith(Runner.class)
@SpringBootTest(classes = JpaAndHibernateApplication.class)
class StudentRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	@Autowired
	StudentRepository repository;

	@Test
	@Transactional
	public void setAddressOfStudent() {

		Student student = entityManager.find(Student.class, 1386l);

		student.setAddress(new Address("at post chikhli", "at post shegaon", "buldhana"));
		entityManager.flush();

		
	
		

	}

	@Test
	@Transactional
	public void retrivePassportWithStudent() {

		Passport passport = entityManager.find(Passport.class, 4001l);
		logger.info("passport details -> {}", passport);
		logger.info("student is-> {}", passport.getStudent());

	}

	@Test
	public void TestUpdateMethod() {
		repository.updateTest();

	}

	@Test
	@Transactional
	public void retriveStudentAndCourse() {

		Student student = entityManager.find(Student.class, 781l);
		logger.info("student ", student);
		logger.info("student ", student.getCourses());

	}

}
