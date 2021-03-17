/**
 * Package to have address class which maintains all address details variables
 */
package com.ideas2it.employeeProjectManagement.address.model;

import com.ideas2it.employeeProjectManagement.employee.model.Employee;

/**
 * The Address class is used for encapsulation of data
 *
 * @author  Ak
 * @version 1.0
 */
public class Address {

    private int addressId;
    private int employeeId;
    private String streetAddress;
    private String state;
    private String city;
    private String postalCode;
    private String addressType;
    private Employee employee;

    // Empty constructor
    public Address() {
    }

    /**
     * Address parametrized constructor
     *
     * @param   streetAddress	permanent street address of an employee
     * @param   state           Permanent state
     * @param   city            permanent city
     * @param   postalCode      permanent postalCode
     */
    public Address(String streetAddress, String state, String city, String postalCode) {
        this.streetAddress = streetAddress;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

	/*@Override
	public String toString() {
		return(streetAddress + " " + city + " " + state + " " + postalCode);
	}*/
}
