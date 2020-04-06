package com.elearning.coursemanagement.services;

import java.util.List;

import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;

public interface StudentServices {
	public boolean login(String username,String password);
	public int registration(Student s);
	public boolean updateStudent(Student student);
	public Student getStudent(String username);
	public Course getCourse(int id);
	public List<Course> getAllCourses(); 
	

}
