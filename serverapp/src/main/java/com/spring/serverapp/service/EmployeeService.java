package com.spring.serverapp.service;

import java.util.List;

import com.spring.serverapp.model.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee deleteById(long id);

}
