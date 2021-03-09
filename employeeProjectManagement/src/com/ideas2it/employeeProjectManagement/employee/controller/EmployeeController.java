/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.employee.service.impl.EmployeeServiceImpl;

/**
 * EmployeeController is an interface between EmployeeView and Employee Service
 *
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class EmployeeController extends HttpServlet{

    private static final long serialVersionUID = 1L;
    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                System.out.println("aaaaaaaa");
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
            //case "edit":
            //editEmployee(request, response);
            //break;
            default:
                insertEmployee(request, response);
                break;
        }}

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("asas");
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
        employeeService.createEmployeeDetails(firstName, secondName, designation, salary,
                emailId, dateOfBirth, phoneNumber, streetAddress,  state, city,
                postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
        response.sendRedirect("addEmployee.jsp");
    }

    private void employeeDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

       // employeeService.employeeDelete(employeeId);
        response.sendRedirect("addEmployee.jsp");
    }

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

        //employeeService.createEmployeeDetails(firstName, secondName, designation, salary,
                //emailId, dateOfBirth, phoneNumber, streetAddress,  state, city,
                //postalCode, currentStreetAddress, currentState, currentCity, currentPostalCode);
        response.sendRedirect("addEmployee.jsp");
    }

    private void employeeList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    //    List<Map<String, Object>> employeeList = employeeService.viewEmployeeList();
      //request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
        dispatcher.forward(request, response);
    }}

	/*private void editEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

