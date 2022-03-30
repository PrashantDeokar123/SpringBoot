package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Employee {

	@Id
	@GeneratedValue
	long id;
	@Column(nullable = false)
	String name;

	public Employee() {

	}

	public Employee(String name) {
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
		return String.format("Employee[%s]", name);
	}

}
