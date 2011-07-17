package org.bambrikii.site.base.logging.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.logging.model.Counter;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class CounterDAO extends DAOBase<Counter> implements ICounterDAO {

	public CounterDAO(PersistenceConnector connector) {
		super(connector);
	}
}
