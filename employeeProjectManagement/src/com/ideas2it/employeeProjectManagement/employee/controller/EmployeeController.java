/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeProjectManagement.project.model.Project;

/**
 * EmployeeController is an interface between EmployeeView and Employee Service
 *
 * @author A.K
 * @version 1.0
 * @since 22-01-2021
 */
public class EmployeeController extends HttpServlet {

    EmployeeService employeeService = new EmployeeServiceImpl();

    /**
     * This method called by the server to allow a servlet to handle a POST request
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * This method called by the server to allow a servlet to handle a GET request
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                insertEmployee(request, response);
                break;
            case "delete":
                employeeDelete(request, response);
                break;
            case "update":
                employeeUpdate(request, response);
                break;
            case "list":
                employeeList(request, response);
                break;
            case "edit":
                employeeEdit(request, response);
                break;
            case "projectList":
                availableProjects(request, response);
                break;
            case "projectAssign":
                projectAssign(request, response);
                break;
            case "projectUnAssign":
                projectUnAssign(request, response);
                break;
            case "availableProjectList":
                availableProjectList(request, response);
                break;
            default:
                employeeList(request, response);
                break;
        }
    }

    /**
     * To send employee details to service this method is used to insert in database
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");
        String emailId = request.getParameter("emailId");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phoneNumber = request.getParameter("phoneNumber");

        String currentStreetAddress = request.getParameter("currentStreetAddress");
        String currentCity = request.getParameter("currentCity");
        String currentState = request.getParameter("currentState");
        String currentPostalCode = request.getParameter("currentPostalCode");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        int employeeId = employeeService.createEmployeeDetails(firstName, secondName, designation, salary,
                emailId, dateOfBirth, phoneNumber, streetAddress, state, city,
                postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
        response.sendRedirect("EmployeeController?action=list");
    }


    /**
     * To delete the employee details from the database this is used
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void employeeDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeService.employeeDelete(employeeId);
        response.sendRedirect("EmployeeController?action=list");
    }

    /**
     * The employee details obtained are updated in the database table
     * by thhis method
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void employeeUpdate(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");
        String emailId = request.getParameter("emailId");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phoneNumber = request.getParameter("phoneNumber");

        String currentStreetAddress = request.getParameter("currentStreetAddress");
        String currentCity = request.getParameter("currentCity");
        String currentState = request.getParameter("currentState");
        String currentPostalCode = request.getParameter("currentPostalCode");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");

        employeeService.updateEmployeeDetails(employeeId, firstName, secondName, designation, salary,
                emailId, dateOfBirth, phoneNumber, streetAddress, state, city,
                postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
        response.sendRedirect("EmployeeController?action=list");
    }

    /**
     * The employee details are fetched from the database table
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void employeeList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Employee> employeeList = employeeService.viewEmployeeList();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Employee Edit which forwards  the request to the update method
     * and details are updated
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void employeeEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeService.viewEmployeeDetails(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

//    private void availableProjects(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Project> projectList = employeeService.availableProjects();
//        request.setAttribute("projectList", projectList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("projectList.jsp");
//        dispatcher.forward(request, response);
//    }

    private void availableProjects(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Project> projectList = employeeService.availableProjects();
        System.out.println(employeeId);
        System.out.println(projectList);
        request.setAttribute("projectList", projectList);
        request.setAttribute("employeeId", employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("assignEmployeeInProject.jsp");
        dispatcher.forward(request, response);
    }

    private void projectAssign(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] projects = request.getParameterValues("projects");
        List employeeProjects = Arrays.asList(projects);
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeService.projectAssign(employeeId, employeeProjects);
        response.sendRedirect("EmployeeController?action=list");
        }

    private void availableProjectList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Project> projectList = employeeService.availableProjects();
        System.out.println(employeeId);
        System.out.println(projectList);
        request.setAttribute("projectList", projectList);
        request.setAttribute("employeeId", employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("unAssignEmployeeInProject.jsp");
        dispatcher.forward(request, response);
    }


    private void projectUnAssign(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        System.out.println(employeeId);
        System.out.println(projectId);
        employeeService.unAssignProject(employeeId, projectId);
        response.sendRedirect("EmployeeController?action=list");
    }
}

	/*private void editEmployee(HttpServletRequest request, HttpServletResponse response)
//throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Map<String, Object>> existingEmployee  = employeeService.viewEmployeeDetails(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployee.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response); 
    }*/


/**
 * To add Employee details to an array List All parameters are passed in the
 * method.
 *
 * @param employeeId           employee id
 * @param firstName           employee first name
 * @param secondName           employee second name
 * @param designation           designation of employee
 * @param salary               of employee
 * @param emailId               email of an employee
 * @param age                   age of an employee
 * @param phoneNumber           phone number of an employee
 * @param projectName           name of project allocated to employee
 * @param streetAddress        permanent street address of an employee
 * @param state                Permanent state
 * @param city                 permanent city
 * @param postalCode           permanent postalCode
 * @param currentStreetAddress current street address
 * @param currentState         current state
 * @param currentCity          current city
 * @param currentPostalCode    current postal code
 */
/*public int createEmployeeDetails(String firstName, String secondName,
		String designation, String salary,	String emailId, String dateOfBirth, String phoneNumber,
		String streetAddress, String state, String city,
		String postalCode,	String currentStreetAddress, String currentState,
		String currentCity, String currentPostalCode) {
	int employeeId = employeeService.createEmployeeDetails(firstName, secondName, designation, salary,
			emailId, dateOfBirth, phoneNumber, streetAddress,  state, city,
			postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
	return employeeId;
}

/**
 * To view List of all employee Details.
 *
 * @return  returns employee details List
 */
/*public List<Map<String, Object>> viewEmployeeList() {
	return employeeService.viewEmployeeList();
}

/**
 * To delete employee details by id
 *
 * @param employeeId  Delete details for this id
 * @return            boolean
 */
/*public boolean employeeDelete(int employeeId) {
	return employeeService.employeeDelete(employeeId);
}

/**
 * To view employee Details by Id
 *
 * @param employeeId   View details of employee by id
 * @return             returns employee details for id.
 */
/*public List<Map<String, Object>> viewEmployeeDetails(int employeeId) {
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
 * @return                     boolean
 */
/*public boolean isUpdateEmployeeDetails(int employeeId, String firstName,
		String secondName, String designation, String salary,
		String emailId, String dateOfBirth, String phoneNumber,
		String streetAddress, String state, String city,
		String postalCode,	String currentStreetAddress, String currentState,
		String currentCity, String currentPostalCode) {
	return employeeService.isUpdateEmployeeDetails(employeeId, firstName,
			secondName, designation, salary, emailId, dateOfBirth, phoneNumber,
			streetAddress, state, city, postalCode, currentStreetAddress,
			currentState, currentCity, currentPostalCode);
}

/**
 * To get the projectIds List
 * @return              projectId lists
 */
/*public List<Set<Integer>> availableProjects() {
	return employeeService.availableProjects();
}

/**
 * To assign project to employee
 *
 * @param employeeId        employeeId
 * @param employeeProjects  projects for employeeId
 * @return                  boolean
 */
/*public boolean projectAssign(int employeeId, List<Integer> employeeProjects) {
	return employeeService.projectAssign(employeeId, employeeProjects);
}
}*/

