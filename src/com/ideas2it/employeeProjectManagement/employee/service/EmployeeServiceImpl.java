/**
 * Employee service which handles the business logics for employee management
 */
package com.ideas2it.employeeProjectManagement.employee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.dao.EmployeeDAO;
import com.ideas2it.employeeProjectManagement.employee.dao.EmployeeDAOImpl;
import com.ideas2it.employeeProjectManagement.employee.model.Address;
import com.ideas2it.employeeProjectManagement.employee.model.Employee;
import com.ideas2it.employeeProjectManagement.project.model.Project;
import com.ideas2it.employeeProjectManagement.project.service.ProjectServiceImpl;
import com.ideas2it.employeeProjectManagement.project.service.ProjectService;

/**
 * EmployeeService is an Service class which performs logics and store values 
 * and send it to view class
 * 
 * @author  A.K
 * @since   22-01-2021
 * @version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	AddressService addressService = new AddressServiceImpl();
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	ProjectService projectService = new ProjectServiceImpl();
	

	/**
	 * To view all Employee details list
	 * 
	 * @return employeeList  the Employee details list
	 * @throws SQLException 
	 */
	@Override
	public ArrayList<LinkedHashMap<String, Object>> viewEmployeeList() throws SQLException {
		ArrayList<LinkedHashMap<String,Object>> employeeDetailsList =
				new ArrayList<LinkedHashMap<String,Object>>();		
		List<Employee> employeeList = employeeDAO.viewEmployeeList();	
		List<Address> addressDetailsList = addressService.viewAddressList();
		for (Employee employee : employeeList) {	
			LinkedHashMap<String, Object> employeeDetails= new LinkedHashMap<String, Object>();
			employeeDetails.put("id", employee.getEmployeeId());
			employeeDetails.put("firstName", employee.getFirstName());
			employeeDetails.put("secondName", employee.getSecondName());
			employeeDetails.put("designation", employee.getDesignation());
			employeeDetails.put("salary", employee.getSalary());
			employeeDetails.put("emailId", employee.getEmailId());
			employeeDetails.put("age", employee.getDateOfBirth());
			employeeDetails.put("phoneNumber", employee.getPhoneNumber());
			employeeDetailsList.add(employeeDetails);		
			for (Address address : addressDetailsList) {
				if (employee.getEmployeeId() == address.getEmployeeId()) {
					LinkedHashMap<String, Object> employeeAddress = new LinkedHashMap<String, Object>();
					employeeAddress.put("employeeId", address.getEmployeeId());
					employeeAddress.put("streetAddress", address.getStreetAddress());
					employeeAddress.put("state", address.getState());
					employeeAddress.put("city", address.getCity());
					employeeAddress.put("postalCode", address.getPostalCode());
					employeeDetailsList.add(employeeAddress);
				}
			}
		} 
		return employeeDetailsList;		
	}


	/**
	 * Add the employee details and address details
	 * checking the employee id is already present or not
	 * 
	 * @param firstName 	         employee first name
	 * @param secondName	         employee second name
	 * @param designation 	         designation of employee
	 * @param salary	             of employee
	 * @param emailId	             email of an employee 
	 * @param age	                 age of an employee
	 * @param phoneNumber 	         phone number of an employee
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @throws SQLException          suppress the SQLException
	 */
	@Override
	public int createEmployeeDetails(String firstName, String secondName,
			String designation, String 	salary, String emailId, 
			String dateOfBirth, String phoneNumber, String streetAddress,
			String state, String city, String postalCode, String currentStreetAddress,
			String currentState, String currentCity, String currentPostalCode) throws SQLException {		
		Employee employee= new Employee(firstName, secondName,
				designation, salary, emailId, dateOfBirth, phoneNumber);
		int employeeId = 0;
		Address address = new Address(streetAddress, state,
				city, postalCode);
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		employee.setAddress(addressList);
		employeeId = employeeDAO.createEmployeeDetails(employee);
		/*addressService.createAddressDetails(employeeId, streetAddress, state,
				city, postalCode, currentStreetAddress, 
				currentState, currentCity, currentPostalCode);*/
		return employeeId;
	}

	/**
	 * boolean operation to check id exist or not
	 * 
	 * @param employeeId  to check that id already exist 
	 * @return    boolean 
	 */
	/*public boolean isEmployeeIdExist(String employeeId) {
		if (null != employeeList && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				if (employeeId.equals(employee.getEmployeeId())) {
					return true;
				} else {
					return false;
				}
			}
		} 
		return false;
	}*/

	/**
	 * To delete employee details by id.
	 * 
	 * @param  employeeId    to delete the details by employeeId  
	 * @return               boolean
	 * @throws SQLException  to suppress SQL exception
	 */
	@Override
	public boolean employeeDelete(int employeeId) throws SQLException {
		return employeeDAO.employeeDelete(employeeId);
	}


	/**
	 * To update employee Details and the boolean is returned
	 *
	 * @param employeeId             employeeId to update details
	 * @param firstName 	         employee first name
	 * @param secondName	         employee second name
	 * @param designation 	         designation of employee
	 * @param salary	             of employee
	 * @param emailId	             email of an employee 
	 * @param age	                 age of an employee
	 * @param phoneNumber 	         phone number of an employee
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @throws SQLException          suppress the SQLException
	 */
	@Override
	public boolean isUpdateEmployeeDetails(int employeeId, String firstName, String secondName,
			String designation, String salary,	String emailId, String dateOfBirth, String phoneNumber, 
			String streetAddress, String state, String city,
			String postalCode,	String currentStreetAddress, String currentState,
			String currentCity, String currentPostalCode) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setSecondName(secondName);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		employee.setEmailId(emailId);
		employee.setDateOfBirth(dateOfBirth);
		employee.setPhoneNumber(phoneNumber);
		boolean isAddressUpdate = addressService.isUpdateAddressDetails(employeeId, streetAddress, state,
				city, postalCode, currentStreetAddress, 
				currentState, currentCity, currentPostalCode);
		boolean isEmployeeUpdate = employeeDAO.isUpdateEmployeeDetails(employee);	
		if (true == isAddressUpdate  && true == isEmployeeUpdate) {
			return true;
		}
		return false;
	}

	/**
	 * To get the employee details by providing id
	 * 
	 * @param employeeId  get employee details for an id
	 * @return    boolean
	 */
	/*public Employee getEmployeeById(String employeeId) {
		for (Employee employee : employeeList) {
	 * To view the employee details by providing id
	 * 
	 * @param employeeId              view a employee details list by providing id              
	 * @return EmployeeDetails        returns the employee details for an id 
	 * @throws SQLException 
	 */

	@Override
	public ArrayList<LinkedHashMap<String,Object>> viewEmployeeDetails(int employeeId) throws SQLException {		
		ArrayList<LinkedHashMap<String,Object>> employeeDetails =
				new ArrayList<LinkedHashMap<String,Object>>();
		LinkedHashMap<String,Object> employeeData = new LinkedHashMap<String,Object>();
		Employee employee = employeeDAO.viewEmployeeDetails(employeeId);
		employeeData.put("id", employee.getEmployeeId());
		employeeData.put("firstName", employee.getFirstName());
		employeeData.put("secondName", employee.getSecondName());
		employeeData.put("designation", employee.getDesignation());
		employeeData.put("salary", employee.getSalary());
		employeeData.put("emailId", employee.getEmailId());
		employeeData.put("age", employee.getDateOfBirth());
		employeeData.put("phoneNumber", employee.getPhoneNumber());
		employeeDetails.add(employeeData);
		List<Address> addressDetails = addressService.viewAddressDetails(employeeId);
		for ( Address address : addressDetails) {
			LinkedHashMap<String,Object> employeeaddress = new LinkedHashMap<String,Object>();
			employeeaddress.put("streetAddress", address.getStreetAddress());
			employeeaddress.put("state", address.getState());
			employeeaddress.put("city", address.getCity());
			employeeaddress.put("postalCode", address.getPostalCode());
			employeeDetails.add(employeeaddress);
		}	
		return employeeDetails;		
	}

	/**
	 * To assign project to employee
	 * 
	 * @param employeeId        employeeId 
	 * @param employeeProjects  projects for employeeId
	 * @return                  boolean
	 * @throws SQLException     to suppress SQLException
	 */
	public boolean isProjectAssign(int employeeId, List<Integer> employeeProjects) throws SQLException {
		Employee employee = employeeDAO.viewEmployeeDetails(employeeId);
		//List<Project> employeeProjectList = new ArrayList<Project>();
		List<Project> employeeProjectDetailsList  = projectService.employeeProjectDetails(employeeProjects);
		List<Address> addressDetails = addressService.viewAddressDetails(employeeId);
		/*for (Project projectId : employeeProjectDetailsList) {
			employeeProjectList.add(projectId.getProjectId());
			
		}*/
		employee.setAddress(addressDetails);
		employee.setProject(employeeProjectDetailsList);		
		return employeeDAO.isProjectAssign(employee);
	}

	/**
	 * This method removes the project for employeeId
	 * 
	 * @param employeeId        employeeId 
	 * @param removeProject     project to remove
	 * @return                  boolean
	 * @throws SQLException     to suppress SQLException
	 */
	/*public boolean isProjectRemove(int employeeId, List<Integer> employeeProjects) throws SQLException {
		Employee employee = new Employee();
		List<Project> employeeProjectList  = new ArrayList<Project>();
		for (Integer project : employeeProjects) {
			Project projects = new Project();
			employeeProjectList.add(projects);			
		}
		employee.setProject(employeeProjectList);		
		employee.setEmployeeId(employeeId);
		return employeeDAO.isProjectRemove(employee);
	}*/

	/**
	 * To get employees in  project 
	 *  
	 * @param projectId      to get employee in project
	 * @return               employees 
	 * @throws SQLException  to suppress SQLException
	 */
	/*public LinkedHashMap<String, Integer> viewEmployeesInProject(int projectId) throws SQLException {
		return projectAssignDAO.viewEmployeesInProject(projectId);
	}*/

	/**
	 * To get the projectIds List
	 * @return              projectId lists
	 * @throws SQLException to suppress SQLException
	 */
	public List<LinkedHashMap<Integer, Integer>> availableProjects() throws SQLException {
		return projectService.availableProjects();
	}

	/**
	 * To update Designation of an employee
	 * 
	 * @param employeeId      to update designation for this id
	 * @param newDesignation  enter the new designation
	 * @return                boolean
	 */
	/*public boolean isDesignationUpdate(String employeeId, String newDesignation) {		
		Employee employee = getEmployeeById(employeeId);
		if (null != employee) {
			employee.setDesignation(newDesignation);
			return true;
		} else {
			return false;
		}
	}*/

	/**
	 * To update Salary of an employee.
	 * 
	 * @param employeeId enter the id to update amount
	 * @param newSalary  enter the new salary amount for this id
	 * @return           boolean
	 */
	/*public boolean isSalaryUpdate(String employeeId, String newSalary) {
		Employee employee = getEmployeeById(employeeId);
		if (null != employee) {
			employee.setSalary(newSalary);
			return true;
		} else {
			return false;
		}
	}*/

	/**
	 * To update Address of an employee.
	 * 
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @return 						 boolean
	 */
	/*public boolean isAddressUpdate(String employeeId, String streetAddress, String state,
			String city, Long postalCode, String currentStreetAddress, String currentState,
			String currentCity, Long currentPostalCode) {
		Address permanentAddress = new Address(streetAddress, state, city, 
				postalCode);
		Address currentAddress = new Address(currentStreetAddress, 
				currentState, currentCity, currentPostalCode);
		ArrayList<Address> addressList = new ArrayList<Address>();
		addressList.add(permanentAddress);
		addressList.add(currentAddress);
		Employee employee = getEmployeeById(employeeId);
		if (null != employee) {
			employee.setAddressList(addressList);
			return true;
		} else {
			return false;
		}
	}*/
}
