package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="prashant_course")
@NamedQuery(name = "get_all_records", query = "select c from Course c")
public class Course {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable=false)
	String name;
	@CreationTimestamp
	LocalDateTime created_date;
	@UpdateTimestamp
	LocalDateTime last_update_date;
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
