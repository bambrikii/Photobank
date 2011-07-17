package org.bambrikii.photobank.business.managers;

import java.util.Calendar;

import org.bambrikii.photobank.logging.dao.FilePreviewCounterDAO;
import org.bambrikii.photobank.logging.model.FilePreviewCounter;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.logging.dao.CounterDAO;
import org.bambrikii.site.base.logging.model.Counter;

public class CounterManager extends ManagerBase<Counter, CounterDAO> {

	private FilePreviewCounterDAO filePreviewCounterDao;

	public CounterManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		filePreviewCounterDao = new FilePreviewCounterDAO(
				connector.getPersistenceConnector());
	}

	public FilePreviewCounter countFilePreview(File file) {
		FilePreviewCounter fpc = new FilePreviewCounter();
		fpc.setTime(Calendar.getInstance().getTime());
		fpc.setFile(file);
		filePreviewCounterDao.saveOrUpdate(fpc);
		return fpc;
	}

}
