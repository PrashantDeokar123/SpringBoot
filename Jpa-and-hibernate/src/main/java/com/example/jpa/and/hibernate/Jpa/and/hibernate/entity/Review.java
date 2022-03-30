package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="prashant_review")
public class Review {

	@Id
	@GeneratedValue
	long id;
	@Enumerated(EnumType.STRING)
    private ReviewRating rating;
	String description;
	@ManyToOne
	private Course course;
	public Review() {
		
		
	}


	public Review(ReviewRating rating,String description) {
		super();
		this.rating=rating;
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ReviewRating getRating() {
		return rating ;
	}


	public void setRating(ReviewRating rating) {
		this.rating =rating;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating,description);
	}
	
}
