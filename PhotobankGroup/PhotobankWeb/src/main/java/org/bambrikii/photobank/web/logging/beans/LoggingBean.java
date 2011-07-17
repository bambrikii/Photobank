package org.bambrikii.photobank.web.logging.beans;

import java.text.MessageFormat;

import org.bambrikii.photobank.business.managers.CounterManager;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.LoggingManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.logging.model.LogLevelEnum;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;

public class LoggingBean extends SiteBaseBean {
	private void log(String name, String text, LogLevelEnum level, String source)
			throws ManagerException {
		getContainer().begin();
		try {
			LoggingManager mgr = (LoggingManager) getContainer().getManager(
					LoggingManager.class);
			mgr.log(name, text, level, source);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void logInfo(String name, String text, String source)
			throws ManagerException {
		log(name, text, LogLevelEnum.INFO, source);
	}

	public void logWarning(String name, String text, String source)
			throws ManagerException {
		log(name, text, LogLevelEnum.WARNING, source);
	}

	public void logError(String name, String text, Exception ex, String source)
			throws ManagerException {
		log(name, MessageFormat.format("{0}\n---\nException:\n{1}", text,
				getFormattedStackTrace(ex)), LogLevelEnum.ERROR, source);
	}

	public static String getFormattedStackTrace(Exception ex) {
		if (ex != null) {
			StringBuilder result = new StringBuilder();
			result.append(ex.getMessage());
			result.append("\n");
			if (ex.getStackTrace() != null) {
				for (StackTraceElement element : ex.getStackTrace()) {
					result.append(element);
					result.append("\n");
				}
			}
			return result.toString();
		} else {
			return "No stack trace.";
		}
	}

	public void countFilePreview(File file) throws ManagerException {
		getContainer().begin();
		try {
			CounterManager counterMgr = (CounterManager) getContainer()
					.getManager(CounterManager.class);
			counterMgr.countFilePreview(file);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

}
