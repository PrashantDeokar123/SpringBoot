package com.example.jpa.and.hibernate.Jpa.and.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
  private BigDecimal hourlyWage;
  
  
	protected PartTimeEmployee() {
		
		
	}

public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage=hourlyWage;
	}
	
	
	
	
	
	
	
}
