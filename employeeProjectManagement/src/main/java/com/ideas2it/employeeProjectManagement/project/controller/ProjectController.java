/**
 * Project controller package to control the project view and project service.
 */
package com.ideas2it.employeeProjectManagement.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.employeeProjectManagement.address.model.Address;
import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;
import com.ideas2it.employeeProjectManagement.project.service.impl.ProjectServiceImpl;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ProjectController is an interface between ProjectView and Project Service
 *
 * @author A.K
 * @version 1.0
 * @since 22-01-2021
 */
@Controller
public class ProjectController extends HttpServlet {

    ProjectService projectService = new ProjectServiceImpl();

    /**
     * To insert the project details to the database by the project service
     *
     * @param project
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "insertProject", method = RequestMethod.POST)
    private ModelAndView insertProject(@ModelAttribute("project") Project project)
            throws IOException, ServletException, EmployeeProjectManagementException {
        ModelAndView modelAndView = new ModelAndView();
        int projectId = projectService.createProjectDetails(project);
        modelAndView.setViewName("success.jsp");
        modelAndView.addObject("projectId", projectId);
        return modelAndView;
    }

    /**
     * To delete the project details from the database this is used
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/projectDelete", method = RequestMethod.GET)
    private String projectDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeProjectManagementException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        projectService.deleteProject(projectId);
        return "redirect:projectList";
    }

    /**
     * To get the project object send it for modelAttribute
     *
     * @param model
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/getProject", method = RequestMethod.GET)
    private ModelAndView getEmployee(ModelAndView model)
            throws IOException, ServletException {
        Project project = new Project();
        model.addObject("project", project);
        model.setViewName("addProject.jsp");
        return model;
    }


    /**
     * The project details obtained are updated in the database table
     * by this method
     *
     * @param project
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/projectUpdate", method = RequestMethod.POST)
    private String projectUpdate(@ModelAttribute("project") Project project)
            throws IOException, EmployeeProjectManagementException {
        projectService.updateProjectDetails(project);
        return "redirect:projectList";
    }

    /**
     * The project details List are fetched from the database table
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    private ModelAndView projectList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, EmployeeProjectManagementException {
        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectService.getProjectList();
        modelAndView.setViewName("projectList.jsp");
        modelAndView.addObject("projectList", projectList);
        return modelAndView;
    }

    /**
     * Project Edit which forwards  the request to the update method
     * and details are updated
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/projectEdit")
    private ModelAndView projectEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeProjectManagementException {
        ModelAndView modelAndView =  new ModelAndView();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        Project project = projectService.getProjectDetails(projectId);
        modelAndView.setViewName("updateProject.jsp");
        modelAndView.addObject("project", project);
        return modelAndView;
    }
}