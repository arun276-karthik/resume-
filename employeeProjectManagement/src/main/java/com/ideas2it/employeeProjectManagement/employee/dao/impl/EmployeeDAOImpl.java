/**
 * DAO package contains DAO pattern which is used to separate low level data
 * accessing API or operations from high level business services.
 */
package com.ideas2it.employeeProjectManagement.employee.dao.impl;

import java.util.List;


import com.ideas2it.employeeProjectManagement.util.constants.Constants;

import com.ideas2it.employeeProjectManagement.util.logger.EmployeeProjectManagementLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;
import com.ideas2it.employeeProjectManagement.dataBaseConnection.DBConnection;
import com.ideas2it.employeeProjectManagement.employee.dao.EmployeeDAO;
import com.ideas2it.employeeProjectManagement.employee.model.Employee;

/**
 * Employee DAO implementation class which implements the low level data
 * accessing API or operations from the data source .This DAO class
 * provides CRUD database operations for the table employee in the database
 *
 * @author AK
 * @version 1.0
 * @since 10-02-2021
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    EmployeeProjectManagementLogger employeeProjectManagementLogger = new  EmployeeProjectManagementLogger(EmployeeDAOImpl.class.getName());

    //Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());
    /**
     * Insert Employee Details method which inserts the values in the employee
     * table with the auto increment of employee Id.
     *
     * @param employee to get the values from the Employee
     */
    public int createEmployeeDetails(Employee employee) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        int employeeId = 0;
        try {
            transaction = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            transaction.commit();
            return employeeId;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            //exception.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ADD_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_ADD_EMPLOYEE);
        } finally {
            session.close();
        }
    }

    /**
     * If employee detail is deleted then true is returned
     *
     * @param employeeId it is the employee id to delete delete details for
     * @return boolean
     */
    public boolean deleteEmployee(int employeeId) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            session.delete(employee);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            employeeProjectManagementLogger.error(Constants.EXCEPTION_DELETE_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_DELETE_EMPLOYEE);
        } finally {
            session.close();
        }
    }

    /**
     * @param employee the employee details to update
     * @return boolean
     */
    public boolean isUpdateEmployeeDetails(Employee employee) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            //e.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_UPDATE_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_UPDATE_EMPLOYEE);
        } finally {
            session.close();
        }
    }

    /**
     * view Employee Detail which get the data from resource and sets to Employee
     * model for an employee Id
     *
     * @param employeeId the details of this employee id is displayed
     * @return employee details for an id
     */
    public Employee getEmployeeDetails(int employeeId) throws EmployeeProjectManagementException {
        Employee employee = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, employeeId);
            transaction.commit();
            return employee;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWDETAIL_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_VIEWDETAIL_EMPLOYEE);
        } finally {
            session.close();
        }
    }

    /**
     * View Employee Details list which got from resource
     *
     * @return employee details List for an id
     */
    public List<Employee> getEmployeeList() throws EmployeeProjectManagementException {
        List<Employee> employees = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            transaction.commit();
            return employees;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWLIST_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_VIEWLIST_EMPLOYEE);
        } finally {
            session.close();
        }
    }

    /**
     * This method assigns the projects to employeeId an send the boolean
     *
     * @return boolean
     */
    public boolean projectAssign(Employee employee) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            if (null != transaction) {
                transaction.rollback();
            }
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ASSSIGN_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_ASSSIGN_EMPLOYEE);
        } finally {
            session.close();
        }
    }
}