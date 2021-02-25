/**
 * This DAO package contains this ProjectDAOimpl class
 */
package com.ideas2it.employeeProjectManagement.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.employeeProjectManagement.DataBaseConnection.DBConnection;
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
	 * @param  project       to get the values from the Project
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public int createProjectDetails(Project project) throws SQLException {
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
	 * @throws SQLException  to suppress the sql exception  
	 */
	@Override
	public boolean projectDelete(int projectId) throws SQLException {
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
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public boolean isUpdateProjectDetails(Project project) throws SQLException {
		Project  updateProjectDetail = null;
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			updateProjectDetail = (Project)session.get(Project.class, project.getProjectId()); 
			updateProjectDetail.setProjectName(project.getProjectName());
			updateProjectDetail.setProjectDueDate(project.getProjectDueDate());
			updateProjectDetail.setProjectManager(project.getProjectManager());
			session.update(updateProjectDetail); 
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
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public Project viewProjectDetails(int projectId) throws SQLException {
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
	 * @throws SQLException  to suppress the sql exception
	 */
	@Override
	public List<Project> viewProjectList() throws SQLException {
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
	 * To get the project Id list to display for employee 
	 * while entering details
	 * 
	 * @return               projectId list
	 * @throws SQLException  to suppress sqlException
	 */
	/*@Override
	/*public List<Project> showAvailableProjectId() throws SQLException {
		List<Project> project = null;
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			project = session.createQuery("SELECT Project.projecId FROM Project").list(); 
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction) 
				transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
			return project;
		}	      
	}*/
	
	/**
	 * @param project  projectId 
	 */
	@Override
	public Project employeeProjectDetails(int projectId) throws SQLException {
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


