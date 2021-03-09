/**
 * This DAO package contains this ProjectDAOimpl class
 */
package com.ideas2it.employeeProjectManagement.project.dao.impl;

import java.util.List;

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

    /**
     * Insert Project Details method which inserts the values in the projects
     * table with the auto increment of project Id.
     *
     * @param  project       to get the values from the
     */
    public int createProjectDetails(Project project) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;
        int projectId = 0;

        try {
            transaction = session.beginTransaction();
            projectId = (Integer) session.save(project);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
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
    public boolean deleteProject(int projectId) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Project project = (Project)session.get(Project.class, projectId);
            session.delete(project);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (null != transaction) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    /**
     * To update the project Details
     *
     * @param project        the project details to update
     * @return               boolean
     */
    public boolean isUpdateProjectDetails(Project project) {
        //Project  updateProjectDetail = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
			/*updateProjectDetail = (Project)session.get(Project.class, project.getProjectId());
			updateProjectDetail.setProjectName(project.getProjectName());
			updateProjectDetail.setProjectDueDate(project.getProjectDueDate());
			updateProjectDetail.setProjectManager(project.getProjectManager());
			*/
            session.update(project);
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
     * view project Detail which get the data from resource and sets to Project
     * model for an project Id
     *
     * @param projectId     the details of this project id is displayed
     * @return               project details for an id
     */
    public Project viewProjectDetails(int projectId) {
        Project project = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            project = (Project)session.get(Project.class, projectId);
            transaction.commit();

        } catch (HibernateException e) {
            if (null != transaction) transaction.rollback();
            e.printStackTrace();
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
    public List<Project> viewProjectList() {
        List<Project> project = null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            project = session.createQuery("FROM Project").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return project;
        }
    }

    /**
     * @param projectId  projectId
     */
    public Project employeeProjectDetails(int projectId) {
        Project  project= null;
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            project= (Project)session.get(Project.class, projectId);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return project;
        }
    }
}


