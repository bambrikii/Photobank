package org.bambrikii.site.base.business.managers;

import java.util.Calendar;

import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.logging.dao.ISourceDAO;
import org.bambrikii.site.base.logging.dao.LogDAO;
import org.bambrikii.site.base.logging.dao.SourceDAO;
import org.bambrikii.site.base.logging.model.Log;
import org.bambrikii.site.base.logging.model.LogLevelEnum;

public class LoggingManager extends ManagerBase<Log, LogDAO> {

	private ISourceDAO sourceDao;

	public LoggingManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		sourceDao = new SourceDAO(connector.getPersistenceConnector());
	}

	public void log(String name, String text, LogLevelEnum level, String source) {
		Log log = new Log();
		log.setName(name);
		log.setText(text);
		log.setLevel(level);
		log.setSource(sourceDao.checkSource(source));
		log.setTime(Calendar.getInstance().getTime());
		dao.saveOrUpdate(log);
	}
}
