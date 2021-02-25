/**
 * Address service which handles the business logics for employee Address Management
 */
package com.ideas2it.employeeProjectManagement.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.model.Address;

/**
 * Address Service Interface which has a class address Service 
 * to handle the business logics employee address management 
 *  
 * @author   AK
 * @since    16-02-2021
 * @version  1.0
 */
public interface AddressService {
	
	/**
	 * Add the address details of an employee
	 *  
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @throws SQLException 
	 */
	public void createAddressDetails(int employeeId, String streetAddress,
			String state, String city, String postalCode, 
			String currentStreetAddress, String currentState, String currentCity, 
			String currentPostalCode) throws SQLException;
	
	/**
	 * 
	 * @param employeeId             employee id of address
	 * @param  streetAddress         permanent street address of an employee
	 * @param  state                 Permanent state
	 * @param  city                  permanent city
	 * @param  postalCode            permanent postalCode
	 * @param  currentStreetAddress	 current street address
	 * @param  currentState          current state
	 * @param  currentCity           current city
	 * @param  currentPostalCode     current postal code
	 * @return
	 * @throws SQLException
	 */
	public boolean isUpdateAddressDetails(int employeeId, String streetAddress, 
			String state, String city, String postalCode,	String currentStreetAddress,
			String currentState, String currentCity, String currentPostalCode) 
					throws SQLException;
	
	/**
	 * View Address Details is a method which gets the address details of an 
	 * employee and return the address list
	 * 
	 * @param employeeId     the address detail of an employee
	 * @return				 addressDetailsList
	 * @throws SQLException  to suppress SqlException
	 */
	public List<Address> viewAddressDetails(int employeeId) throws SQLException;
	
	/**
	 * View Address Details is a method which gets the address details of an 
	 * employee and return the address list
	 * 
	 * @return				 addressDetailsList
	 * @throws SQLException  to suppress SqlException
	 */
	public List<Address> viewAddressList() throws SQLException;
}
