package com.example.jpa.and.hibernate.Jpa.and.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.FullTimeEmployee;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.PartTimeEmployee;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Review;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Student;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.repository.CourseRepository;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.repository.EmployeeRepository;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaAndHibernateApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courserepository;

	@Autowired
	StudentRepository studentrepository;

	@Autowired
	EmployeeRepository employeerepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAndHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * logger.info(" find by id -> {}",repository.findById(585l));
		 * System.out.println("find by id -> {} "+repository.findById(585l));
		 * 
		 * 
		 * 
		 * Course course=repository.deleteById(183l);
		 * logger.info(" delete by id 183 -> {}",course);
		 * 
		 * 
		 * 
		 * courserepository.save(new Course("angular js"));
		 * 
		 * studentrepository.saveStudent();
		 * 
		 */
		/*
		 * courserepository.ReviewForCourse();
		 * 
		 * List<Review> reviews =new ArrayList<>(); reviews.add(new
		 * Review("1","most popular")); reviews.add(new Review("4","popular course"));
		 * courserepository.addReviewForCourse(1214, reviews);
		 * 
		 */

		// studentrepository.insertHardCodedStudentAndCourse();
		// studentrepository.insertStudentAndCourse(new Student("DIPAK"),new
		// Course("software testing"));

		// employeerepository.insert(new FullTimeEmployee("BADRI",new
		// BigDecimal(1000)));
		// employeerepository.insert(new PartTimeEmployee("KETUL",new BigDecimal(50)));
		// logger.info("retrieve all employees",employeerepository.retrieveEmployees());

		// logger.info("retrieve full time
		// employees",employeerepository.retrieveFullTimeEmployee());
		// logger.info("retrieve part time
		// employees",employeerepository.retrievePartTimeEmployee());

		//courserepository.deleteById(183l);
		courserepository.ReviewForCourse();
	}
}
