/**
 * View package to print and scan all details for project management
 */
package com.ideas2it.employeeProjectManagement.project.view;

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
	 */
	public void projectMenu() {
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
		} catch (Exception exception) {
			System.out.println("SOrrY Please Try again Later");
		}
	}

	/**
	 * To register the Project details
	 * Enter the details like Project name, id etc.,
	 */	
	public void createProjectDetails() {		
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
				} while (null == checkValidProjectDueDate(projectDueDate));			
				String projectManager;
				do {			
					System.out.println("Enter the Manager Name");
					projectManager = scanner.next();
				} while (!Util.isValidChar(projectManager));
				int projectId = projectController.createProjectDetails(projectName, projectDueDate, projectManager);			
				System.out.println("Project Id for this Project is: " + projectId);
				System.out.println("press 1 to add another project /t any number to skip");
				pressToAddDetails = scanner.nextInt();
			} while (1 == pressToAddDetails);
		} catch (Exception exception) {
			projectMenu();
		}
	}		


	/**
	 * View project List
	 */
	public void viewProjectList() {
		try {
			List<LinkedHashMap<String, Object>> projectDetailsList = projectController.viewProjectList();
			for(LinkedHashMap<String, Object> projectList : projectDetailsList){
				System.out.println(projectList);
			}
		} catch (Exception exception) {
			System.out.println("Invalid project Id");
			projectMenu();
		}
	}

	/**
	 * View Project Details 
	 */
	public void viewProjectDetails() {
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
		} catch (Exception exception) {
			System.out.println("Invalid project Id");
			projectMenu();
		}
	}

	/**
	 * Delete project details 
	 */
	public void deleteProjectDetails() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the project id to Delete details");
			int projectId = scanner.nextInt();
			if (projectController.deleteProject(projectId)) {
				System.out.println("Project Details for  id " + projectId + " is deleted");
			} else {
				System.out.println("Invalid Project id");
			}
		} catch (Exception exception) {
			System.out.println("Invalid project Id");
			projectMenu();
		}
	}

	/**
	 * To update the details of an project by id
	 */
	public void updateProjectDetails() {
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
				System.out.println("Project details not updated please check your Id");
			}
		} catch (Exception exception) {
			System.out.println("Invalid project Id");
			projectMenu();
		}
	}
	
	/**
	 * To check the entered date is valid
	 * 
	 * @param projectDueDate  date to check it is valid
	 * @return			      date if it is valid
	 */
	private Object checkValidProjectDueDate(String projectDueDate) {
		if(!Util.isValidDate(projectDueDate)) {
			System.out.println("Please enter the valid date");
			return null;
		}
		return projectDueDate;
	}
}