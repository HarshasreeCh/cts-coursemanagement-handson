package com.elearning.coursemanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elearning.coursemanagement.model.Course;

public interface CourseDao  extends CrudRepository<Course, Integer>{
	public List<Course> findAll();	

}
