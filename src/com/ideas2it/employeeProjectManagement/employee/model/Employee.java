/**
 * Package to have Employee class which has all employee details variables
 */
package com.ideas2it.employeeProjectManagement.employee.model;

import java.util.List;

import com.ideas2it.employeeProjectManagement.project.model.Project;

/**
 * The Employee class is used for encapsulation of data
 * 
 * @author  Ak
 * @since   22-01-2021
 * @version 1.0
 */
public class Employee {
	
	private int employeeId;
	private String firstName;
	private String secondName;
	private String designation;
	private String salary;
	private String emailId;
	private String dateOfBirth;
	private String phoneNumber;
	private List<Address> address;
	private List<Project> project;

	// Empty constructor
	public Employee() {
	}
 
	/**
	 * Employee Parametrised constructor
	 * 
	 * @param 	employeeId	            employee id
	 * @param 	firstName 	    employee first name
	 * @param 	secondName	    employee second name
	 * @param 	designation 	designation of employee
	 * @param 	salary	        salary of employee
	 * @param 	emailId	        emailId of an employee 
	 * @param 	dateOfBirth	    dateOfBirth of an employee
	 * @param 	phoneNumber 	phone number of an employee
	 */
	public Employee(String firstName, String secondName, String designation, 
			String salary, String emailId, String dateOfBirth, String phoneNumber) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.designation = designation;
		this.salary = salary;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}	

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public String toString() {
		return(firstName + " " + secondName + " " + designation + " " + salary + 
				" " + emailId + " " + dateOfBirth + " " + phoneNumber);
	}
}
