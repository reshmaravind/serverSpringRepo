package com.spring.serverapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.serverapp.model.Employee;
import com.spring.serverapp.service.EmployeeServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ServerAppController {
	
	@Autowired
	private EmployeeServiceImpl EmployeeService;
	
	//To get all user details
	@GetMapping(path="/getUsers")
	public List<Employee> getAllEmployees(){
		return EmployeeService.findAll();
	}
	
	//To delete a user
	@DeleteMapping(path="/deleteUser/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id){
		Employee emp= EmployeeService.deleteById(id);
		if(emp!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	//To fetch user by Id
	@GetMapping(path="/user/{id}")
	public Employee getUserById(@PathVariable long id){
		return EmployeeService.findById(id);
		}
	
	//To update user by Id
	@PutMapping(path="/userupdate/{id}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable long id,@RequestBody Employee employee){
		Employee emp = EmployeeService.saveOrUpdate(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	//To create user
	@PostMapping(path="/usercreate")
	public ResponseEntity<Void> createEmployeeDetails(@RequestBody Employee employee){
		Employee emp = EmployeeService.saveOrUpdate(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}


}