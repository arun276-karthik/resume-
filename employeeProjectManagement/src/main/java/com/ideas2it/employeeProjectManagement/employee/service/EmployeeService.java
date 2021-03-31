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
    List<Employee> getEmployeeList();

    /**
     * Add the employee details and address details
     * checking the employee id is already present or not
     */
    int createEmployeeDetails(Employee employee);

    /**
     * To delete employee details by id.
     *
     * @param  employeeId    to delete the details by employeeId
     * @return               boolean
     */
    boolean employeeDelete(int employeeId);

    /**
     * To update employee Details and the boolean is returned
     */
    boolean updateEmployeeDetails(Employee employee);

    /**
     * To view the employee details by providing id
     *
     * @param employeeId              view a employee details list by providing id
     * @return EmployeeDetails        returns the employee details for an id
     */
    Employee getEmployeeDetails(int employeeId);

    /**
     * To assign project to employee
     *
     * @param employeeId        employeeId
     * @param employeeProjects  projects for employeeId
     * @return                  boolean
     */
    boolean assignProject(int employeeId, List<String> employeeProjects);

    /**
     * To get the projectIds List
     * @return              projectId lists
     */
    List<Project> availableProjects();
}
