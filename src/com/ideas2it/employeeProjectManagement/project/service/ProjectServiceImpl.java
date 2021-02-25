/**
 * Project service which handles the business logics for project management
 */
package com.ideas2it.employeeProjectManagement.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ideas2it.employeeProjectManagement.project.dao.ProjectDAO;
import com.ideas2it.employeeProjectManagement.project.dao.ProjectDAOImpl;
import com.ideas2it.employeeProjectManagement.project.model.Project;

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
	 * 
	 * @return projectDetailsList  the list of projects
	 * @throws SQLException 
	 */
	@Override
	public List<LinkedHashMap<String, Object>> viewProjectList() throws SQLException {
		List<LinkedHashMap<String, Object>> projectDetailsList = new ArrayList<LinkedHashMap<String, Object>>();
		List<Project> projectList = projectDAO.viewProjectList();
		for (Project project : projectList) {
			LinkedHashMap<String, Object> projectData= new LinkedHashMap<String, Object>();
			projectData.put("projectId", project.getProjectId());
			projectData.put("projectName", project.getProjectName());
			projectData.put("projectDueDate", project.getProjectDueDate());
			projectData.put("projectManager", project.getProjectManager());	
			projectDetailsList.add(projectData);
		}
		return projectDetailsList;		
	}

	/**
	 * To get the project ids from the Project Details List
	 * 
	 * @return projectDetailsList  the list of projectIds
	 */
	@Override
	public List<Set<Integer>> availableProjects() throws SQLException {
		List<Set<Integer>> projectsList = new ArrayList<Set<Integer>>();
		List<Project> projectList = projectDAO.viewProjectList();
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
	 * @param projectName     Project name
	 * @param projectDueDate  How long to complete project
	 * @param projectManager  manager of a project
	 * @throws SQLException   to suppress SQLException
	 */
	@Override
	public int createProjectDetails(String projectName, String dueDate, String manager) throws SQLException {
		Project project = new Project(projectName, dueDate, manager);
		int projectId = projectDAO.createProjectDetails(project);
		return projectId;
	}

	/**
	 * boolean operation to check id exist or not
	 * 
	 * @param id     to check id exist or not
	 * @return true  id already exists
	 * @return false add id
	 */
	/*public boolean isProjectIdExist(int id) {
		if (null != projectList && !projectList.isEmpty()) {
			for (Project project : projectList) {
				if (id.equals(project.getProjectId())) {
					return true;
				} else {
					return false;
				}
			}
		} 
		return false;
	}*/

	/**
	 * To delete project details by id.
	 * 
	 * @param  projectId    to remove the details by id 
	 * @return true         project id deleted.
	 * @return false        project id not exists.
	 * @throws SQLException to suppress SQLException
	 */
	@Override
	public boolean projectDelete(int projectId) throws SQLException {
		return projectDAO.projectDelete(projectId);
	}

	/**
	 * To get the project details by providing id
	 * 
	 * @param id       enter id get project details 
	 * @return project if project id present return project details
	 * @return null    if project id not present returns null.
	 */
	/*public Project getProjectById(String id) {
		for (Project project : projectList) {
			if (project.getProjectId().equals(id)) {
				return project;
			}
		} 
		return null;
	}*/

	/**
	 * Project Details Update metod to change the project details
	 *
	 * @param projectId       project Id 
	 * @param projectName     Project name
	 * @param projectDueDate  How long to complete project
	 * @param projectManager  manager of a project
	 * @return                boolean 
	 * @throws SQLException   to suppress SQLException
	 * 
	 */
	@Override
	public boolean isUpdateProjectDetails(int projectId, String projectName,
			String projectDueDate, String projectManager) throws SQLException {
		Project project = new Project();
		project.setProjectId(projectId);
		project.setProjectDueDate(projectDueDate);
		project.setProjectName(projectName);
		project.setProjectManager(projectManager);
		return projectDAO.isUpdateProjectDetails(project);
	}

	/**
	 * To get the project details providing id
	 * 
	 * @param projectId      enter id to view project details 
	 * @return               projectDetailsList
	 * @throws SQLException  to suppress SQLExceptions
	 */
	@Override
	public Map<String, Object> viewProjectDetails(int projectId) throws SQLException {
		Project project= projectDAO.viewProjectDetails(projectId);
		Map<String, Object> projectDetails = new LinkedHashMap<String, Object>();
		projectDetails.put("ProjectId", project.getProjectId());
		projectDetails.put("ProjectName", project.getProjectName());
		projectDetails.put("ProjectDueDate", project.getProjectDueDate());
		projectDetails.put("ProjectManager", project.getProjectManager());		
		return projectDetails;
	}

	/**
	 * To get the projectIds List
	 * 
	 * @return              projectId lists
	 * @throws SQLException to suppress SQLException
	 */
	/*public List<Map<Integer, Integer>> showAvailableProjectId() throws SQLException {
		List<Map<Integer, Integer>> availableProjectId = new ArrayList<Map<Integer, Integer>>();
		List<Project> projectIdList = projectDAO.showAvailableProjectId();
		for (Project project : projectIdList) {
			Map<Integer, Integer> projectIds = new LinkedHashMap<Integer, Integer>();
			int index = 0;
			projectIds.put(project.getProjectId(), index);
			availableProjectId.add(projectIds);		
			index++;
		}
		return availableProjectId;
	}*/
    
	/**
	 * To get projects assign for employee
	 *  
	 * @param employeeProjects  list of project ids
	 * @return                  employees 
	 * @throws SQLException     to suppress SQLException
	 */

	public List<Project> employeeProjectDetails(List<Integer> employeeProjects) throws SQLException {
		List<Project> employeeProjectList = new ArrayList<Project>();
		for (int projectId : employeeProjects) {
			 employeeProjectList.add(projectDAO.employeeProjectDetails(projectId));
		}		
		return employeeProjectList;
	}
	
	/**
	 * Interface to get employees in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 * @throws SQLException  to suppress SQLException
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId) throws SQLException {
		return employeeService.viewEmployeesInProject(projectId);
	}*/

	/**
	 * To update Project Name
	 * 
	 * @param id              enter project id to update project name
	 * @param newProjectName  enter the new project name   
	 * @return 			      boolean
	 */
	/*public boolean isProjectNameUpdate(String id, String newProjectName) {
		Project project = getProjectById(id);
		if (null != project) {
			project.setProjectName(newProjectName);
			return true;
		} else {
			return false;
		}
	}*/

	/**
	 * To update Work Period of a Project.
	 * 
	 * @param id          enter the id to update due date 
	 * @param newDueDate  enter the duedate to update
	 * @return 			  boolean
	 */
	/*public boolean isProjectDueUpdate(String id, String newDueDate) {
		Project project = getProjectById(id);
		if (null != project) {
			project.setDueDate(newDueDate);
			return true;
		} else {
			return false;
		}
	}*/

	/**
	 * To update Manager of a project.
	 * 
	 * @param id          update manager of an project for this id
	 * @param newManager  enter the manager name to update
	 * @return            boolean
	 */
	/*public boolean isManagerUpdate(String id, String newManager) {
		Project project = getProjectById(id);
		if (null != project) {
			project.setProjectManager(newManager);
			return true;
		} else {
			return false;
		}
	}*/
}
