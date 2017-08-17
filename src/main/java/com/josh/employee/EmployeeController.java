package com.josh.employee;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeController implements EmployeeDAO {
	
	private DataSource dataSource;
	private JdbcTemplate template;

	public void setDataSource(DataSource source) {
		this.dataSource = source;
		this.template = new JdbcTemplate(source);
	}

	public void create(String name, String dept, String email, String branch) {
		String sql = "Insert into Employees (name, department, email, branch) values (?, ?, ?, ?)";
		template.update(sql, name, dept, email, branch);
	}

	public List<Employee> listEmployees() {
		String sql = "Select * from Employees";
		List<Employee> employees = template.query(sql, new EmployeeMapper());
		return employees;
	}

	public Employee getEmployee(String email) {
		String sql = "Select * from Employees where email=?";
		Employee employee = template.queryForObject(sql, new Object[] {email}, new EmployeeMapper());
		return employee;
	}

	public void deleteAll() {
		String sql = "Delete from Employees";
		template.update(sql);
	}

}
