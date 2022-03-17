package com.example.jpa.and.hibernate.Jpa.and.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.repository.CourseRepository;

@SpringBootApplication
public class JpaAndHibernateApplication  implements CommandLineRunner{
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JpaAndHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
     logger.info(" find by id -> {}",repository.findById(2l));
     System.out.println("find by id -> {} "+repository.findById(2l));
  
	

		Course course=repository.findById(2l);
		logger.info(" delete by id 2 -> {}",course);
       
		repository.save(new Course("entity manager  in 5 step "));
	
       
      
	}
}
