package com.example.jpademo;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.jpademo.entity.Student;

@Repository
@Transactional
public class JpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Student findById(int id) {
		return entityManager.find(Student.class, id);

	}

	public Student insert(Student student) {
		return entityManager.merge(student);
    
	}
     
	public Student update(Student student) {
		return entityManager.merge(student);
	}

	public void deleteById(int id) {
		Student student = findById(98);
		entityManager.remove(student);
	}
	
	public List<Student> findAll(){
		
		TypedQuery<Student> namedQuery=entityManager.createNamedQuery("find_all_student",Student.class);
		return namedQuery.getResultList();
	}

	
	}


