/**
 * Project controller package to control the project view and project service.
 */
package com.ideas2it.employeeProjectManagement.project.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.employeeProjectManagement.project.service.ProjectService;
import com.ideas2it.employeeProjectManagement.project.service.impl.ProjectServiceImpl;

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
     * To add Project details to an array List All parameters are passed in the
     * method.
     *
     * @param   id      project id
     * @param   name    Project name
     * @param   period  How long to complete project
     * @param   manager manager of a project
     */
    public int createProjectDetails(String projectName,
                                    String projectDueDate, String projectManager) {
        int projectId = projectService.createProjectDetails(projectName,
                projectDueDate, projectManager);
        return projectId;
    }

    /**
     * To update project details
     *
     * @param projectId       project Id
     * @param projectName     Project name
     * @param projectDueDate  How long to complete project
     * @param projectManager  manager of a project
     * @return                boolean
     */
    public boolean isUpdateProjectDetails(int projectId, String projectName,
                                          String projectDueDate, String projectManager) {
        return projectService.isUpdateProjectDetails(projectId,
                projectName, projectDueDate, projectManager);
    }

    /**
     * To view List of all Project Details.
     *
     * @return 	 projectList project details List
     */
    public List<LinkedHashMap<String, Object>> viewProjectList() {
        return projectService.viewProjectList();
    }

    /**
     * To delete project details
     *
     * @param id  enter the project id o delete details
     * @return    boolean
     */
    public boolean deleteProject(int projectId) {
        return projectService.deleteProject(projectId);
    }

    /**
     * To  View Project Details by Id
     *
     * @param id id to view the project details
     * @return   project project details for id
     */
    public Map<String, Object> viewProjectDetails(int projectId) {
        return projectService.viewProjectDetails(projectId);
    }
}
