/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            case "projectAssign":
                assignProject(request, response);
                break;
            case "projectAssignments":
                employeeProject(request, response);
                break;
            default:
                insertEmployee(request, response);
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
        String secondName = request.getParameter("lastName");
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
        request.setAttribute("employeeId", employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
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
            throws IOException, ServletException {
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
        List<Employee> employeeList = employeeService.getEmployeeList();
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
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    /**
     * To assign the projects for an employee
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void assignProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] projects = request.getParameterValues("project");
        List employeeProjects = Arrays.asList(projects);
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeService.assignProject(employeeId, employeeProjects);
        response.sendRedirect("EmployeeController?action=list");
    }

    /**
     * To send the List of projects and employee detail of employeeId to
     * process the assign projects
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void employeeProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Project> projectList = employeeService.availableProjects();
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        request.setAttribute("employee", employee);
        request.setAttribute("projectList", projectList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("assignEmployeeInProject.jsp");
        dispatcher.forward(request, response);
    }
}