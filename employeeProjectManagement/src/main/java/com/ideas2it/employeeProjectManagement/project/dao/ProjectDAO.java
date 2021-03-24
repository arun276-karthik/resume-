/**
 * DAO package which has this projectDAO interface.
 */
package com.ideas2it.employeeProjectManagement.project.dao;

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
     */
    int createProjectDetails(Project project);

    /**
     * Interface to Delete project Details for projectId
     *
     * @param projectId      ProjectId to delete the details
     * @return               boolean
     */
    boolean deleteProject(int projectId);

    /**
     * Interface to view Project details by projectId
     *
     * @param projectId      projectId to get the details
     * @return				 project details
     */
    Project getProjectDetails(int projectId);

    /**
     * Interface to view List of all projects
     *
     * @return               Projects List
     */
    List<Project> getProjectList();

    /**
     * To check the project is updated or not
     *
     * @param project        contains the project details to update
     * @return			     boolean
     */
    boolean isUpdateProjectDetails(Project project);

    /**
     * To assign project to user
     *
     * @return			     List of projects available
     */
    Project employeeProjectDetails(int employeeProjects);
}
