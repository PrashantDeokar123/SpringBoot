package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Passport;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

     @Autowired
	 EntityManager entityManager;
	
	public void saveStudent() {
	
		Student student =new Student("akash");
		entityManager.persist(student);
		
		Passport passport =new Passport("E651298");
		entityManager.persist(passport);
	
		student.setPassport(passport);
	
	}
public void updateTest() {
		
	//retrive
		Student student= entityManager.find(Student.class,803l);
		//getpassport
		Passport passport=student.getPassport();
		//set student name
		student.setName("vaibhav -updated");
		//set passport
		passport.setNumber("T763456");
		

      
	}
    public void insertHardCodedStudentAndCourse() {
	
	Student student =new Student("rushi");
    Course course=new Course("bootstrap");
    
	
	
	student.addCourses(course);
	course.addStudent(student);
	
	entityManager.persist(student);
	entityManager.persist(course);
	
	entityManager.persist(student);
}
    
    public void insertStudentAndCourse(Student student,Course course) {
    	
   
        
        student.addCourses(course);
    	course.addStudent(student);
    	
    	entityManager.persist(student);
    	entityManager.persist(course);
    	
    
    }
 

	
}
