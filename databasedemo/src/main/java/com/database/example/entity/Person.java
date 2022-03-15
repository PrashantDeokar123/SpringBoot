package com.database.example.entity;

import java.util.Date;

public class Person {

	private int id;
	private String name;
	private String location;
	private Date date_birth;
	  
	public Person(){
		
	}
	public Person(int id, String name, String location, Date date_birth) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.date_birth = date_birth;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate_birth() {
		return date_birth;
	}
	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}
	@Override
	public String toString() {
		return String.format("\nPerson [id=%s, name=%s, location=%s, date_birth=%s]", id, name, location, date_birth);
	}
	
	
	
}
