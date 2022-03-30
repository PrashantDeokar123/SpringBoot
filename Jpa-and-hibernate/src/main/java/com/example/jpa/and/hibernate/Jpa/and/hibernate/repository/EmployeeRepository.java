package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Employee;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.FullTimeEmployee;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.PartTimeEmployee;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Passport;
import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Student;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;

	// insert employee
	public void insert(Employee employee) {

		entityManager.persist(employee);

	}

	// retrive employee
	public List<Employee> retrieveEmployees() {

		return entityManager.createQuery("Select e From Employee e", Employee.class).getResultList();

	}

	// retrieve full time employee
	public List<FullTimeEmployee> retrieveFullTimeEmployee() {

		return entityManager.createQuery(" select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

	// retrieve full time employee
	public List<PartTimeEmployee> retrievePartTimeEmployee() {

		return entityManager.createQuery(" select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

}
