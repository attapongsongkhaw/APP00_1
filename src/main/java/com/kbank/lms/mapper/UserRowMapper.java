package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.User;

public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User(); 
        user.setUsername(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setId(rs.getInt("ID_USER"));
        user.setRole(rs.getString("ROLE"));
        return user; 
	}

}