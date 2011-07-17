package org.bambrikii.site.base.struts2.core.crud;

import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.core.WebException;

public abstract class BaseCrudBean<T, M extends ManagerBase<T, ?>> extends
		SiteBaseBean implements CrudBean<T> {
	protected M getManager() throws ManagerException {
		Class<?> klz = (Class<?>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return (M) getContainer().getManager(klz);
	}

	public T getById(Integer id) throws WebException {
		try {
			return getManager().getById(id);
		} catch (ManagerException ex) {
			throw new WebException("Failed to get by id.", ex);
		}
	}

	public void saveOrUpdate(T obj) throws WebException {
		try {
			getContainer().begin();
			try {
				getManager().saveOrUpdate(obj);
				getContainer().commit();
			} catch (ManagerException ex) {
				getContainer().rollback();
				throw new WebException("Save or update failed.", ex);
			}
		} catch (ManagerException ex) {
			throw new WebException("Failed to begin transaction.", ex);
		}
	}

	public void delete(T obj) throws WebException {
		if (obj == null) {
			throw new WebException("No object to delete.");
		}
		try {
			getContainer().begin();
			try {
				getManager().delete(obj);
				getContainer().commit();
			} catch (ManagerException ex) {
				getContainer().rollback();
				throw new WebException("Delete failed.", ex);
			} catch (Exception ex) {
				getContainer().rollback();
				throw new WebException("Delete failed.", ex);
			}
		} catch (ManagerException ex) {
			throw new WebException("Failed to begin transaction.", ex);
		}
	}
}
