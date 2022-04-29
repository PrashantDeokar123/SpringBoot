package com.sha.serverside.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prashantt_course_student")
public class CourseStudent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="student_id",referencedColumnName="id")
	private User student;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="course_id",referencedColumnName="id")
	private Course course;

	public CourseStudent(long id, User student, Course course) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("CourseStudent [id=%s, student=%s, course=%s]", id, student, course);
	}
	
	
}
