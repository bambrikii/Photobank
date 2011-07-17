package org.bambrikii.site.base.business.managers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.managers.crud.CrudManager;
import org.bambrikii.site.base.core.dao.IDAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class ManagerBase<T, DAOBaseT extends IDAOBase<T>> implements
		CrudManager<T> {
	protected DAOBaseT dao;
	protected ConnectionManager connector;

	@SuppressWarnings("unchecked")
	public ManagerBase(ConnectionManager connector) throws ManagerException {
		this.connector = connector;
		Class<?> daoClass = (Class<?>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];

		try {
			Constructor<?> constructor = daoClass
					.getConstructor(new Class[] { PersistenceConnector.class });
			dao = (DAOBaseT) constructor.newInstance(new Object[] { connector
					.getPersistenceConnector() });
		} catch (InstantiationException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		} catch (IllegalAccessException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		} catch (SecurityException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		} catch (NoSuchMethodException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		} catch (IllegalArgumentException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		} catch (InvocationTargetException ex) {
			throw new ManagerException(
					"Cannot instantiate DAO class in Manager", ex);
		}
	}

	public void saveOrUpdate(T obj) throws ManagerException {
		dao.saveOrUpdate(obj);
	}

	public void delete(T obj) throws ManagerException {
		dao.delete(obj);
	}

	public T getById(Integer id) throws ManagerException {
		return (T) dao.getById(id);
	}
}
