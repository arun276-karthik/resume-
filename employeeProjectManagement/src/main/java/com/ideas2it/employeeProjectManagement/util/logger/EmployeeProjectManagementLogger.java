/**
 * Logger package to have the logger class
 */
package com.ideas2it.employeeProjectManagement.util.logger;

import org.apache.log4j.Logger;

/**
 * Logger class to get the different log levels and log it to logger file
 * and to create logger object
 */
public class EmployeeProjectManagementLogger {

    private Logger logger ;

    /**
     * className is passed as String to the constructor to create
     * logger object
     *
     * @param className class Name to pass as parameter
     */
    public EmployeeProjectManagementLogger(String className) {
        logger = Logger.getLogger(className);
    }

    /**
     * To log the debug messages of an application
     *
     * @param message
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * To log the info of an application
     *
     * @param message
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     * To log the warning messages of an application
     *
     * @param message
     */
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * To log the exception and error messages of an application
     *
     * @param message
     * @param exception
     */
    public void error(String message, Exception exception) {
        logger.error(message, exception);
    }

    /**
     * To log the fatal exceptions and messages of an application
     *
     * @param message
     * @param exception
     */
    public void fatal(String message, Exception exception) {
        logger.fatal(message, exception);
    }
}