package com.springcourse.dao;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
//		MapSqlParameterSource paraMap = new MapSqlParameterSource();
//		paraMap.addValue("nombre", admin.getNombre());
//		paraMap.addValue("cargo", admin.getCargo());
//		paraMap.addValue("fechaCreacion", admin.getFechaCreacion());

		BeanPropertySqlParameterSource paraMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.
				update("insert into admin (nombre, cargo, fechaCreacion) values"
						+ " (:nombre, :cargo, :fechaCreacion)", paraMap) == 1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbcTemplate.query("select * from admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setIdAd(rs.getInt("idAd"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				admin.setNombre(rs.getString("nombre"));
				return admin;
			}
		});
	}

}
