package com.elearning.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elearning.coursemanagement.dao.AdminDao;
import com.elearning.coursemanagement.dao.CourseDao;
import com.elearning.coursemanagement.model.Admin;
import com.elearning.coursemanagement.model.Course;
@Service
@Component
public class AdminServiceImpl  implements AdminService
{
     @Autowired
	private AdminDao adminDao;
    @Autowired 
    private CourseDao coursedao;
	@Override
	public boolean login(Admin admin) {

             
	Optional<Admin>	 a =adminDao.findById(admin.getUsername());
	Admin ad = a.get();
	
	if(ad.getPassword().equals(admin.getPassword()))
	{
		return true;
	}
		
		return false;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		Course c=coursedao.save(course);
		if(c!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Course> courseList() {
		// TODO Auto-generated method stub
		List<Course> p=(List<Course>) coursedao.findAll();
		return null;
	}

}
