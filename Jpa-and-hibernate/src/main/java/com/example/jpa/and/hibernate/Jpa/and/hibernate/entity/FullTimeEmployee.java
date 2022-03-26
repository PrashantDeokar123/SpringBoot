package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
  private BigDecimal salary;
  
  
	protected FullTimeEmployee() {
		
		
		
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary=salary;
	}
	
	
	
	
	
	
	
}
