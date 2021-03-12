/**
 * Employee Service Interface to hide the definition of the method
 */
package com.ideas2it.employeeProjectManagement.employee.service;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.project.model.Project;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Admin
 *
 */
public interface EmployeeService {

    /**
     * To view all Employee details list
     *
     * @return employeeList  the Employee details list
     */
    public List<Employee> viewEmployeeList();

    /**
     * Add the employee details and address details
     * checking the employee id is already present or not
     *
     * @param firstName 	         employee first name
     * @param secondName	         employee second name
     * @param designation 	         designation of employee
     * @param salary	             of employee
     * @param emailId	             email of an employee
     * @param dateOfBirth	                 age of an employee
     * @param phoneNumber 	         phone number of an employee
     * @param  streetAddress         permanent street address of an employee
     * @param  state                 Permanent state
     * @param  city                  permanent city
     * @param  postalCode            permanent postalCode
     * @param  currentStreetAddress	 current street address
     * @param  currentState          current state
     * @param  currentCity           current city
     * @param  currentPostalCode     current postal code
     */
    public int createEmployeeDetails(String firstName, String secondName,
                                     String designation, String 	salary, String emailId,
                                     String dateOfBirth, String phoneNumber, String streetAddress,
                                     String state, String city, String postalCode, String currentStreetAddress,
                                     String currentState, String currentCity, String currentPostalCode);

    /**
     * To delete employee details by id.
     *
     * @param  employeeId    to delete the details by employeeId
     * @return               boolean
     */
    public boolean employeeDelete(int employeeId);

    /**
     * To update employee Details and the boolean is returned
     *
     * @param employeeId             employeeId to update details
     * @param firstName 	         employee first name
     * @param secondName	         employee second name
     * @param designation 	         designation of employee
     * @param salary	             of employee
     * @param emailId	             email of an employee
     * @param dateOfBirth	                 age of an employee
     * @param phoneNumber 	         phone number of an employee
     * @param  streetAddress         permanent street address of an employee
     * @param  state                 Permanent state
     * @param  city                  permanent city
     * @param  postalCode            permanent postalCode
     * @param  currentStreetAddress	 current street address
     * @param  currentState          current state
     * @param  currentCity           current city
     * @param  currentPostalCode     current postal code
     */
    public boolean updateEmployeeDetails(int employeeId, String firstName,
                                           String secondName, String designation, String salary,
                                           String emailId, String dateOfBirth, String phoneNumber, String streetAddress,
                                           String state, String city, String postalCode,
                                           String currentStreetAddress, String currentState, String currentCity,
                                           String currentPostalCode);

    /**
     * To view the employee details by providing id
     *
     * @param employeeId              view a employee details list by providing id
     * @return EmployeeDetails        returns the employee details for an id
     */
    public Employee viewEmployeeDetails(int employeeId);

    /**
     * To assign project to employee
     *
     * @param employeeId        employeeId
     * @param employeeProjects  projects for employeeId
     * @return                  boolean
     */
    public boolean projectAssign(int employeeId, List<String> employeeProjects);

    /**
     * To get the projectIds List
     * @return              projectId lists
     */
    public List<Project> availableProjects();

    /**
     * Interface to Delete project for an employee
     *
     * @param employeeId     to remove project for employeeId
     * @param projectId  to remove the project
     * @return               boolean
     */
    public boolean unAssignProject(int employeeId, int projectId);
}
