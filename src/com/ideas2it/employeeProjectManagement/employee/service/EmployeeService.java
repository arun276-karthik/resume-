/**
 * 
 */
package com.ideas2it.employeeProjectManagement.employee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Admin
 *
 */
public interface EmployeeService {

	/**
	 * To view all Employee details list
	 * 
	 * @return employeeList  the Employee details list
	 * @throws SQLException 
	 */
	public ArrayList<LinkedHashMap<String, Object>> viewEmployeeList() 
			throws SQLException;

	/**
	 * Add the employee details and address details
	 * checking the employee id is already present or not
	 * 
	 * @param firstName 	         employee first name
	 * @param secondName	         employee second name
	 * @param designation 	         designation of employee
	 * @param salary	             of employee
	 * @param emailId	             email of an employee 
	 * @param age	                 age of an employee
	 * @param phoneNumber 	         phone number of an employee
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @throws SQLException          suppress the SQLException
	 */
	public int createEmployeeDetails(String firstName, String secondName,
			String designation, String 	salary, String emailId, 
			String dateOfBirth, String phoneNumber, String streetAddress,
			String state, String city, String postalCode, String currentStreetAddress,
			String currentState, String currentCity, String currentPostalCode) 
					throws SQLException;

	/**
	 * To delete employee details by id.
	 * 
	 * @param  employeeId    to delete the details by employeeId  
	 * @return               boolean
	 * @throws SQLException  to suppress SQL exception
	 */
	public boolean employeeDelete(int employeeId) throws SQLException;

	/**
	 * To update employee Details and the boolean is returned
	 * 
	 * @param employeeId             employeeId to update details
	 * @param firstName 	         employee first name
	 * @param secondName	         employee second name
	 * @param designation 	         designation of employee
	 * @param salary	             of employee
	 * @param emailId	             email of an employee 
	 * @param age	                 age of an employee
	 * @param phoneNumber 	         phone number of an employee
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @throws SQLException          suppress the SQLException
	 */
	public boolean isUpdateEmployeeDetails(int employeeId, String firstName, 
			String secondName, String designation, String salary, 
			String emailId, String dateOfBirth, String phoneNumber, String streetAddress,
			String state, String city, String postalCode,	
			String currentStreetAddress, String currentState, String currentCity,
			String currentPostalCode) throws SQLException;

	/**
	 * To view the employee details by providing id
	 * 
	 * @param employeeId              view a employee details list by providing id              
	 * @return EmployeeDetails        returns the employee details for an id 
	 * @throws SQLException 
	 */
	public ArrayList<LinkedHashMap<String,Object>> viewEmployeeDetails(int employeeId)
			throws SQLException;

	/**
	 * To assign project to employee
	 * 
	 * @param employeeId        employeeId 
	 * @param employeeProjects  projects for employeeId
	 * @return                  boolean
	 * @throws SQLException     to suppress SQLException
	 */
	public boolean isProjectAssign(int employeeId, List<Integer> employeeProjects)
			throws SQLException;

	/**
	 * This method removes the project for employeeId
	 * 
	 * @param employeeId        employeeId 
	 * @param removeProject     project to remove
	 * @return                  boolean
	 * @throws SQLException     to suppress SQLException
	 */
	/*public boolean isProjectRemove(int employeeId, List<Integer> employeeProjects) 
			throws SQLException;*/
	
	/**
	 * Interface to get employees in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 * @throws SQLException  to suppress SQLException
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId)
			throws SQLException;*/
	
	/**
	 * To get the projectIds List
	 * @return              projectId lists
	 * @throws SQLException to suppress SQLException
	 */
	public List<LinkedHashMap<Integer, Integer>> availableProjects() 
			throws SQLException;
}
