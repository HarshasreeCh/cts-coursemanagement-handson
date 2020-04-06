package com.elearning.coursemanagement.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elearning.coursemanagement.model.Admin;
import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.services.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminServices;
	
	@GetMapping("/")

	public String adminLogin(Model model)
	{
	  Admin admin = new Admin();
	  model.addAttribute("admin", admin);
	  return "admin";
	}

	
	@PostMapping("/adminlogin")
	public String VerifyAdminLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model, HttpSession session)
	{
		
		if(result.hasErrors())
		{
			return "admin";
		}
		else {
		
		if(adminServices.login(admin))
		{
			session.setAttribute("adminusername", admin.getUsername());
			session.setMaxInactiveInterval(120);
			//model.addAttribute("adminusername", admin.getUsername());
			return "adminhome";
		}
		
		model.addAttribute("message", "Invalid UserName or Password");
		//System.out.println(admin);
		return "failure";
		}
	}
	
	@GetMapping("/addCourse")
	public String addCourse(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("adminusername");
		if(username==null)
		{
			model.addAttribute("course", new Course());
			model.addAttribute("addmessage", "Pleas Login First <a href='/admin/'>");
			return "adminhome";
		}
		model.addAttribute("course", new Course());
		return "addcourse";
	}
	
	@GetMapping("/adminLogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/addcourse1")
	public String createCourse(@ModelAttribute("course") Course course,Model model)
	{
		System.out.println(course);
		// calculated the duration between dates
		long diff = course.getEndDate().getTime()-course.getStartDate().getTime();
		int duration = (int)(diff/(1000*60*60*24));
		course.setDuration(duration);
		boolean status = adminServices.addCourse(course);
		
		if(status)
		{
			model.addAttribute("coursemessage", "Course Added");
			return "adminhome";
		}
		else
		{
			model.addAttribute("coursemessage", "Course Not  Added");
			return "adminhome";
		}
	}
}
	

