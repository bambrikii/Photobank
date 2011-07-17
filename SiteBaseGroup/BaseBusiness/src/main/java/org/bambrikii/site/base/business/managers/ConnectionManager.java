package org.bambrikii.site.base.business.managers;

import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.bambrikii.site.base.persistence.PersistenceException;

public class ConnectionManager {
	private PersistenceConnector _persistenceConnector;

	public PersistenceConnector getPersistenceConnector() {
		return _persistenceConnector;
	}

	public void open() {
		if (_persistenceConnector == null) {
			_persistenceConnector = new PersistenceConnector();
		}
		_persistenceConnector.openSession();
	}

	public void close() {
		_persistenceConnector.closeSession();
		_persistenceConnector = null;
	}

	public void begin() throws ManagerException {
		try {
			_persistenceConnector.beginTransaction();
		} catch (PersistenceException ex) {
			throw new ManagerException("Cannot begin transaction", ex);
		}
	}

	public void commit() {
		_persistenceConnector.commitTransaction();
	}

	public void rollback() {
		_persistenceConnector.rollbackTransaction();
	}

}
