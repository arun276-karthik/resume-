/**
 * View package to print and scan all details for employee management
 */
package com.ideas2it.employeeProjectManagement.employee.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.ideas2it.employeeProjectManagement.employee.controller.EmployeeController;
import com.ideas2it.employeeProjectManagement.util.Util;

/**
 * EmployeeView class is a user Interface which presents data to user or handles
 * User interactions
 * 
 * @author A.K
 * @since 22-01-2021
 * @version 1.0
 */
public class EmployeeView {

	EmployeeController employeeController = new EmployeeController();
	String             firstName = null;
	String             secondName = null;
	String             designation = null;
	String             salary = null;
	String             emailId = null;
	String             phoneNumber = null;
	String             dateOfBirth = null;
	String             streetAddress = null;
	String             state = null;
	String             city = null;
	String             postalCode = null;
	String             currentStreetAddress = null;
	String             currentState = null;
	String             currentCity = null;
	String             currentPostalCode = null;
	List<Integer>      employeeProjects = null;

	/**
	 * Main view class displays the options To manage the employee Details
	 * 
	 * @throws SQLException
	 */
	public void employeeMenu() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			int selectMenu = 0;
			String employeeMenu = "Employee Management \n1.Register  Employee \n"
					+ "2.Update Employee \n3.Delete Employee \n4.View Employee \n"
					+ "5.View All Employee \n6.Project Assign \n7.Exit"; 
			while (7 != selectMenu) {
				System.out.println(employeeMenu);
				System.out.println("Select your option");
				selectMenu = scanner.nextInt();
				switch (selectMenu) {
				case 1:
					createEmployeeDetails();
					break;
				case 2:
					updateEmployeeDetails();
					break;
				case 3:
					deleteEmployeeDetails();
					break;
				case 4:
					viewEmployeeDetails();
					break;
				case 5:
					viewEmployeeList();
					break;
				case 6:
					projectAssign();
					break;
				case 7:					
					System.out.println("Thank you");
					break;
				default:
					System.out.println("Invalid Key Please Enter valid key");
				}
			}
		} catch (SQLException exception) {
			System.out.println("Sorry Try again Later ");
			//throw exception;
		}
	}

	/**
	 * To register the employee details Enter the details like name, address etc.,
	 * 
	 * @throws SQLException
	 */
	private void createEmployeeDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			int pressToAddDetails;
			do {
				System.out.println("Registering Employee");

				// Method to enter the employee details
				employeeDetails();

				// Method to enter the employee address
				employeeAddressDetails();

				int employeeId = employeeController.createEmployeeDetails(firstName, secondName, designation, salary,
						emailId, dateOfBirth, phoneNumber, streetAddress, state, city, postalCode, currentStreetAddress,
						currentState, currentCity, currentPostalCode);
				System.out.println("Your employeeId is " + employeeId 
						+ "\n press 1 to add another Employee  or  anynumber to skip ");
				pressToAddDetails = scanner.nextInt();
			} while (1 == pressToAddDetails);
		} catch (SQLException exception) {
			employeeMenu();
		}
	}

	/**
	 * To create employee details
	 * 
	 * @throws SQLException to suppress SQLException
	 */
	private void employeeDetails() {

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\n Enter the First Name");
			firstName = scanner.next();
		} while (null == checkValidFirstName(firstName));
		do {
			System.out.println("Enter the Second name");
			secondName = scanner.next();
		} while (null == checkValidSecondName(secondName));
		System.out.println("Enter the Designation");
		designation = scanner.next();
		do {
			System.out.println("Enter the salary");
			salary = scanner.next();
		} while (null == checkValidSalary(salary));
		do {
			System.out.println("Enter the  email Id");
			emailId = scanner.next();
		} while (null == checkValidEmail(emailId));
		do {
			System.out.println("Enter the Phone Number");
			phoneNumber = scanner.next();
		} while (!Util.isValidPhoneNumber(phoneNumber));
		do {
			System.out.println("Enter the Date Of Birth (YYYY-MM-DD)");
			dateOfBirth = scanner.next();
		} while (!Util.isValidDate(dateOfBirth));
	}

	/**
	 * To assign projects to employee
	 * 
	 * @throws SQLException
	 */
	private void projectAssign() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter employee Id to assign project");
			int employeeIdInProject = scanner.nextInt();
			int pressToAddProject = 0;
			employeeProjects = new ArrayList<Integer>();

			//List the available projects 
			availableProjects();

			do {
				System.out.println("Enter your  Project Id");
				int employeeProjectId = scanner.nextInt();
				employeeProjects.add(employeeProjectId);
				System.out.println("press 1 to add another projectId");
				pressToAddProject = scanner.nextInt();
			} while (1 == pressToAddProject);
			if (employeeController.isProjectAssign(employeeIdInProject, employeeProjects)) {
				System.out.println("Project has been successfully assigned for employeeId " + employeeIdInProject);
			} else {
				System.out.println("Error in Assigning project");
			}
		} catch (SQLException e) {
			System.out.println("Try later");
			employeeMenu();
		}
	}

	/**
	 * To List the available project ids to assign for an employee
	 * 
	 * @throws SQLException 
	 */
	private void availableProjects() throws SQLException {
		try {
			List<Set<Integer>> availableProjectList = employeeController.availableProjects();
			for (Set<Integer> employee : availableProjectList) {
				System.out.println(employee);
			}
		} catch (SQLException e) {
			System.out.println("Try later");
			employeeMenu();
		}
	}


	/**
	 * To enter the employee Address Details
	 */
	private void employeeAddressDetails() {
		Scanner scanner = new Scanner(System.in);
		// Enter permanent Address of an employee
		System.out.println("\n************Enter permanent Address*************** \n");
		System.out.println("Enter the streetAddress");
		streetAddress = scanner.nextLine();
		System.out.println("Enter the State");
		state = scanner.next();
		System.out.println("Enter the City");
		city = scanner.next();
		System.out.println("Enter the PostalAddress");
		postalCode = scanner.next();
		System.out.println("Press 1 to auto fill the current address with"
				+ " permanent address or Press any key to enter manually");
		int autoFillAddress = scanner.nextInt();
		if (1 == autoFillAddress) {
			currentStreetAddress = streetAddress;
			currentState = state;
			currentCity = city;
			currentPostalCode = postalCode;
		} else {
			System.out.println("\n***************Enter Current Address**************** \n ");
			System.out.println("Enter the current streetAddress");
			currentStreetAddress = scanner.next();
			System.out.println("Enter the current State");
			currentState = scanner.next();
			System.out.println("Enter the current City");
			currentCity = scanner.next();
			System.out.println("Enter the currrent PostalAddress");
			currentPostalCode = scanner.next();
		}
	}

	/**
	 * To update employee Details enter the details
	 * 
	 * @throws SQLException to suppress SQLException
	 */
	private void updateEmployeeDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			boolean isUpdate;
			System.out.println("Enter the employee id to update details");
			int employeeId = scanner.nextInt();
			System.out.println("Updating Employee");

			// To update the employee Details
			employeeDetails();

			// To update the employee Address
			employeeAddressDetails();
			isUpdate = employeeController.isUpdateEmployeeDetails(employeeId, firstName, secondName, designation,
					salary, emailId, dateOfBirth, phoneNumber, streetAddress, state, city, postalCode, currentStreetAddress,
					currentState, currentCity, currentPostalCode);
			if (isUpdate) {
				System.out.println("Employee Details Updated Successfully");
			} else {
				System.out.println("Please check your employee Id");
			}
		} catch (SQLException exception) {
			employeeMenu();
		}
	}

	/**
	 * View All the Employee Details
	 * 
	 * @throws SQLException to suppress SQLException
	 */
	private void viewEmployeeList() throws SQLException {
		try {
			List<Map<String, Object>> employeeDetailsList = employeeController.viewEmployeeList();
			for (Map<String, Object> employee : employeeDetailsList) {
				if (0 != employeeDetailsList.size()) {
					System.out.println(employee);
				} else {
					System.out.println("Employee Table is Empty");
				}
			}
		} catch (SQLException exception) {
			employeeMenu();
			//throw exception;
		}
	}

	/**
	 * View Employee Details by id
	 * 
	 * @throws SQLException
	 */
	private void viewEmployeeDetails() throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Employee id to view details");
			int employeeId = scanner.nextInt();
			List<Map<String, Object>> employeeDetails = employeeController
					.viewEmployeeDetails(employeeId);
			if (null != employeeDetails) {
				System.out.println("Employee Details for  id:" + employeeId);
				for (Map<String, Object> employee : employeeDetails) {
					System.out.println(employee);
				}
			} else {
				System.out.println("Please Check Your Employee id");
			}
		} catch (SQLException exception) {
			employeeMenu();
		}
	}

	/**
	 * Delete Employee details by id
	 * 
	 * @throws SQLException
	 */
	private void deleteEmployeeDetails() throws SQLException {
		employeeProjects = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Employee id to Delete details");
			int employeeId = scanner.nextInt();
			if (employeeController.employeeDelete(employeeId)) {
				System.out.println("Employee Details for  id " + employeeId + "is deleted");
			} else {
				System.out.println("Invalid Employee id");
			}
		} catch (SQLException exception) {
			employeeMenu();
		}
	}

	/**
	 * To check the input firstName is character
	 * 
	 * @param firstname firstname to check its character is valid
	 * @return firstName if it is valid
	 */
	private String checkValidFirstName(String firstName) {
		if (!Util.isValidChar(firstName)) {
			System.out.println("please enter the valid name");
			return null;
		}
		return firstName;
	}

	/**
	 * To check the input secondName is character
	 * 
	 * @param secondname secondname to check it is valid
	 * @return secondName if it is valid
	 */
	private String checkValidSecondName(String secondName) {
		if (!Util.isValidChar(secondName)) {
			System.out.println("please enter the valid name");
			return null;
		}
		return secondName;
	}

	/**
	 * To check input salary is in numbers.
	 * 
	 * @param salary salary to validate
	 * @return salary if it is valid
	 */
	private String checkValidSalary(String salary) {
		if (!Util.isValidInteger(salary)) {
			System.out.println("please enter the valid number");
			return null;
		}
		return salary;
	}

	/**
	 * To check the entered email id is valid
	 * 
	 * @param emailId email id to check it is valid
	 * @return email id if it is valid
	 */
	private String checkValidEmail(String emailId) {
		if (!Util.isValidEmail(emailId)) {
			System.out.println("please enter the valid Email");
			return null;
		}
		return emailId;
	}
}