package com.spring.serverapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.serverapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static List<Employee> employees = new ArrayList<Employee>();
	private static int idCounter=0;
	static {
		employees.add(new Employee(++idCounter,"Reshma","Software Developer","Kochi","8848685878"));
		employees.add(new Employee(++idCounter,"Remya","SAP Consultant","Bangalore","8301820264"));
		employees.add(new Employee(++idCounter,"Ajay","Senior Software Developer","Pune","9566809489"));
	}
	
	public List<Employee> findAll(){
		return employees;
	}
	
	public Employee deleteById(long id) {
		Employee employee = findById(id);
		if(employee==null) {
			return null;
		}
		employees.remove(employee);
		return employee;
	}

	public Employee findById(long id) {
		for (Employee emp:employees) {
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;
	}
	
	public Employee saveOrUpdate(Employee employee) {
		if(employee.getId()==-1 || employee.getId()==0) {
			employee.setId(++idCounter);
			employees.add(employee);
		}else {
			deleteById(employee.getId());
			employees.add(employee);
		}
		return employee;
	}

}
