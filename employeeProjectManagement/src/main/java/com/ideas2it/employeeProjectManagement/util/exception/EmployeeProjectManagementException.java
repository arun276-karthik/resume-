/**
 * Exception to handle all exceptions
 */
package com.ideas2it.employeeProjectManagement.util.exception;

/**
 * This class is form of Throwable that indicates conditions that a reasonable
 * application might want to catch.
 */
public class EmployeeProjectManagementException extends Exception {

    /**
     *
     * @param message
     */
    public EmployeeProjectManagementException(String message) {
        super(message);
    }
}
