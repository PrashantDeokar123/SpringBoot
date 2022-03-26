package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="prashant_course")

public class Course {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable=false)
	String name;
	@OneToMany(mappedBy="course")
	private List<Review> review =new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students =new ArrayList<>();
	
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


	public List<Review> getReview() {
		return review;
	}


	public void addReview(Review review) {
		this.review.add(review);
	}
	public void removeReview(Review review) {
		this.review.remove(review);
	}

	public List<Student> getStudent() {
		return students;
	}


	public void addStudent(Student student) {
		this.students.add(student);
	}


	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s]", id, name);
	}
	
}
