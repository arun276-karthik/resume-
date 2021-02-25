/**
 * DAO package which contains this AddressDAO interface
 */
package com.ideas2it.employeeProjectManagement.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeeProjectManagement.employee.model.Address; 

/**
 * AddressDAO interface which is used to attain the abstraction 
 * so only abstract methods are there in this not the method body
 * The methods are implemented in AddressDAOimpl.
 * 
 * @author   AK
 * @SInce    12-02-2021
 * @version  1.0
 */
public interface AddressDAO { 	

	/**
	 * Interface to create Address Details for an employee
	 * 
	 * @param address        the details to create address
	 * @param addressType    permanent or current
	 * @throws SQLException  to suppress SQLException
	 */
	public void createAddressDetails(Address address) 
			throws SQLException; 
	/**
	 * Interface to view Addres Details of an employee
	 * 
	 * @param employeeId     to get the address for employee id
	 * @return               address list 
	 * @throws SQLException  to suppress SQLException
	 */
	public List<Address> viewAddressDetails(int employeeId) 
			throws SQLException; 

	/**
	 * Interface to view all Address List
	 * 
	 * @return               addressList
	 * @throws SQLException  to suppress SQLException
	 */
	public List<Address> viewAddressList() 
			throws SQLException; 

	/**
	 * Interface to update address Details
	 * 
	 * @param permanentAddress  permanent address details 
	 * @param currentAddress    current address details
	 * @return                  boolean 
	 * @throws SQLException     to suppress SQLException
	 */
	public boolean isUpdateAddressDetails(Address permanentAddress, Address currentAddress) 
			throws SQLException; 
} 
