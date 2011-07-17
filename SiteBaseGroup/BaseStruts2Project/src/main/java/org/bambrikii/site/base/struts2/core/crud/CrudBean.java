package org.bambrikii.site.base.struts2.core.crud;

import org.bambrikii.site.base.struts2.core.WebException;

public interface CrudBean<T> {
	public T getById(Integer id) throws WebException;

	public void saveOrUpdate(T obj) throws WebException;

	public void delete(T obj) throws WebException;
}
