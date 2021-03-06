package com.database.example.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.database.example.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTamplate;
	
	public List<Person> findAll(){
		
		return jdbcTamplate.query("select * from prashant_person",new BeanPropertyRowMapper(Person.class));
		
	}
  public Person findById(int id) {
		
		return jdbcTamplate.queryForObject("select *from prashant_person where id=?",
				new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}
  public Person findByName(String name) {
		
		return jdbcTamplate.queryForObject("select *from prashant_person where name=?",
				new Object[] {name},new BeanPropertyRowMapper<Person>(Person.class));
	}
  public Person findByLocation(String Location) {
		
		return jdbcTamplate.queryForObject("select *from prashant_person where location=?",
				new Object[] {Location},new BeanPropertyRowMapper<Person>(Person.class));
	}
  public int deleteById(int id) {
	  return jdbcTamplate.update("delete from prashant_person where id=?",
			  new Object[] { id});
  }
  public int deleteByName(String name) {
	  return jdbcTamplate.update("delete from prashant_person where name=?",
			  new Object[] { name });
	  
  }
 public  int insert(Person person) {
	  
	  return jdbcTamplate.update(
			  "insert into prashant_person (id, name, location, birth_date) "
			  + "values(?, ?, ?, ? )",
			  new Object[] {
					  person.getId(),person.getName(),person.getLocation(),
					  new Timestamp(person.getBirth_date().getTime())});
	  
  }
  

}
