package org.bambrikii.photobank.tests.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.core.dao.IDAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.junit.After;
import org.junit.Before;

public abstract class DAOTestBase<DAOBaseT extends IDAOBase<?>> {
	protected PersistenceConnector cn = new PersistenceConnector();
	protected DAOBaseT dao;

	@Before
	public void before() throws DAOException {
		cn.openSession();
		Class<?> daoClass = (Class<?>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		try {
			Constructor<?> constructor = daoClass
					.getConstructor(new Class[] { PersistenceConnector.class });
			dao = (DAOBaseT) constructor.newInstance(new Object[] { cn });
		} catch (InstantiationException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		} catch (IllegalAccessException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		} catch (SecurityException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		} catch (NoSuchMethodException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		} catch (IllegalArgumentException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		} catch (InvocationTargetException ex) {
			throw new DAOException("Cannot instantiate DAO class in Manager",
					ex);
		}
	}

	@After
	public void after() {
		cn.closeSession();
	}

}
