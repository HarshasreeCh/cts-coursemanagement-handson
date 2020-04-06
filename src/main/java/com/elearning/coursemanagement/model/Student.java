package com.elearning.coursemanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="student")
public class Student {
	@SequenceGenerator(name = "elstudentSeq",initialValue = 2020, allocationSize = 1, sequenceName = "EL_STUDENT_SEQ")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elstudentSeq")
	@Column
	private int id;
	@Column(unique=true)
	@NotEmpty(message="Name should not be empty")
	@Size(min=6,max=20,message="Name must be with minimum of 6 characters and maximum of 20 characters")
	private String name;
	@Column
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$",message="enter minimum 7 to 15 characters which contain at least one numeric digit and a special character")
	private String password;
	@Column
	@Email
	private String email;
	@Column
	
	private String mobile;
	@Column
	private Date dateCreated;
	 @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinTable(name="STUDENT_COURSE",joinColumns = {@JoinColumn(name="S_NO",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name="C_NO", referencedColumnName = "courseid")})
	List<Course>  courseList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", dateCreated=" + dateCreated + ", courseList=" + courseList + "]";
	} 
	
		
}
