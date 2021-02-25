/**
 * Util package to maintain the validation logics 
 */
package com.ideas2it.employeeProjectManagement.util;

/**
 * util class which has the validation checking blocks 
 * 
 * @author  AK
 * @since   22-01-2021
 * @version 1.0
 */
public class Util {

	// To check entered Character is valid
	public static boolean isValidChar(String character) {  
		return character.matches("[a-zA-Z]+");    
	}

	// To check entered address is a String
	public static boolean isValidAddress(String address) {  
		return address.matches("[a-zA-Z0-9]+");
	}

	// To check entered address is a String
	public static boolean isValidId(String iD) {  
		return iD.matches("[a-zA-Z0-9]+");
	}

	// To check entered integer is valid
	public static boolean isValidInteger(String number) {  
		return number.matches("[0-9]+");
	}

	// To check entered email id is valid
	public static boolean isValidEmail(String email) {  
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");  
	}    

	//To check entered date format is valid
	public static boolean isValidDate(String date) {
		return date.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
	}
	
	//To check entered phone number is valid 
	public static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("^\\d{10}$");
	}
	
	//To check entered age is valid
	/*public static boolean isValidDOB(String age) {
		return age.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
	}*/
}                                                 

