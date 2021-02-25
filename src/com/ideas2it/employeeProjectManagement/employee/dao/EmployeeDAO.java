/**
 * DAO package which contains this EmployeeDAO interface
 */
package com.ideas2it.employeeProjectManagement.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.model.Employee; 

/**
 * EmployeeDAO interface which is used to attain the abstraction 
 * so only abstract methods are there in this not the method body
 * The methods are implemented in Employee DAO impl.
 * 
 * @author   AK
 * @SInce    11-02-2021
 * @version  1.0
 */
public interface EmployeeDAO { 	

	/**
	 * Create employee Details interface 
	 *  
	 * @param employee       to create employee details
	 * @return               employeeId
	 * @throws SQLException  to suppress SQLException
	 */
	public int createEmployeeDetails(Employee employee) 
			throws SQLException;

    /**
     *  Interface to check Employee Deleted 
     *  
     * @param employeeId     to delete employee id details
     * @return               boolean
     * @throws SQLException  to suppres SQLException
     */
	public boolean employeeDelete(int employeeId) 
			throws SQLException;

	/**
	 * Interface to View Employee Details 
	 *  
	 * @param employeeId     employeeId to view details
	 * @return				 boolean 
	 * @throws SQLException  to suppress SQLException
	 */
	public Employee viewEmployeeDetails(int employeeId) 
			throws SQLException;

	/**
	 * Interface to View all employee Details 
	 * 
	 * @return               employee List
	 * @throws SQLException  to suppress SQLException
	 */
	public List<Employee> viewEmployeeList() 
			throws SQLException; 

	/**
	 * Interface to check is employee Details updated
	 * 
	 * @param employee	     employee details to update
	 * @return				 boolean 
	 * @throws SQLException  to suppress SQLException
	 */
	public boolean isUpdateEmployeeDetails(Employee employee) 
			throws SQLException; 
	
	/**
	 * Interface to assign projects to employee
	 *  
	 * @param employeeId        to assign project for employee ID
	 * @param employeeProjects  to assign project 
	 * @return					boolean 
	 * @throws SQLException     to suppress SQLException
	 */
	public boolean isProjectAssign(Employee employee) 
			throws SQLException;	
	
	/**
	 * Interface to Delete project for an employee
	 * 
	 * @param employeeId     to remove project for employeeId
	 * @param removeProject  to remove the project
	 * @return               boolean
	 * @throws SQLException  to suppress SQLException
	 */
	public boolean isProjectRemove(Employee employee)
			throws SQLException;
	
	/**
	 * Interface to get employees in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 * @throws SQLException  to suppress SQLException
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId)
			throws SQLException;*/
} 
