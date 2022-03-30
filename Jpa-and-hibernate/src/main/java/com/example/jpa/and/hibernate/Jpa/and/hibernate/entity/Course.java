package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prashant_course")
@NamedQuery(name = "Query_get", query = "select c from Course c")
@Cacheable
@SQLDelete(sql = "update prashant_course set is_delete=true where id=?")
@Where(clause = "is_delete=false")
public class Course {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable = false)
	String name;
	private boolean isDelete;
	@OneToMany(mappedBy = "course")
	private List<Review> review = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	@CreationTimestamp
	LocalDateTime created_date;
	@UpdateTimestamp
	LocalDateTime last_update_date;
	private static Logger Logger = LoggerFactory.getLogger(Course.class);

	@PreRemove
	private void preRemove() {
		Logger.info("setting isDelete is True");
		this.isDelete = true;
	}

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
