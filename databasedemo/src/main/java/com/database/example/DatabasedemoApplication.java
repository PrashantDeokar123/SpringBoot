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
		
		logger.info("User id 13 ->{}",dao.findById(15));
		System.out.println("find By Id -> {}"+dao.findById(15));
		
		logger.info("find By Name ->{}",dao.findByName("prashant"));
		System.out.println("find By Name -> {}"+dao.findByName("prashant"));
		
		logger.info("find By Location ->{}",dao.findByLocation("pune"));
		System.out.println(" find By Location -> {}"+dao.findByLocation("pune"));
		
		logger.info("delete By Id -> number of rows - {}",dao.deleteById(16));
		System.out.println("deleted by using id -> {}"+dao.deleteById(16));
		
		
		logger.info("delete By Name, prashant -> numbers of rows - {}",dao.deleteByName("yash"));
		System.out.println("deleted by using name  -> {}"+dao.deleteByName("yash"));
		
		logger.info("inserting 40 -> number of row -{}",dao.insert(new Person(18,"banti","pune",new Date())));
		  
	   
	  
	}
	

}
