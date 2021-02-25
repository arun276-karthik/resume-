/**
 * View package to print and scan all details for project management
 */
package com.ideas2it.employeeProjectManagement.project.view;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeeProjectManagement.project.controller.ProjectController;
import com.ideas2it.employeeProjectManagement.util.Util;

/**
 * ProjectView class is a user Interface which presents data to user or handles
 * User interactions.
 * 
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class ProjectView {

	ProjectController projectController = new ProjectController();
	int projectId = 0;

	/**
	 * ProjectMainView Displays the option 
	 * To manage project details.
	 * 
	 * @param repeatOptions  to repeat options is while is true.
	 * @param selectMenu     to select the menu to perform action.
	 * @throws SQLException  to suppress SQLExceptino
	 */
	public void projectMenu() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			int selectMenu = 0;
			String projectMenu = "Project Management \n1.Register  Project \n"+
					"2.Update Project \n3.Delete Project \n4.View Project \n"+
					"5.View All Project \n6.Exit";
			while (6 != selectMenu) {
				System.out.println(projectMenu);		
				System.out.println("Select your option");
				selectMenu = scanner.nextInt();
				switch (selectMenu) {
				case 1:
					createProjectDetails();
					break;
				case 2:
					updateProjectDetails();
					break;
				case 3:
					deleteProjectDetails();
					break;
				case 4:
					viewProjectDetails();
					break;
				case 5:
					viewProjectList();
					break;
				case 6:
					System.out.println("Thank you");
					break;
				default :
					System.out.println("Invalid Key Please Enter valid key");
				}
			} 
		} catch (SQLException exception) {
			System.out.println("SOrrY Please Try again Later");
		}
	}

	/**
	 * To register the Project details
	 * Enter the details like Project name, id etc.,
	 * @throws SQLException 
	 */	
	public void createProjectDetails() throws SQLException {		
		try {
			Scanner scanner = new Scanner(System.in);
			int pressToAddDetails ;
			do {
				System.out.println("Registering Project");
				System.out.println("\n Enter the Project Name");
				String projectName = scanner.next(); 
				String projectDueDate;
				do {
					System.out.println("Enter the Working Period (YYYY-MM-DD)");
					projectDueDate = scanner.next();
				} while (!Util.isValidDate(projectDueDate));			
				String projectManager;
				do {			
					System.out.println("Enter the Manager Name");
					projectManager = scanner.next();
				} while (!Util.isValidChar(projectManager));
				int projectId = projectController.createProjectDetails(projectName, projectDueDate, projectManager);			
				System.out.println("Project Id for this Project is: " + projectId);
				System.out.println("Available Projects");
				//List<Map<Integer, Integer>> projectIdList = projectController.showAvailableProjectId();
				//for (Map<Integer, Integer> projectIds : projectIdList) {
				//	System.out.println(projectIds);
				//}
				//employeesInProject();
				System.out.println("press 1 to add another project /t any number to skip");
				pressToAddDetails = scanner.nextInt();
			} while (1 == pressToAddDetails);
		} catch (SQLException exception) {
			projectMenu();
		}
	}		

	/**
	 * to list employees for this projectId
	 * 
	 * @throws SQLException 
	 * 
	 */
	/*public void employeesInProject() throws SQLException { 		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter projectId to see Employees working in this project");
			int projectId = scanner.nextInt();
			LinkedHashMap<String, Integer> employees = projectController.viewEmployeesInProject(projectId);		
			for (Map.Entry<String, Integer> employeesProject : employees.entrySet())  			
				System.out.println(" " + employeesProject.getKey() + 
						" = " + employeesProject.getValue()); 
		} catch (SQLException exception) {
			projectMenu();
		}
	}*/

	/**
	 * View project List
	 * @throws SQLException 
	 */
	public void viewProjectList() throws SQLException {
		try {
			List<LinkedHashMap<String, Object>> projectDetailsList = projectController.viewProjectList();
			for(LinkedHashMap<String, Object> projectList : projectDetailsList){
				System.out.println(projectList);
			}
		} catch (SQLException exception) {
			projectMenu();
		}
	}

	/**
	 * View Project Details 
	 * @throws SQLException 
	 */
	public void viewProjectDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Project id to view details");
			int projectId = scanner.nextInt();
			Map<String, Object> projectDetails = projectController.viewProjectDetails(projectId);
			if (null != projectDetails) {
				System.out.println("Project Details for  id:" + projectId);
				Iterator<Object> viewProjectDetails = projectDetails.values().iterator();
				while (viewProjectDetails.hasNext()) {
					System.out.println(viewProjectDetails.next());
				}
			} else {
				System.out.println("Invalid project id");
			}
		} catch (SQLException exception) {
			projectMenu();
		}
	}

	/**
	 * Delete project details 
	 * @throws SQLException   to suppress SQLException
	 */
	public void deleteProjectDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the project id to Delete details");
			int projectId = scanner.nextInt();
			if (projectController.projectDelete(projectId)) {
				System.out.println("Project Details for  id " + projectId + " is deleted");
			} else {
				System.out.println("Invalid Project id");
			}
		} catch (SQLException exception) {
			projectMenu();
		}
	}

	/**
	 * To check the input Manager Name is character
	 * 
	 * @param  manager  to check the entered character valid 
	 * @return manager  Manager name will be returned if valid
	 * @return null     if null value then invalid format.
	 */
	/*public String checkValidProjectManagerName(String manager) {
		if (!Util.isValidChar(manager)) {
			System.out.println("please enter the valid Manager Name");
			return null;
		} 
		return manager;
	}*/

	/**
	 * To check the entered value is integer
	 * 
	 * @param  dueDate enter duedate to check valid format
	 * @return period  If the entered value is integer due date is returned
	 * @return null    if null the entered value is invalid format.
	 */
	/*public String checkValidProjectDueDate(String dueDate) {
		if (Util.isValidDate(dueDate)) {
			return dueDate;
		} else {
			System.out.println("please enter the valid Working period");
			return null;
		}
	}*/

	/**
	 * To update the details of an project by id
	 * 
	 * @throws SQLException 
	 */
	public void updateProjectDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Project Id to update");
			int projectId = scanner.nextInt();
			System.out.println("Registering Project");
			System.out.println("\n Enter the Project Name");
			String projectName = scanner.next(); 
			String projectDueDate;
			System.out.println("Enter the Working Period (YYYY-MM-DD)");
			projectDueDate = scanner.next();
			String projectManager;
			do {			
				System.out.println("Enter the Manager Name");
				projectManager = scanner.next();
			} while (!Util.isValidChar(projectManager));
			boolean projectUpdate = projectController.isUpdateProjectDetails(projectId, projectName,
					projectDueDate, projectManager);
			if (projectUpdate == true) {
				System.out.println("Project details have been updated");
			} else {
				System.out.println("Project details not updated please check");
			}
		} catch (SQLException exception) {
			projectMenu();
		}
	}

	/**
	 * To update the details of an project by id
	 */
	/*public void updateProjectDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Project Id to update");
		String projectId = scanner.next();
		boolean isRepeatMenu = false;
		do {
			isRepeatMenu = false;
			System.out.println("Enter which one to update");
			System.out.println("1.Projectname \n2.ProjectPeriod" +
					" \n3.ProjectManager \n4.Exit");
			int selectMenu = scanner.nextInt();
			switch (selectMenu) {
			case 1:
				updateProjectName(projectId);
				break;
			case 2:
				updateProjectDueDate(projectId);
				break;
			case 3:
				updateProjectManager(projectId);
				break;
			case 4:
				System.out.println("Thank YOU");
				isRepeatMenu = false;
				break;
			default :
				System.out.println("Invalid key \n\t Please choose again");
				isRepeatMenu = true;
				break;          
			}
		} while (isRepeatMenu);
	}*/

	/**
	 * Updating Name of an Project.
	 * If not updated check your Project id
	 * 
	 * @param projectId  update project name for this project id
	 */
	/*public void updateProjectName(String projectId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Project Name to update");
		String newProjectName = scanner.next();
		if (!Util.isValidChar(newProjectName)) {
			System.out.println("Enter a valid Project Name");
		} else {	
			if (projectController.isProjectNameUpdate(projectId, newProjectName)) {
				System.out.println("New Project Name has been updated");
			} else {
				System.out.println("Project Name has not been updated check Project id");
			}
		}
	}*/

	/**
	 * Updating DueDate of an project.
	 * If not updated check your Project id
	 * 
	 * @param projectId  update due date for this project id
	 */
	/*public void updateProjectDueDate(String projectId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the New Project due date to update");
		String newDueDate = scanner.next();
		if (!Util.isValidDate(newDueDate)) {
			System.out.println("Enter a valid Working Period of an Project");
		} else {	
			if (projectController.isProjectDueUpdate(projectId, newDueDate)) {
				System.out.println("Project due date has been updated");
			} else {
				System.out.println("Project due date has not been updated check Project id");
			}
		}
	}*/

	/**
	 * Updating Manager for an Project.
	 * If not updated check your Project id
	 * 
	 * @param projectId  update manager for this project  id 
	 */
	/*public void updateProjectManager(String projectId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the New Project Manager to update");
		String newManager = scanner.next();
		if (!Util.isValidChar(newManager)) {
			System.out.println("Enter a valid Manager Name");
		} else {	
			if (projectController.isManagerUpdate(projectId, newManager)) {
				System.out.println("Manager Name has been updated");
			} else {
				System.out.println("Manager Name has not been updated check Project id");
			}
		}
	}*/
}