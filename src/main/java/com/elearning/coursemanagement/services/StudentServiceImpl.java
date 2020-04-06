package com.elearning.coursemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elearning.coursemanagement.dao.CourseDao;
import com.elearning.coursemanagement.dao.StudentDao;
import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
@Component
public class StudentServiceImpl implements StudentServices {
	@Autowired
	private StudentDao dao;
	 @Autowired
     private CourseDao courseDao;
	
	// registra =
	// re
	//  1 2 3 
	@Override
	public int registration(Student s) {
		// TODO Auto-generated method stub
		Student student =dao.findByName(s.getName());
		if(student!=null) {
			return 1;
		}else {
			Student s1=dao.save(s);
			if(s1!=null) {
				return 2;
			}
		}
		return 3;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Student student=dao.findByName(username);
		if(student!=null && student.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean updateStudent(Student student) {
 // studentDao.sa
Student s =dao.save(student);
if(s!=null)
{
	return true;
}
		return false;
	}

	@Override
	public List<Course> getAllCourses() {
		
		
		
		return  courseDao.findAll();
	}

	@Override
	public Course getCourse(int id) {
		
		return courseDao.findById(id).get();
	}

	@Override
	public Student getStudent(String username) {

              
		return dao.findByName(username);
	}


}
