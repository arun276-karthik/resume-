/**
 * DAO package contains DAO pattern which is used to separate low level data
 * accessing API or operations from high level business services.
 */
package com.ideas2it.employeeProjectManagement.employee.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    /**
     * Insert Employee Details method which inserts the values in the employee
     * table with the auto increment of employee Id.
     *
     * @param employee to get the values from the Employee
     */
    public int createEmployeeDetails(Employee employee) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        int employeeId = 0;

        try {
            transaction = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return employeeId;
        }
    }

    /**
     * If employee detail is deleted then true is returned
     *
     * @param employeeId it is the employee id to delete delete details for
     * @return boolean
     */
    public boolean deleteEmployee(int employeeId) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeId);
            session.delete(employee);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    /**
     * @param employee the employee details to update
     * @return boolean
     */
    public boolean isUpdateEmployeeDetails(Employee employee) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
			/*Employee updateEmployeeDetail = (Employee)session.get(Employee.class, employee.getEmployeeId());
			updateEmployeeDetail.setFirstName(employee.getFirstName());
			updateEmployeeDetail.setSecondName(employee.getSecondName());
			updateEmployeeDetail.setDesignation(employee.getDesignation());
			updateEmployeeDetail.setSalary(employee.getSalary());
			updateEmployeeDetail.setEmailId(employee.getEmailId());
			updateEmployeeDetail.setDateOfBirth(employee.getDateOfBirth());
			updateEmployeeDetail.setPhoneNumber(employee.getPhoneNumber());
			*/
            session.update(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
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
     * @param employeeId the details of this employee id is displayed
     * @return employee details for an id
     */
    public Employee viewEmployeeDetails(int employeeId) {
        Employee employee = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            employee = (Employee) session.get(Employee.class, employeeId);
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return employee;
        }
    }

    /**
     * View Employee Details list which got from resource
     *
     * @return employee details List for an id
     */
    public List<Employee> viewEmployeeList() {
        List<Employee> employees = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return employees;
        }
    }

    /**
     * This method assigns the projects to employeeId an send the boolean
     *
     * @return boolean
     */
    public boolean projectAssign(Employee employee) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    /**
     * This method removes the project for employeeId
     *
     * @return boolean
     */
    public boolean isProjectRemove(Employee employee) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (null != transaction)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
