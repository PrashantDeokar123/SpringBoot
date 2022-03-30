package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="prashant_student")
public class Student {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable=false)
	String name;

	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	@ManyToMany
   @JoinTable(name="STUDENT_COURSE",
   
   joinColumns=@JoinColumn(name="STUDENT_ID"),
   
   inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
   
		   
	private List<Course> courses =new ArrayList<>();
	
	@Embedded
	private Address address;
	
	public Student() {
		
		
	}


	public Student(String name) {
		super();
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Passport getPassport() {
		return passport;
	}


	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	


	public List<Course> getCourses() {
		return courses;
	}


	public void addCourses(Course courses) {
		this.courses.add(courses);
	}
	


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
	
}
