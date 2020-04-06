package com.elearning.coursemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.elearning.coursemanagement.model.Admin;

public interface AdminDao  extends CrudRepository<Admin, String>{

}
