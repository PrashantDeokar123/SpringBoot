package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prashant_course")
public class Course {

	@Id
	@GeneratedValue
	long id;
	String name;
	
	public Course() {
		
		
	}


	public Course(String name) {
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


	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s]", id, name);
	}
	
}
