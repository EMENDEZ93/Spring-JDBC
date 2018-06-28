package com.springcourse.dao;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.springcourse.pojo.Admin;

@Component("adminDao")
public class AdminDaoImplement implements AdminDao {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Admin admin) {
		MapSqlParameterSource paraMap = new MapSqlParameterSource();
		paraMap.addValue("nombre", admin.getNombre());
		paraMap.addValue("cargo", admin.getCargo());
		paraMap.addValue("fechaCreacion", admin.getFechaCreacion());

		return jdbcTemplate.
				update("insert into admin (nombre, cargo, fechaCreacion) values"
						+ " (:nombre, :cargo, :fechaCreacion)", paraMap) == 1;
	}

}
