package com.springcourse;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springcourse.dao.AdminDao;
import com.springcourse.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
	
		Timestamp time = new Timestamp(new Date().getTime()); 
		Admin admin = new Admin();
		admin.setCargo("Gerente");
		admin.setNombre("Edwin");
		admin.setFechaCreacion(time);	
		
		
		if(adminDao.save(admin)) {
			System.out.println("Admin Salvado Correctamente");
		} else {
			System.out.println("Error al guardar...");		
		}	
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
	
}
