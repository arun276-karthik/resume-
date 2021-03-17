/**
 * Package to maintain project details variables
 */
package com.ideas2it.employeeProjectManagement.project.model;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import java.util.List;

/**
 * ProjectModel class is used for encaplsulation of datas
 *
 * @author  Ak
 * @version 1.0
 */
public class Project {

    private int projectId;
    private String projectName;
    private String projectDueDate;
    private String projectManager;
    private List<Employee> employees;

    //Empty constructor
    public Project() {
    }

    /**
     * parametrised constructor
     *
     * @param   projectId              project id
     * @param   projectName            Project name
     * @param   projectDueDate  	   How long to complete project
     * @param   projectManager 		   manager of a project
     */
    public Project(String projectName, String projectDueDate, String projectManager) {
        this.projectName = projectName;
        this.projectDueDate = projectDueDate;
        this.projectManager = projectManager;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(String projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return(projectId + " " + projectDueDate + " " + projectName + " " + projectManager);
    }
}
