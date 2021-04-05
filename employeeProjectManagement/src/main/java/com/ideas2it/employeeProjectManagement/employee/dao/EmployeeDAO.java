/**
 * DAO package which contains this EmployeeDAO interface
 */
package com.ideas2it.employeeProjectManagement.employee.dao;

import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;

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
     */
    int createEmployeeDetails(Employee employee) throws EmployeeProjectManagementException;

    /**
     *  Interface to check Employee Deleted
     *
     * @param employeeId     to delete employee id details
     * @return               boolean
     */
    boolean deleteEmployee(int employeeId) throws EmployeeProjectManagementException;

    /**
     * Interface to View Employee Details
     *
     * @param employeeId     employeeId to view details
     * @return				 boolean
     */
    Employee getEmployeeDetails(int employeeId) throws EmployeeProjectManagementException;

    /**
     * Interface to View all employee Details
     *
     * @return               employee List
     */
    List<Employee> getEmployeeList() throws EmployeeProjectManagementException;

    /**
     * Interface to check is employee Details updated
     *
     * @param employee	     employee details to update
     * @return				 boolean
     */
    boolean isUpdateEmployeeDetails(Employee employee) throws EmployeeProjectManagementException;

    /**
     * Interface to assign projects to employee
     *
     * @param employee        to assign project for employee Id
     * @return					boolean
     */
    boolean projectAssign(Employee employee) throws EmployeeProjectManagementException;
}
