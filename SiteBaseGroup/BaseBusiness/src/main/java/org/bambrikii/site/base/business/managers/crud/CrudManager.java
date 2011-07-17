package org.bambrikii.site.base.business.managers.crud;

import org.bambrikii.site.base.business.managers.core.ManagerException;

public interface CrudManager<T> {
	public T getById(Integer id) throws ManagerException;

	public void saveOrUpdate(T obj) throws ManagerException;

	public void delete(T obj) throws ManagerException;
}
