package com.springcourse;

import java.sql.Timestamp;
import java.util.ArrayList;
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
		
		try {			

			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin("Yorguin", "Ingeniero", time ));
			admins.add(new Admin("Jairo", "Peluquero", time ));
			admins.add(new Admin("Alex", "bodeguero", time ));
			
			int[] vals = adminDao.saveAll(admins);
			
			for (int i : vals) {
				System.out.println("filar afectadas " + i );
			}
			
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();		
		}
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
	
}
