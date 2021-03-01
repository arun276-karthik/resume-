/**
 * Employee Project management to manage project and employee details
 */
package com.ideas2it.employeeProjectManagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.ideas2it.employeeProjectManagement.employee.view.EmployeeView;
import com.ideas2it.employeeProjectManagement.project.view.ProjectView;

/**
 * EmployeeAndProjectManagement class provides Management of an Employee and
 * Project      
 *
 * @author  AK
 * @version 1.0
 */
public class EmployeeProjectManagement {
	 
	/**
	 * Used to perform Employee Management operations and Project Management
	 * main method performs this operation
	 * 
	 * @param args name of the String array
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		int selectMenu = 0;
		String menuList = "Employee and Project Management System \n"
				+ "1.To manage Project details \n2.To manage Employee details of an employee \n" + "3.to Exit";
				while (3 != selectMenu) {
					System.out.println(menuList);
					System.out.println("Please Select an option");
					selectMenu = scanner.nextInt();
					ProjectView projectView = new ProjectView();
					EmployeeView employeeView = new EmployeeView();
					switch (selectMenu) {
					case 1:
						projectView.projectMenu();
						break;
					case 2:
						employeeView.employeeMenu();
						break;
					case 3:
						System.out.println("\t \t \tGreat, Thank You! Have a nice Day!  ");
						break;
					default:
						System.out.println("\t \t Enter valid key");		
					}
				} 
	}
}