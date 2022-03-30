package com.example.jpa.and.hibernate.Jpa.and.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.jpa.and.hibernate.Jpa.and.hibernate.entity.Course;

@RepositoryRestResource(path="courses")

public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {

	List<Course> findByNameAndId(String name,long id);
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course>deleteByName(String name);
	
	@Query("select c from Course c where name like '%100 steps'")
	List<Course> courseWith100StepsInName();
	
	@Query(value="select * from Course c where name like '%100 steps'",nativeQuery=true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();
}
