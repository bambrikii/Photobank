package org.bambrikii.site.base.logging.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.logging.model.Log;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class LogDAO extends DAOBase<Log> implements ILogDAO {

	public LogDAO(PersistenceConnector connector) {
		super(connector);
	}
}
