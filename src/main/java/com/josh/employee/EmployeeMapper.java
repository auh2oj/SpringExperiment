package com.josh.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setDept(rs.getString("dept"));
		e.setEmail(rs.getString("email"));
		
		return e;
	}

}
