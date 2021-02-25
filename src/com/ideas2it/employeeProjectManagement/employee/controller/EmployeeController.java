/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.employee.service.EmployeeServiceImpl;

/**
 * EmployeeController is an interface between EmployeeView and Employee Service
 *
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class EmployeeController {

	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * To add Employee details to an array List All parameters are passed in the
	 * method.
	 * 
	 * @param employeeId	       employee id
	 * @param firstName 	       employee first name
	 * @param secondName	       employee second name
	 * @param designation 	       designation of employee
	 * @param salary	           of employee
	 * @param emailId	           email of an employee 
	 * @param age	               age of an employee
	 * @param phoneNumber 	       phone number of an employee
	 * @param projectName	       name of project allocated to employee
	 * @param streetAddress        permanent street address of an employee
	 * @param state                Permanent state
	 * @param city                 permanent city
	 * @param postalCode           permanent postalCode
	 * @param currentStreetAddress current street address
	 * @param currentState         current state
	 * @param currentCity          current city
	 * @param currentPostalCode    current postal code
	 * @throws SQLException        to suppress SQLException
	 */
	public int createEmployeeDetails(String firstName, String secondName,
			String designation, String salary,	String emailId, String dateOfBirth, String phoneNumber, 
			String streetAddress, String state, String city,
			String postalCode,	String currentStreetAddress, String currentState,
			String currentCity, String currentPostalCode) throws SQLException {
		int employeeId = employeeService.createEmployeeDetails(firstName, secondName, designation, salary,
				emailId, dateOfBirth, phoneNumber, streetAddress,  state, city,
				postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
		return employeeId;
	}

	/**
	 * To view List of all employee Details.
	 * 
	 * @return  returns employee details List
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> viewEmployeeList() throws SQLException {
		return employeeService.viewEmployeeList();
	}

	/**
	 * To delete employee details by id
	 * 
	 * @param employeeId  Delete details for this id 
	 * @return            boolean 
	 * @throws SQLException 
	 */
	public boolean employeeDelete(int employeeId) throws SQLException {
		return employeeService.employeeDelete(employeeId);
	}

	/**
	 * To view employee Details by Id
	 * 
	 * @param employeeId   View details of employee by id
	 * @return             returns employee details for id.
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> viewEmployeeDetails(int employeeId) throws SQLException {
		return employeeService.viewEmployeeDetails(employeeId);
	}  

	/**
	 * 
	 * @param employeeId	       employee id
	 * @param firstName 	       employee first name
	 * @param secondName	       employee second name
	 * @param designation 	       designation of employee
	 * @param salary	           of employee
	 * @param emailId	           email of an employee 
	 * @param age	               age of an employee
	 * @param phoneNumber 	       phonenumber of an employee
	 * @param projectName	       name of project allocated to employee
	 * @param streetAddress        permanent street address of an employee
	 * @param state                Permanent state
	 * @param city                 permanent city
	 * @param postalCode           permanent postalCode
	 * @param currentStreetAddress current street address
	 * @param currentState         current state
	 * @param currentCity          current city
	 * @param currentPostalCode    current postal code
	 * @throws SQLException        to suppress SQLException
	 * @return                     boolean
	 */
	public boolean isUpdateEmployeeDetails(int employeeId, String firstName,
			String secondName, String designation, String salary,	
			String emailId, String dateOfBirth, String phoneNumber, 
			String streetAddress, String state, String city,
			String postalCode,	String currentStreetAddress, String currentState,
			String currentCity, String currentPostalCode) throws SQLException {
		return employeeService.isUpdateEmployeeDetails(employeeId, firstName,
				secondName, designation, salary, emailId, dateOfBirth, phoneNumber,
				streetAddress, state, city, postalCode, currentStreetAddress, 
				currentState, currentCity, currentPostalCode);
	}

	/**
	 * To get the projectIds List
	 * @return              projectId lists
	 * @throws SQLException to suppress SQLException
	 */
	public List<Set<Integer>> availableProjects() 
			throws SQLException {
		return employeeService.availableProjects();
	}

	/**
	 * To assign project to employee
	 * 
	 * @param employeeId        employeeId 
	 * @param employeeProjects  projects for employeeId
	 * @return                  boolean
	 * @throws SQLException     to suppress SQLException
	 */
	public boolean isProjectAssign(int employeeId, List<Integer> employeeProjects)
			throws SQLException {
		return employeeService.isProjectAssign(employeeId, employeeProjects);
	}
}

