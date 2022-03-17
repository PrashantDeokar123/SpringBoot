package com.example.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.*;
import javax.persistence.Table;

@Entity
@NamedQuery(name="find_all_student" ,query="select s from Student s")
@Table(name="prashant_student")
public class Student {

	@Id
	@GeneratedValue
	int id;
	String name;
	String branch;
	String collegename;
	
	public Student(){
		
	}

	public Student(int id, String name, String branch, String collegename) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.collegename = collegename;
	}

	public Student(String name, String branch, String collegename) {
		super();
		this.name = name;
		this.branch = branch;
		this.collegename = collegename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	@Override
	public String toString() {
		return String.format("\nStudent [id=%d, name=%s, branch=%s, collegename=%s]", id, name, branch, collegename);
	}
}
