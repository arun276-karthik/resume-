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
    List<Project> getProjectList();

    /**
     * Add the Project details checking the Project id is already present or not
     *
     *
     */
    int createProjectDetails(Project project);

    /**
     * To delete project details by id.
     *
     * @param  projectId    to remove the details by id
     * @return true         project id deleted.
     * @return false        project id not exists.
     */
    boolean deleteProject(int projectId);

    /**
     * Project Details Update metod to change the project details
     *
     * @return                boolean
     */
    boolean updateProjectDetails(Project project);

    /**
     * To get the project details providing id
     *
     * @param projectId      enter id to view project details
     * @return               projectDetailsList
     */
    Project getProjectDetails(int projectId);

    /**
     * To get the projectIds List
     *
     * @return              projectId lists
     */
    List<Set<Integer>> availableProjects();

    /**
     * Interface to get projects assign for employee
     *
     * @param employeeProjects  list of project ids
     * @return                  employees
     */
    List<Project> employeeProjectDetails(List<Integer> employeeProjects);
}
