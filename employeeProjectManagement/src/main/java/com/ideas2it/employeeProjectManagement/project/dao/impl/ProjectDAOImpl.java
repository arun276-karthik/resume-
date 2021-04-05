/**
 * This DAO package contains this ProjectDAOimpl class
 */
package com.ideas2it.employeeProjectManagement.project.dao.impl;

import java.util.List;

import com.ideas2it.employeeProjectManagement.util.constants.Constants;
import com.ideas2it.employeeProjectManagement.util.exception.EmployeeProjectManagementException;
import com.ideas2it.employeeProjectManagement.util.logger.EmployeeProjectManagementLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.employeeProjectManagement.dataBaseConnection.DBConnection;
import com.ideas2it.employeeProjectManagement.project.dao.ProjectDAO;
import com.ideas2it.employeeProjectManagement.project.model.Project;



/**
 * ProjectDAOimpl class which implements the projectdao interface which
 * performs the connectivity of business logic to the low level process ofdatabase connection
 *
 * @author   AK
 * @since    14-02-2021
 * @version  1.0
 */
public class ProjectDAOImpl implements ProjectDAO {

    EmployeeProjectManagementLogger employeeProjectManagementLogger = new  EmployeeProjectManagementLogger(ProjectDAOImpl.class.getName());

    /**
     * Insert Project Details method which inserts the values in the projects
     * table with the auto increment of project Id.
     *
     * @param  project       to get the values from the
     */
    public int createProjectDetails(Project project) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            projectId = (Integer) session.save(project);
            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) transaction.rollback();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_ADD_EMPLOYEE, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_ADD_PROJECT);
        } finally {
            session.close();
            return projectId;
        }
    }

    /**
     * If project detail is deleted then true is returned
     *
     * @param projectId      it is the projectid to delete details of project
     * @return               boolean
     */
    public boolean deleteProject(int projectId) throws EmployeeProjectManagementException {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            session.delete(project);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            if (null != transaction) transaction.rollback();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_DELETE_PROJECT, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_DELETE_PROJECT);
        } finally {
            session.close();
        }
    }

    /**
     * To update the project Details
     *
     * @param project        the project details to update
     * @return               boolean
     */
    public boolean isUpdateProjectDetails(Project project) throws EmployeeProjectManagementException {
        //Project  updateProjectDetail = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction!=null) transaction.rollback();
            //e.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_UPDATE_PROJECT, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_UPDATE_PROJECT);
        } finally {
            session.close();
        }
    }

    /**
     * view project Detail which get the data from resource and sets to Project
     * model for an project Id
     *
     * @param projectId     the details of this project id is displayed
     * @return               project details for an id
     */
    public Project getProjectDetails(int projectId) throws EmployeeProjectManagementException {
        Project project = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            project = session.get(Project.class, projectId);
            transaction.commit();

        } catch (HibernateException exception) {
            if (null != transaction) transaction.rollback();
            //e.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWDETAIL_PROJECT, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_VIEWDETAIL_PROJECT);
        } finally {
            session.close();
            return project;
        }
    }

    /**
     * View project Details list which got from resource
     *
     * @return               project details List for an id
     */
    public List<Project> getProjectList() throws EmployeeProjectManagementException{
        List<Project> project = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            project = session.createQuery("FROM Project").list();
            transaction.commit();
        } catch (HibernateException exception) {
            if (null != transaction)
                transaction.rollback();
            //e.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWLIST_PROJECT, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_VIEWLIST_PROJECT);
        } finally {
            session.close();
            return project;
        }
    }

    /**
     * @param projectId  projectId
     */
    public Project employeeProjectDetails(int projectId) throws EmployeeProjectManagementException {
        Project  project= null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            project= session.get(Project.class, projectId);
            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) transaction.rollback();
            //e.printStackTrace();
            employeeProjectManagementLogger.error(Constants.EXCEPTION_VIEWDETAIL_PROJECT, exception);
            throw new EmployeeProjectManagementException(Constants.EXCEPTION_VIEWDETAIL_PROJECT);
        } finally {
            session.close();
            return project;
        }
    }
}


