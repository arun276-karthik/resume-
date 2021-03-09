/**
 * DAO package which contains this EmployeeDAO interface
 */
package com.ideas2it.employeeProjectManagement.employee.dao;

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
     */
    public int createEmployeeDetails(Employee employee);

    /**
     *  Interface to check Employee Deleted
     *
     * @param employeeId     to delete employee id details
     * @return               boolean
     */
    public boolean deleteEmployee(int employeeId);

    /**
     * Interface to View Employee Details
     *
     * @param employeeId     employeeId to view details
     * @return				 boolean
     */
    public Employee viewEmployeeDetails(int employeeId);

    /**
     * Interface to View all employee Details
     *
     * @return               employee List
     */
    public List<Employee> viewEmployeeList();

    /**
     * Interface to check is employee Details updated
     *
     * @param employee	     employee details to update
     * @return				 boolean
     */
    public boolean isUpdateEmployeeDetails(Employee employee);

    /**
     * Interface to assign projects to employee
     *
     * @param employeeId        to assign project for employee ID
     * @param employeeProjects  to assign project
     * @return					boolean
     */
    public boolean projectAssign(Employee employee);

    /**
     * Interface to Delete project for an employee
     *
     * @param employeeId     to remove project for employeeId
     * @param removeProject  to remove the project
     * @return               boolean
     */
    public boolean isProjectRemove(Employee employee);
}
