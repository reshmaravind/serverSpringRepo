/**
 * 
 */
package com.spring.serverapp.model;

import java.util.Objects;

public class Employee {

	
	private long id;
	private String employeeName;
	private String designation;
	private String location;
	private String contactNumber;
	
	protected Employee() {}
	
	public Employee(long id, String employeeName, String designation, String location, String contactNumber) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.designation = designation;
		this.location = location;
		this.contactNumber = contactNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
}
