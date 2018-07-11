package com.springcourse;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.springcourse.dao.AdminDao;
import com.springcourse.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
	
		Timestamp time = new Timestamp(new Date().getTime()); 
		Admin admin = new Admin();
		admin.setCargo("Gerente");
		admin.setNombre("Mendez");
		admin.setFechaCreacion(time);	
		
		try {			
			adminDao.save(admin);
			
			//List<Admin> admins = adminDao.
			
			List<Admin> admins = adminDao.findAll();
			
			System.out.println("********************************");
			for (Admin admin2 : admins) {
				System.out.println(admin2);
			}
			
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();		
		}
		
		
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
	
}
