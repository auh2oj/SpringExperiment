package com.josh.employee;

import java.util.List;

import javax.sql.DataSource;

public interface EmployeeDAO {
	
	public void setDataSource(DataSource source);
	
	public void create(String name, String dept, String email, String branch);
	
	public List<Employee> listEmployees();
	
	public Employee getEmployee(String email);
	
	//public void delete(String email);
	
	public void deleteAll();
}
