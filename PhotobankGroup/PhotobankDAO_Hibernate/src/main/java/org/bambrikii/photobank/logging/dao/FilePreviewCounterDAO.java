package org.bambrikii.photobank.logging.dao;

import org.bambrikii.photobank.logging.model.FilePreviewCounter;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class FilePreviewCounterDAO extends DAOBase<FilePreviewCounter> {

	public FilePreviewCounterDAO(PersistenceConnector connector) {
		super(connector);
	}
}
