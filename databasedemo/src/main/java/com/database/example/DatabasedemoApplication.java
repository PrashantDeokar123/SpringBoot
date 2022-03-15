package com.database.example;



import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.example.entity.Person;
import com.database.example.jdbc.PersonJdbcDao;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class DatabasedemoApplication implements CommandLineRunner {

	private Logger logger =(Logger) LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DatabasedemoApplication.class, args);
		
	}
	@Override
	public void run(String...args) throws Exception{
		logger.info("All users -> {}",dao.findAll());
		System.out.println("All users -> {}"+dao.findAll());
		
		logger.info("User id 13 ->{}",dao.findById(26));
		System.out.println("find By Id -> {}"+dao.findById(14));
		
		logger.info("find By Name ->{}",dao.findByName("vaibhav"));
		System.out.println("find By Name -> {}"+dao.findByName("vaibhav"));
		
		logger.info("find By Location ->{}",dao.findByLocation("shegaon"));
		System.out.println(" find By Location -> {}"+dao.findByLocation("shegaon"));
		
		logger.info("delete By Id -> number of rows - {}",dao.deleteById(27));
		System.out.println("deleted by using id -> {}"+dao.deleteById(27));
		
		
		logger.info("delete By Name, prashant -> numbers of rows - {}",dao.deleteByName("nikhil"));
		System.out.println("deleted by using name  -> {}"+dao.deleteByName("nikhil"));
		
		logger.info("inserting 40 -> number of row -{}",dao.insert(new Person(40,"banti","pune",new Date())));
		  
	   
	  
	}
	

}
