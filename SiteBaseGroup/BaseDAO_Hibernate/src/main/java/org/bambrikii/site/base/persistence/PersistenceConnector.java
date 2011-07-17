package org.bambrikii.site.base.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistenceConnector {
	private Session _session;
	private Transaction _transaction;

	public void openSession() {
		_session = HibernateUtil.getSessionFactory().openSession();
	}

	public void closeSession() {
		_session.close();
	}

	public Session getSession() {
		return _session;
	}

	public void beginTransaction() throws PersistenceException {
		if (_transaction != null) {
			throw new PersistenceException(
					"Close transaction before starting a new one!");
		}
		_transaction = _session.beginTransaction();
	}

	public void commitTransaction() {
		_transaction.commit();
		_transaction = null;
	}

	public void rollbackTransaction() {
		_transaction.rollback();
		_transaction = null;
		_session.close();
		_session = null;
		openSession();
	}
}
