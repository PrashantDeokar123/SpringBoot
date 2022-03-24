package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="prashant_passport")
public class Passport {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable=false)
	String number;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	public Passport() {
		
		
	}


	public Passport(String number) {
		super();
		this.number = number;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return String.format("passport[%s %s]", number);
	}
	
}
