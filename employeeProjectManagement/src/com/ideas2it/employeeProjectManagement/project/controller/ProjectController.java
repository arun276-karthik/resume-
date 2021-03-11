/**
 * Project controller package to control the project view and project service.
 */
package com.ideas2it.employeeProjectManagement.project.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;
import com.ideas2it.employeeProjectManagement.project.service.impl.ProjectServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ProjectController is an interface between ProjectView and Project Service
 *
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class ProjectController {

    ProjectService projectService = new ProjectServiceImpl();

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
                insertProject(request, response);
                break;
            case "delete":
                projectDelete(request, response);
                break;
            case "update":
                projectUpdate(request, response);
                break;
            case "list":
                projectList(request, response);
                break;
            case "edit":
                projectEdit(request, response);
                break;
            default:
                projectList(request, response);
                break;
        }
    }

    /**
     * To insert the project details to the database by the project service
     *
     *  @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void insertProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String projectName = request.getParameter("projectName");
        String projectDueDate = request.getParameter("projectDueDate");
        String projectManager = request.getParameter("projectManager");
        int projectId = projectService.createProjectDetails(projectName,
                projectDueDate, projectManager);
        response.sendRedirect("ProjectController?action=list");
    }

    /**
     * To delete the project details from the database this is used
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void employeeDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        projectService.deleteProject(projectId);
        response.sendRedirect("ProjectController?action=list");
    }

    /**
     * The project details obtained are updated in the database table
     * by this method
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void projectUpdate(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String projectName = request.getParameter("projectName");
        String projectDueDate = request.getParameter("projectDueDate");
        String projectManager = request.getParameter("projectManager");

        projectService.isUpdateProjectDetails(projectId,
                projectName, projectDueDate, projectManager);
        response.sendRedirect("ProjectController?action=list");
    }

    /**
     * The project details List are fetched from the database table
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void projectList(HttpServletRequest request, HttpServletResponse response)
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
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        Employee  = projectService.viewProjectDetails(projectId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }
}

/**
 * To add Project details to an array List All parameters are passed in the
 * method.
 *
 * @param   id      project id
 * @param   name    Project name
 * @param   period  How long to complete project
 * @param   manager manager of a project
 */
    /*public int createProjectDetails(String projectName,
                                    String projectDueDate, String projectManager) {
        int projectId = projectService.createProjectDetails(projectName,
                projectDueDate, projectManager);
        return projectId;
    }*/

    /**
     * To update project details
     *
     * @param projectId       project Id
     * @param projectName     Project name
     * @param projectDueDate  How long to complete project
     * @param projectManager  manager of a project
     * @return                boolean
     */
    /*public boolean isUpdateProjectDetails(int projectId, String projectName,
                                          String projectDueDate, String projectManager) {
        return projectService.isUpdateProjectDetails(projectId,
                projectName, projectDueDate, projectManager);
    }*/

    /**
     * To view List of all Project Details.
     *
     * @return 	 projectList project details List
     */
    /*public List<LinkedHashMap<String, Object>> viewProjectList() {
        return projectService.viewProjectList();
    }*/

    /**
     * To delete project details
     *
     * @param id  enter the project id o delete details
     * @return    boolean
     */
   /* public boolean deleteProject(int projectId) {
        return projectService.deleteProject(projectId);
    }*/

    /**
     * To  View Project Details by Id
     *
     * @param id id to view the project details
     * @return   project project details for id
     */
    /*public Map<String, Object> viewProjectDetails(int projectId) {
        return projectService.viewProjectDetails(projectId);
    }
}*/
