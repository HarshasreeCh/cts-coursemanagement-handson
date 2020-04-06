package com.elearning.coursemanagement.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
import com.elearning.coursemanagement.model.StudentLogin;
import com.elearning.coursemanagement.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	private StudentServices studentservices;
	@GetMapping(value="/student")
	public String student(Model model) {
		StudentLogin s=new StudentLogin();
		model.addAttribute("student", s);
		return "student";
	}
	@PostMapping(value="/verifystudentlogin")
	public String loginverify(@Valid @ModelAttribute("student") StudentLogin s,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "student";
		}else {
			if(studentservices.login(s.getUsername(), s.getPassword())) {
				String msg=s.getUsername()+" successfully logged in";
				model.addAttribute("message", msg);
				return "success";
			}
			return "failure";
		}
}
	@GetMapping(value="/studentregistration")
	public String studentreg(Model model) {
		Student s=new Student();
		model.addAttribute("studentreg", s);
		return "studentreg";
	}
	@PostMapping(value="/reg")
	public String verifyStudentReg(@Valid @ModelAttribute("studentreg")Student student,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors()) {
			return "studentreg";
		}else {
			SimpleDateFormat s=new SimpleDateFormat();
			Date d=new Date();
			student.setDateCreated(d);
						
			int res=studentservices.registration(student);

			if(res==1) {				
				model.addAttribute("message", "You already registered.Please login<a href='student'>Login</a>");
				return "success";
			}else if(res==2) {
				model.addAttribute("message", "You  registration is successful.Please login<a href='student'>Login</a>");
				return "success";
			}
			return "failure";
		}
	
	}
@GetMapping("/listcourse")
	
	public String findAllCourses(HttpSession session, Model model)
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		List<Course>  courses = studentservices.getAllCourses();
		// stream
		// list foreach 
		//System.out.println(courses);
		model.addAttribute("courseList", courses);
		return "studenthome";
	}
	
	
	@GetMapping("/applycourse")
	public String applyCourse(@RequestParam("couresid") int id, HttpSession session, Model model)
	{
		System.out.println(id);
		//System.out.println(studentServices.getCourse(id));
	//	List<Course>  list = new ArrayList<Course>();
		
		
		String username = (String) session.getAttribute("stusername");
		
		    
 		Student s = studentservices.getStudent(username);  // 
 		List<Course>  list = s.getCourseList();
 		list.add(studentservices.getCourse(id));
 		  s.setCourseList(list);;
 		 boolean status =  studentservices.updateStudent(s);
 		 
 		 System.out.println(status);
		System.out.println((String) session.getAttribute("stusername"));
		return "studenthome";
	}

	@GetMapping("/mycourses")
	public String getStudentAppiesCourse(HttpSession session, Model model)
	
	{
		String username = (String)session.getAttribute("stusername");
		
	Student  s = studentservices.getStudent(username);
	
	
	model.addAttribute("courseList", s.getCourseList());
	
	return "studenthome";
		
	}
	
	@GetMapping("/logout")
@ResponseBody
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "<h1>Logged Out Successfully <a href='/student/'>Login Again</a>";
	}



}
