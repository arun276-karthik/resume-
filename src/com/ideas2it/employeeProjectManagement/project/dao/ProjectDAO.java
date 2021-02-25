/**
 * DAO package which has this projectDAO interface. 
 */
package com.ideas2it.employeeProjectManagement.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeeProjectManagement.project.model.Project;

/**
 * ProjectDAO is an interface used to implement class ProjectDAOimpl which 
 * performs the connectivity of business logic to the low level process ofdatabase connection
 * 
 * @author   AK
 * @since    14-02-2021
 * @version  1.0
 */
public interface ProjectDAO {

	/**
	 * Interface to create Project details 
	 * 
	 * @param project        the details to create projectDetails
	 * @return               project Id
	 * @throws SQLException  to suppress SQlException.
	 */
	public int createProjectDetails(Project project) 
			throws SQLException; 
	
	/**
	 * Interface to Delete project Details for projectId
	 * 
	 * @param projectId      ProjectId to delete the details
	 * @return               boolean
	 * @throws SQLException  to suppress SQLException
	 */
	public boolean projectDelete(int projectId) 
			throws SQLException; 
	
	/**
	 * Interface to view Project details by projectId
	 * 
	 * @param projectId      projectId to get the details
	 * @return				 project details
	 * @throws SQLException  to suppress SQLException
	 */
	public Project viewProjectDetails(int projectId) 
			throws SQLException; 
	
	/**
	 * Interface to view List of all projects
	 * 
	 * @return               Projects List
	 * @throws SQLException  to suppress SQLException 
	 */
	public List<Project> viewProjectList() 
			throws SQLException; 
	
	/**
	 * To check the project is updated or not
	 * 
	 * @param project        contains the project details to update 
	 * @return			     boolean
	 * @throws SQLException  to suppress SQLException
	 */
	public boolean isUpdateProjectDetails(Project project) 
			throws SQLException; 
	
	/**
	 * To show the available project to user
	 * 
	 * @return			     List of projects available
	 * @throws SQLException  to suppress SQLException
	 */
	/*public List<Project> showAvailableProjectId() 
			throws SQLException;*/
	
	/**
	 * To assign project to user
	 * 
	 * @return			     List of projects available
	 * @throws SQLException  to suppress SQLException
	 */
	public Project employeeProjectDetails(int employeeProjects) 
			throws SQLException;

	/**
	 * view project Detail which get the data from resource and sets to Project
	 * model for an project Id
	 * 
	 * @param projectId     the details of this project id is displayed
	 * @return               project details for an id
	 * @throws SQLException  to suppress the sql exception
	 */

}
