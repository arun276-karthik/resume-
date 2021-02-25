/**
 * DAO package contains DAO pattern which is used to separate low level data 
 * accessing API or operations from high level business services.
 */
package com.ideas2it.employeeProjectManagement.employee.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.employeeProjectManagement.DataBaseConnection.DBConnection;
import com.ideas2it.employeeProjectManagement.employee.model.Address;


/**
 * Address DAO implementation class which implements the low level data 
 * accessing API or operations from the address data source .This DAO class 
 * provides CRUD database operations for the table address in the database
 * 
 * @author  AK
 * @since   10-02-2021
 * @version 1.0
 */
public class AddressDAOImpl implements AddressDAO { 

	/**
	 * Insert Address Details method which inserts the values in the addresses
	 * table for the employeeeId
	 * 
	 * @param  address       to get the values from the Address 
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public void createAddressDetails(Address address) throws SQLException {
		Session session = DBConnection.getSessionFactory().openSession(); 
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(address); 
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}		
	}


	/**
	 * If Address detail is deleted then true is returned
	 * 
	 * @param employeeId     it is the employee id to delete delete details for
	 * @return               boolean 
	 * @throws SQLException  to suppress the sql exception  
	 */
	/*public boolean isAddressDeleted(int employeeId) throws SQLException {

		
			preparedStatement.setInt(1, employeeId);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} 
		return false;
	}
	 */

	/**
	 * To update address Details of an employee
	 * 
	 * @param permanentAddress  employee permanent address   
	 * @param currentAddress    employee current address
	 * @return                  boolean
	 * @throws                  SQLException 
	 */
	@Override
	public boolean isUpdateAddressDetails(Address permanentAddress, Address currentAddress) throws SQLException {
		Address updatePermanentAddress = new Address();
		Address updateCurrentAddress = new Address();
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			if ("Permanent".equals(permanentAddress.getAddressType())) {
				updatePermanentAddress = (Address)session.get(Address.class, permanentAddress.getEmployeeId());
				updatePermanentAddress.setEmployeeId(permanentAddress.getEmployeeId());
				updatePermanentAddress.setStreetAddress(permanentAddress.getStreetAddress());
				updatePermanentAddress.setState(permanentAddress.getState());
				updatePermanentAddress.setCity(permanentAddress.getCity());
				updatePermanentAddress.setPostalCode(permanentAddress.getPostalCode());
				updatePermanentAddress.setAddressType(permanentAddress.getAddressType());
			}  if ("Current".equals(currentAddress.getAddressType())) {
				updateCurrentAddress = (Address)session.get(Address.class, currentAddress.getEmployeeId());
				updateCurrentAddress.setEmployeeId(currentAddress.getEmployeeId());
				updateCurrentAddress.setStreetAddress(currentAddress.getStreetAddress());
				updateCurrentAddress.setState(currentAddress.getState());
				updateCurrentAddress.setCity(currentAddress.getCity());
				updateCurrentAddress.setPostalCode(currentAddress.getPostalCode());
				updateCurrentAddress.setAddressType(currentAddress.getAddressType());
			}
			session.update(updatePermanentAddress); 
			session.update(updateCurrentAddress);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			//e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return false;
	}



	/**
	 * view Employee Detail which get the data from resource and sets to Employee
	 * model for an employee Id
	 * 
	 * @param employeeId     the details of this employee id is displayed
	 * @return               employee details for an id
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public List<Address> viewAddressDetails(int employeeId) throws SQLException {
		List<Address> addressList = null;
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			addressList = (List<Address>) session.createQuery("FROM Address A WHERE A.employeeId = employeeId").list();
			transaction.commit();			
		} catch (HibernateException e) {
			if (null != transaction) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
			return addressList;
		}  
	}	

	/**
	 * View Employee Details list which got from resource 
	 * 
	 * @return               employee details List for an id
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public List<Address> viewAddressList() throws SQLException {
		List<Address> addressList = null;
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			addressList = session.createQuery("FROM Address").list(); 
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
			return addressList;
		}	      
	}
}	
