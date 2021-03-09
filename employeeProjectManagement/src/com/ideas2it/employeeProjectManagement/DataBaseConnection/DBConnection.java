/**
 * The DataBaseConnection package contains the hibernate utililty class
 */
package com.ideas2it.employeeProjectManagement.dataBaseConnection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class is a utility class
 * So it can be used in all application
 *
 * @author   AK
 * @since    19-02-2021
 * @version  1.0
 */
public class DBConnection{

    public static SessionFactory sessionFactory;

    private DBConnection() {}

    /**
     * To get the session factory for the application
     *
     * @return  sessionFactory
     * @throws  HibernateException
     */
    public static synchronized SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure("resources/properties/hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Exception e) {
            System.out.println("error in the connection" + e.getMessage());
            e.printStackTrace();
        }
        return sessionFactory;
    }
}

