package com.elearning.coursemanagement.model;

import javax.validation.constraints.NotEmpty;

public class StudentLogin {
	@NotEmpty(message="name should not be empty")
	private String username;
	@NotEmpty(message="password must not be empty")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StudentLogin [username=" + username + ", password=" + password + "]";
	}
	

}
