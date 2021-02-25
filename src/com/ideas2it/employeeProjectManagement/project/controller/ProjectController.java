/**
 * Project controller package to control the project view and project service.
 */
package com.ideas2it.employeeProjectManagement.project.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.employeeProjectManagement.project.service.ProjectServiceImpl;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;

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
	 * @throws SQLException 
	 */
	public int createProjectDetails(String projectName, String projectDueDate, String projectManager) throws SQLException {		
		int projectId = projectService.createProjectDetails(projectName, projectDueDate, projectManager);
		return projectId;
	}

	/**
	 * To check the given Project ID is already exist.
	 * 
	 * @param id to check the project id already exists
	 * @return   returns the boolean value.
	 */
	/*public boolean isProjectIdExist(String id) {
		return projectService.isProjectIdExist(id);
	}*/

	/**
	 * To update project details 
	 *  
	 * @param projectId       project Id 
	 * @param projectName     Project name
	 * @param projectDueDate  How long to complete project
	 * @param projectManager  manager of a project
	 * @return                boolean 
	 * @throws SQLException   to suppress SQLException
	 */
	public boolean isUpdateProjectDetails(int projectId, String projectName,
			String projectDueDate, String projectManager) throws SQLException {
		return projectService.isUpdateProjectDetails(projectId, projectName, projectDueDate, projectManager);
	}

	/**
	 * To view List of all Project Details.
	 * 
	 * @return 	 projectList project details List
	 * @throws SQLException 
	 */
	public List<LinkedHashMap<String, Object>> viewProjectList() throws SQLException {
		return projectService.viewProjectList();
	}

	/**
	 * To delete project details
	 * 
	 * @param id  enter the project id o delete details
	 * @return    boolean
	 * @throws SQLException 
	 */
	public boolean projectDelete(int projectId) throws SQLException {
		return projectService.projectDelete(projectId);
	}

	/**
	 * To  View Project Details by Id
	 * 
	 * @param id id to view the project details
	 * @return   project project details for id
	 * @throws SQLException 
	 */
	public Map<String, Object> viewProjectDetails(int projectId) throws SQLException {
		return projectService.viewProjectDetails(projectId);
	}
	
	/**
	 * To get the projectIds List
	 * @return              projectId lists
	 * @throws SQLException to suppress SQLException
	 */
	/*public List<Map<Integer, Integer>> showAvailableProjectId() throws SQLException {
		return projectService.showAvailableProjectId();
	}*/
	
	/**
	 * To get employees in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 * @throws SQLException  to suppress SQLException
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId) throws SQLException {
		return projectService.viewEmployeesInProject(projectId);
	}*/
	
	/**
	 * Update Project name
	 * 
	 * @param id              enter project id to update project name
	 * @param newProjectName  enter the new project name  
	 * @return                boolean whether updated or not
	 */
	/*public boolean isProjectNameUpdate(String id, String newProjectName) {
		return projectService.isProjectNameUpdate(id, newProjectName);
	}*/

	/**
	 * Update Work DueDate for an Project.
	 * 
	 * @param id          enter the id to update due date 
	 * @param newDueDate  enter the duedate to update
	 * @return            boolean whether updated or not.
	 */
	/*public boolean isProjectDueUpdate(String id, String newDueDate) {
		return projectService.isProjectDueUpdate(id, newDueDate);
	}*/

	/**
	 * Update Manager of an Project.
	 * 
	 * @param id          update manager of an project for this id
	 * @param newManager  enter the manager name to update
	 * @return            boolean whether updated or not.
	 */
	/*public boolean isManagerUpdate(String id, String newManager) {
		return projectService.isManagerUpdate(id, newManager);
	}*/ 
}
