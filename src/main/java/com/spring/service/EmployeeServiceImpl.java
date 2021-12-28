package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pojo.Employee;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void save(Employee emp) {
		
		repo.save(emp);
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
//		Employee employee = repo.findById(id).get();
//		Employee e=null;
//		if(employee.isPresent())
//		{
//			
//		}
//		return employee;
		Optional<Employee> optional = repo.findById(id);
		Employee e=null;
		if(optional.isPresent())
		{
			e=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found with id"+id);
		}
		return e;
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

}