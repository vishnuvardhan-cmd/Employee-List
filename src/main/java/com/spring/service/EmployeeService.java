package com.spring.service;

import java.util.List;

import com.spring.pojo.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	public void save(Employee emp);
	Employee getById(int id);
	void deleteById(int id);
}
