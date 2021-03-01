/**
 * Project service which handles the business logics for project management
 */
package com.ideas2it.employeeProjectManagement.project.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ideas2it.employeeProjectManagement.project.model.Project;

/**
 * project service Interface is an interface for project service
 * 
 * @author   AK
 * @since    16-02-2021
 * @version  1.0
 */
public interface ProjectService {
	
	/**
	 * To view Project List
	 * 
	 * @return projectDetailsList  the list of projects
	 */
	public List<LinkedHashMap<String, Object>> viewProjectList();

	/**
	 * Add the Project details checking the Project id is already present or not
	 * 
	 * @param projectName     Project name
	 * @param projectDueDate  How long to complete project
	 * @param projectManager  manager of a project
	 */
	public int createProjectDetails(String projectName, String dueDate, String manager);
	
	/**
	 * To delete project details by id.
	 * 
	 * @param  projectId    to remove the details by id 
	 * @return true         project id deleted.
	 * @return false        project id not exists.
	 */
	public boolean deleteProject(int projectId);
	
	/**
	 * Project Details Update metod to change the project details
	 *
	 * @param projectId       project Id 
	 * @param projectName     Project name
	 * @param projectDueDate  How long to complete project
	 * @param projectManager  manager of a project
	 * @return                boolean 
	 * 
	 */
	public boolean isUpdateProjectDetails(int projectId, String projectName,
			String projectDueDate, String projectManager);
	
	/**
	 * To get the project details providing id
	 * 
	 * @param projectId      enter id to view project details 
	 * @return               projectDetailsList
	 */
	public Map<String, Object> viewProjectDetails(int projectId);
	
	/**
	 * To get the projectIds List
	 * 
	 * @return              projectId lists
	 */
	public List<Set<Integer>> availableProjects();
	
	/**
	 * Interface to get employees working in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId) 
			throws SQLException;*/
	
	/**
	 * Interface to get projects assign for employee
	 *  
	 * @param employeeProjects  list of project ids
	 * @return                  employees 
	 */
	public List<Project> employeeProjectDetails(List<Integer> employeeProjects);
}
