package com.springcourse.dao;

import java.util.List;

import com.springcourse.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin);
	public List<Admin> findAll();
	
}
