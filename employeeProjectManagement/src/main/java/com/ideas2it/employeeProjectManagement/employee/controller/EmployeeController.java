/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * EmployeeController is an interface between EmployeeView and Employee Service
 *
 * @author A.K
 * @version 1.0
 * @since 22-01-2021
 */
@Controller
public class EmployeeController extends HttpServlet {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        return "redirect:index.jsp";
    }

    /**
     * To send employee details to service this method is used to insert in database
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
    private ModelAndView insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ModelAndView modelAndView = new ModelAndView();
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
        modelAndView.setViewName("success.jsp");
        modelAndView.addObject("employeeId", employeeId);
        return modelAndView;
    }


    /**
     * To delete the employee details from the database this is used
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/employeeDelete", method = RequestMethod.GET)
    private String employeeDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeService.employeeDelete(employeeId);
        return "redirect:employeeList";
    }

    /**
     * The employee details obtained are updated in the database table
     * by thhis method
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
    private String employeeUpdate(HttpServletRequest request, HttpServletResponse response)
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
        return "redirect:employeeList";
    }

    /**
     * The employee details "are fetched from the database table
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    private ModelAndView employeeList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employeeList = employeeService.getEmployeeList();
        modelAndView.setViewName("employeeList.jsp");
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
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
    @RequestMapping("/employeeEdit")
    private ModelAndView employeeEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        modelAndView.setViewName("updateEmployee.jsp");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    /**
     * To assign the projects for an employee
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/assignProject", method = RequestMethod.POST)
    private String assignProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String[] projects = request.getParameterValues("project");
            List employeeProjects = Arrays.asList(projects);
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            employeeService.assignProject(employeeId, employeeProjects);
            return ("redirect:employeeList");
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
    @RequestMapping(value = "/employeeProject", method = RequestMethod.GET)
    private ModelAndView employeeProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ModelAndView modelAndView = new ModelAndView();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Project> projectList = employeeService.availableProjects();
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        modelAndView.setViewName("assignEmployeeInProject.jsp");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("projectList", projectList);
        return modelAndView;
    }
}