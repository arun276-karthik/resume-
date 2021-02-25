/**
 * View package to print and scan all details for employee management
 */
package com.ideas2it.employeeProjectManagement.employee.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
					+ "5.View All Employee \n6.Exit"; 
			while (6 != selectMenu) {
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
				
				availableProjects();

				int employeeId = employeeController.createEmployeeDetails(firstName, secondName, designation, salary,
						emailId, dateOfBirth, phoneNumber, streetAddress, state, city, postalCode, currentStreetAddress,
						currentState, currentCity, currentPostalCode);

				// Method to enter the projects in which employee work
				projectAssign();
				System.out.println("Your employeeId is " + employeeId);
				boolean projectAssign = employeeController.isProjectAssign(employeeId, employeeProjects);
				if (projectAssign) {
					System.out.println("Project has been successfully assigned for employeeId " + employeeId);
				} else {
					System.out.println("Error in Assigning project");
				}
				System.out.println("press 1 to add another Employee  or  anynumber to skip ");
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
		Scanner scanner = new Scanner(System.in);
		int pressToAddProject = 0;
		employeeProjects = new ArrayList<Integer>();
		/*List<Integer> projectIdList = employeeController.showAvailableProjectId();
		for (Integer projectIds : projectIdList) {
			System.out.println(projectIds);
		}*/
		do {
			System.out.println("Enter your  Project Id");
			int employeeProjectId = scanner.nextInt();
			employeeProjects.add(employeeProjectId);
			System.out.println("press 1 to add another projectId");
			pressToAddProject = scanner.nextInt();
		} while (1 == pressToAddProject);
	}

	/**
	 * To List the available project ids to assign for an employee
	 * 
	 * @throws SQLException 
	 */
	private void availableProjects() throws SQLException {
		List<LinkedHashMap<Integer, Integer>> employeeDetailsList = employeeController.availableProjects();
		for (LinkedHashMap<Integer, Integer> employee : employeeDetailsList) {
			for (Map.Entry<Integer, Integer> entry : employee.entrySet())  
	        System.out.println(entry.getKey());
			//System.out.println(employee);
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
			ArrayList<LinkedHashMap<String, Object>> employeeDetailsList = employeeController.viewEmployeeList();
			for (LinkedHashMap<String, Object> employee : employeeDetailsList) {
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
			ArrayList<LinkedHashMap<String, Object>> employeeDetails = employeeController
					.viewEmployeeDetails(employeeId);
			if (null != employeeDetails) {
				System.out.println("Employee Details for  id:" + employeeId);
				for (LinkedHashMap<String, Object> employee : employeeDetails) {
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
			/*System.out.println("Press 1 to remove project or any to skip "
					+ "\n Enter the Project Id to remove");
			while (1 == scanner.nextInt()) {
				do {
					int removeProject = scanner.nextInt();
					System.out.println("Press 1 to remove anothe project Id or any to skip");
					employeeProjects.add(removeProject);
				} while (1 == scanner.nextInt());
				employeeController.isProjectRemove(employeeId, employeeProjects);
			}*/
		} catch (SQLException exception) {
			employeeMenu();
		}
	}

	/**
	 * To check Id is an integer pass Id as argument
	 * 
	 * @param employeeid check id is valid
	 * @return id if it is valid
	 */
	/*
	 * public String checkValidEmployeeId(String employeeId) { if
	 * (!Util.isValidId(employeeId)) {
	 * System.out.println("please enter the valid id number"); return null; } return
	 * employeeId; }
	 */

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

	/**
	 * To update the details of an employee by id.
	 */
	/*
	 * public void updateEmployeeDetails() { Scanner scanner = new
	 * Scanner(System.in); System.out.println("Enter the employeeid to update");
	 * String id = scanner.next(); boolean isAgain = false; do { isAgain = false;
	 * System.out.println("Enter which one to update");
	 * System.out.println("1.role \n2.Address \n3.Salary" + "\n4.Exit"); int
	 * selectMenu = scanner.nextInt(); switch (selectMenu) { case 1:
	 * updateEmployeeDesignation(id); break; case 2: updateEmployeeAddress(id);
	 * break; case 3: updateEmployeeSalary(id); break; case 4:
	 * System.out.println("Thank YOU"); isAgain = false; break; default :
	 * System.out.println("Invalid key \n\t Please choose again"); isAgain = true;
	 * break; } } while (isAgain); }
	 */

	/**
	 * updating Designation of an employee. If not updated check your employee id
	 * 
	 * @param id employee id to update the Designation for this id
	 */
	/*
	 * public void updateEmployeeDesignation(String id) { Scanner scanner = new
	 * Scanner(System.in); System.out.println("Enter the employee Role to update");
	 * String newDesignation = scanner.next(); if
	 * (!Util.isValidChar(newDesignation)) {
	 * System.out.println("Enter a valid Designation"); } else { if
	 * (employeeController.isDesignationUpdate(id, newDesignation)) {
	 * System.out.println("Designation has been updated"); } else {
	 * System.out.println("Designation has not been updated " +
	 * "\t Entered Id not exists"); } } }
	 */

	/**
	 * To update Salary for an valid id If not updated check your employee id
	 *
	 * @param id employee id to update the salary for this id
	 */
	/*
	 * public void updateEmployeeSalary(String id) { Scanner scanner = new
	 * Scanner(System.in);
	 * System.out.println("Enter the employee Salary to update"); String newSalary =
	 * scanner.next(); if (employeeController.isSalaryUpdate(id, newSalary)) {
	 * System.out.println("Salary has been updated"); } else {
	 * System.out.println("Salary has not been updated \t Entered Id not exists"); }
	 * }
	 */

	/**
	 * To update Address for an valid id If not updated check your employee id
	 * 
	 * @param id employee id to update the address for this id
	 */
	/*
	 * public void updateEmployeeAddress(String id) { Scanner scanner = new
	 * Scanner(System.in); //Enter permanent Address of an employee
	 * System.out.println("Enter permanent Address ");
	 * System.out.println("Enter the streetAddress"); String streetAddress =
	 * scanner.nextLine(); System.out.println("Enter the State"); String state =
	 * scanner.nextLine(); System.out.println("Enter the City"); String city =
	 * scanner.nextLine(); System.out.println("Enter the PostalAddress"); Long
	 * postalCode = scanner.nextLong();
	 * 
	 * //Enter current Address of an employee
	 * System.out.println("Enter Current Address ");
	 * System.out.println("Enter the current streetAddress"); String
	 * currentStreetAddress = scanner.nextLine();
	 * System.out.println("Enter the current State"); String currentState =
	 * scanner.nextLine(); System.out.println("Enter the current City"); String
	 * currentCity = scanner.nextLine();
	 * System.out.println("Enter the currrent PostalAddress"); Long
	 * currentPostalCode = scanner.nextLong();
	 * 
	 * if (employeeController.isAddressUpdate(id, streetAddress, state, city,
	 * postalCode, currentStreetAddress, currentState, currentCity,
	 * currentPostalCode)) { System.out.println("Address has been updated"); } else
	 * {
	 * System.out.println("Address has not been updated \t Entered Id not exists");
	 * } }
	 */
}