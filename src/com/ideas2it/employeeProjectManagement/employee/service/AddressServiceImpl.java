/**
 * Address service which handles the business logics for employee Address Management
 */
package com.ideas2it.employeeProjectManagement.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.dao.AddressDAO;
import com.ideas2it.employeeProjectManagement.employee.dao.AddressDAOImpl;
import com.ideas2it.employeeProjectManagement.employee.model.Address;

/**
 * Address Service is an Service class which performs logics and store values 
 * and send it to view class
 * 
 * @author  A.K
 * @since   08-02-2021
 * @version 1.0
 */
public class AddressServiceImpl implements AddressService {

	AddressDAO addressDAO = new AddressDAOImpl();

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
	@Override
	public void createAddressDetails(int employeeId, String streetAddress,
			String state, String city, String postalCode, String currentStreetAddress,
			String currentState, String currentCity, String currentPostalCode) throws SQLException {
		String permanentAddressType = "Permanent";
		String currentAddressType = "Current";
		Address permanentAddress = new Address();
		permanentAddress.setEmployeeId(employeeId);
		permanentAddress.setStreetAddress(streetAddress);
		permanentAddress.setState(state);
		permanentAddress.setCity(city);
		permanentAddress.setPostalCode(postalCode);
		permanentAddress.setAddressType(permanentAddressType);
		Address currentAddress = new Address();
		currentAddress.setEmployeeId(employeeId);
		currentAddress.setStreetAddress(currentStreetAddress);
		currentAddress.setState(currentState);
		currentAddress.setCity(currentCity);
		currentAddress.setPostalCode(currentPostalCode);
		currentAddress.setAddressType(currentAddressType);		
		//Address permanentAddress = new Address(employeeId, streetAddress, state, city, 
				//postalCode);
		//Address currentAddress = new Address(employeeId, currentStreetAddress,  currentState,
				//currentCity, currentPostalCode);
		addressDAO.createAddressDetails(permanentAddress);
		addressDAO.createAddressDetails(currentAddress);		
	}

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
	@Override
	public boolean isUpdateAddressDetails(int employeeId, String streetAddress, String state, String city,
			String postalCode,	String currentStreetAddress, String currentState,
			String currentCity, String currentPostalCode) throws SQLException {
		Address permanentAddress = new Address();
		Address currentAddress = new Address();
		permanentAddress.setEmployeeId(employeeId);
		permanentAddress.setStreetAddress(streetAddress);
		permanentAddress.setState(state);
		permanentAddress.setCity(city);
		permanentAddress.setPostalCode(postalCode);
		permanentAddress.setAddressType("Permanent");
		currentAddress.setEmployeeId(employeeId);
		currentAddress.setStreetAddress(currentStreetAddress);
		currentAddress.setState(currentState);
		currentAddress.setCity(currentCity);
		currentAddress.setPostalCode(currentPostalCode);
		currentAddress.setAddressType("Current");
		return addressDAO.isUpdateAddressDetails(permanentAddress, currentAddress);
	}

	/**
	 * View Address Details is a method which gets the address details of an 
	 * employee and return the address list
	 * 
	 * @param employeeId     the address detail of an employee
	 * @return				 addressDetailsList
	 * @throws SQLException  to suppress SqlException
	 */
	@Override
	public List<Address> viewAddressDetails(int employeeId) throws SQLException {
		return addressDAO.viewAddressDetails(employeeId);
	}

	/**
	 * View Address Details is a method which gets the address details of an 
	 * employee and return the address list
	 * 
	 * @return				 addressDetailsList
	 * @throws SQLException  to suppress SqlException
	 */
	@Override
	public List<Address> viewAddressList() throws SQLException {
		return addressDAO.viewAddressList();	
	}
}
