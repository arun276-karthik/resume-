/**
 * Project service which handles the business logics for project management
 */
package com.ideas2it.employeeProjectManagement.project.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ideas2it.employeeProjectManagement.project.dao.ProjectDAO;
import com.ideas2it.employeeProjectManagement.project.dao.impl.ProjectDAOImpl;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;

/**
 * ProjectService is an Service class which performs logics and store values in
 * HashMap and send it to view class
 *
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class ProjectServiceImpl implements ProjectService{

    ProjectDAO projectDAO = new ProjectDAOImpl();
    //EmployeeServiceInterface employeeService = new EmployeeService();

    /**
     * To view project details List available
     *
     * @return projectDetailsList  the list of projects
     */
    public List<Project> getProjectList() throws EmployeeProjectManagementException {
        List<Project> projectList = projectDAO.getProjectList();
        return projectList;
    }

    /**
     * To get the project ids from the Project Details List
     *
     * @return projectDetailsList  the list of projectIds
     */
    public List<Set<Integer>> availableProjects() throws EmployeeProjectManagementException {
        List<Set<Integer>> projectsList = new ArrayList<Set<Integer>>();
        List<Project> projectList = projectDAO.getProjectList();
        for (Project project : projectList) {
            Set<Integer> projectId = new LinkedHashSet<Integer>();
            projectId.add(project.getProjectId());
            projectsList.add(projectId);
        }
        return projectsList;
    }


    /**
     * Add the Project details checking the Project id is already present or not
     *
     * @return projectId      preoject id for this project
     */
    public int createProjectDetails(Project project) throws EmployeeProjectManagementException {
        int projectId = projectDAO.createProjectDetails(project);
        return projectId;
    }

    /**
     * To delete project details by id.
     *
     * @param  projectId    to remove the details by id
     * @return true         project id
     */
    public boolean deleteProject(int projectId) throws EmployeeProjectManagementException {
        return projectDAO.deleteProject(projectId);
    }

    /**
     * Project Details Update metod to change the project details
     *
     * @return                boolean
     */
    public boolean updateProjectDetails(Project project) throws EmployeeProjectManagementException {
        return projectDAO.isUpdateProjectDetails(project);
    }

    /**
     * To get the project details providing id
     *
     * @param projectId      enter id to view project details
     * @return               projectDetailsList
     */
    public Project getProjectDetails(int projectId) throws EmployeeProjectManagementException {
        Project project= projectDAO.getProjectDetails(projectId);
//        Map<String, Object> projectDetails = new LinkedHashMap<String, Object>();
//        projectDetails.put("ProjectId", project.getProjectId());
//        projectDetails.put("ProjectName", project.getProjectName());
//        projectDetails.put("ProjectDueDate", project.getProjectDueDate());
//        projectDetails.put("ProjectManager", project.getProjectManager());
//        return projectDetails;
        return project;
    }

    /**
     * To get projects assign for employee
     *
     * @param employeeProjects  list of project ids
     * @return                  employees
     */
    public List<Project> employeeProjectDetails(List<Integer> employeeProjects) throws EmployeeProjectManagementException {
        List<Project> employeeProjectList = new ArrayList<Project>();
        for (int projectId : employeeProjects) {
            employeeProjectList.add(projectDAO.employeeProjectDetails(projectId));
        }
        return employeeProjectList;
    }
}
