/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bambrikii.site.base.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 * 
 * @author asd
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final Session session;

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return session;
	}
}
