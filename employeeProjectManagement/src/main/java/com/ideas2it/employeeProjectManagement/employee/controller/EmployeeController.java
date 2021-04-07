/**
 * Employee controller package to control the employee view and employee service.
 */
package com.ideas2it.employeeProjectManagement.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employeeProjectManagement.address.model.Address;
import com.ideas2it.employeeProjectManagement.employee.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.employee.service.EmployeeService;
import com.ideas2it.employeeProjectManagement.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import com.ideas2it.employeeProjectManagement.util.constants.Constants;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;
import com.ideas2it.employeeProjectManagement.util.logger.EmployeeProjectManagementLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    EmployeeProjectManagementLogger employeeProjectManagementLogger = new EmployeeProjectManagementLogger(EmployeeDAOImpl.class.getName());

    /**
     * To send employee details to service this method is used to insert in datab
     *
     * @param employee
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "insertEmployee", method = RequestMethod.POST)
    private ModelAndView insertEmployee(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int employeeId = employeeService.createEmployeeDetails(employee);
            modelAndView.setViewName("success.jsp");
            modelAndView.addObject("employeeId", employeeId);
            employeeProjectManagementLogger.info("New Employee Added" + String.valueOf(employeeId) );
            return modelAndView;
        } catch (EmployeeProjectManagementException exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ADD_EMPLOYEE);
        }
        return modelAndView;
    }

    /**
     * To delete the employee details from the database this is used
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/employeeDelete")
    private String employeeDelete(HttpServletRequest request, HttpServletResponse response) {
       try {
           int employeeId = Integer.parseInt(request.getParameter("employeeId"));
           employeeService.employeeDelete(employeeId);
           employeeProjectManagementLogger.info("Employee Deleted" + String.valueOf(employeeId));
           return "redirect:employeeList";
       } catch (EmployeeProjectManagementException exception) {
           employeeProjectManagementLogger.error(Constants.EXCEPTION_DELETE_EMPLOYEE);
       }
        return "redirect:employeeList";
    }

    /**
     * The employee details obtained are updated in the database table
     * by thhis method
     * <p>
     * * @throws IOException
     */
    @RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
    private String employeeUpdate(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.updateEmployeeDetails(employee);
            employeeProjectManagementLogger.info("employee updated" + String.valueOf(employee.getEmployeeId()));
            return "redirect:employeeList";
        } catch (EmployeeProjectManagementException exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_UPDATE_EMPLOYEE);
        }
        return "redirect:employeeList";
    }

    /**
     * To get the employee model and send it to create employee
     * details
     *
     * @throws IOException
     */
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    private ModelAndView getEmployee(ModelAndView model) {
        try {
            Employee employee = new Employee();
            List<Address> addresses = new ArrayList<Address>();
            addresses.add(new Address());
            addresses.add(new Address());
            employee.setAddresses(addresses);
            List<Project> projects = new ArrayList<>();
            projects.add(new Project());
            employee.setProjects(projects);
            model.addObject("employee", employee);
            model.setViewName("addEmployee.jsp");
            return model;
        } catch (Exception exception){
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWDETAIL_EMPLOYEE);
        }
        return model;
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
    private ModelAndView employeeList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Employee> employeeList = employeeService.getEmployeeList();
            modelAndView.setViewName("employeeList.jsp");
            modelAndView.addObject("employeeList", employeeList);
            return modelAndView;
        } catch(EmployeeProjectManagementException exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWLIST_EMPLOYEE);
        }
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
    private ModelAndView employeeEdit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeService.getEmployeeDetails(employeeId);
            modelAndView.setViewName("updateEmployee.jsp");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } catch(EmployeeProjectManagementException  exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_UPDATE_EMPLOYEE);
        }
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
    private String assignProject(HttpServletRequest request, HttpServletResponse response) {
        try {
            String[] projects = request.getParameterValues("project");
            if (projects == null) {
                projects = new String[0];
            }
            List<String> employeeProjects = Arrays.asList(projects);
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            employeeService.assignProject(employeeId, employeeProjects);
            employeeProjectManagementLogger.info("Project assigned");
            return ("redirect:employeeList");
        } catch(EmployeeProjectManagementException exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ADD_PROJECT);
        }
        return ("redirect:employeeList");
    }

    /**
     * To send the List of projects and employee detail of employeeId to
     * process the assign projects
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/employeeProject", method = RequestMethod.GET)
    private ModelAndView employeeProject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            List<Project> projectList = employeeService.availableProjects();
            Employee employee = employeeService.getEmployeeDetails(employeeId);
            modelAndView.setViewName("assignEmployeeInProject.jsp");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("projectList", projectList);
            return modelAndView;
        } catch(EmployeeProjectManagementException  exception) {
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ADD_PROJECT);
        }
        return modelAndView;
    }
}