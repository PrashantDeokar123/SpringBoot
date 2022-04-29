package com.sha.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.serverside.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
