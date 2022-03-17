package com.example.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpademo.entity.Student;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {

	
	private Logger logger =(Logger) LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
	@Autowired
	JpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("find by id id -> {}",repository.findById( 1));
		System.out.println("find by id is -> {} "+repository.findById(1));
		
		
	    System.out.println("records inserted"+repository.insert(new Student("yash","cs","ram college")));
	   
	    logger.info("updating records -> {}",repository.update(new Student(97,"abhi","cs","qsc college")));
	    System.out.println("records updated");
	    
	 
	    repository.deleteById(98);
	    System.out.println("deleted ");
	    
	    logger.info(" find all student ->{}",repository.findAll());
	    System.out.println("find all student > {} "+repository.findAll());
	    
	    
	   
	
	}
	
	
	

}
