/**
 * Employee service which handles the business logics for employee management
 */
package com.ideas2it.employeeProjectManagement.employee.service.impl;

import java.util.*;

import com.ideas2it.employeeProjectManagement.address.model.Address;
import com.ideas2it.employeeProjectManagement.employee.dao.EmployeeDAO;
import com.ideas2it.employeeProjectManagement.employee.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;
import com.ideas2it.employeeProjectManagement.project.service.impl.ProjectServiceImpl;

/**
 * EmployeeService is an Service class which performs logics and store values 
 * and send it to view class
 *
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    ProjectService projectService = new ProjectServiceImpl();


    /**
     * To view all Employee details list
     *
     * @return employeeList  the Employee details list
     */
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = employeeDAO.getEmployeeList();
        return employeeList;
    }

    /**
     * Add the employee details and address details
     * and getting the employee Id for the employee
     *
     * @param employee
     */
    public int createEmployeeDetails(Employee employee) {
        int employeeId = employeeDAO.createEmployeeDetails(employee);
		return employeeId;
    }

    /**
     * To delete employee details by id.
     *
     * @param  employeeId    to delete the details by employeeId
     * @return               boolean
     */
    public boolean employeeDelete(int employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }


    /**
     * To update employee Details and the boolean is returned
     *
     * @param employee
     */

    public boolean updateEmployeeDetails(Employee employee) {
        boolean isEmployeeUpdate = employeeDAO.isUpdateEmployeeDetails(employee);
        return true == isEmployeeUpdate;
    }

    /**
     * To view employee Details
     *
     * @param employeeId  to get the employee details of this id
     */
    public Employee getEmployeeDetails(int employeeId) {
        Employee employee = employeeDAO.getEmployeeDetails(employeeId);
        return employee;
    }

    /**
     * To assign project to employee
     *
     * @param employeeId        employeeId
     * @param employeeProjects  projects for employeeId
     * @return                  boolean
     */
    public boolean assignProject(int employeeId, List<String> employeeProjects) {
        Employee employee = employeeDAO.getEmployeeDetails(employeeId);
        List<Integer> projectsOfEmployee = new ArrayList<Integer>(employeeProjects.size());
        for(String projects : employeeProjects) {
            projectsOfEmployee.add(Integer.parseInt(projects));
        }
        List<Project> employeeProjectList  = projectService.employeeProjectDetails(projectsOfEmployee);
        employee.setProjects(employeeProjectList);
        return employeeDAO.projectAssign(employee);
    }

    /**
     * To get the projectIds List
     * @return              projectId lists
     */
    public List<Project> availableProjects() {
        return projectService.getProjectList();
    }
}