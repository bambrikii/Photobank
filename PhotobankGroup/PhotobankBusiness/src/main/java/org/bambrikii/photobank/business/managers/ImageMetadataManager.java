package org.bambrikii.photobank.business.managers;

import org.bambrikii.photobank.dao.IIpticFieldDAO;
import org.bambrikii.photobank.dao.IptcFieldDAO;
import org.bambrikii.photobank.dao.IptcGroupDAO;
import org.bambrikii.photobank.model.IptcField;
import org.bambrikii.photobank.model.IptcGroup;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class ImageMetadataManager extends ManagerBase<IptcGroup, IptcGroupDAO> {
	private IptcFieldDAO iptcFieldDao;

	public ImageMetadataManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
		setIptcFieldDao(new IptcFieldDAO(connector.getPersistenceConnector()));
	}

	private void setIptcFieldDao(IptcFieldDAO iptcFieldDao) {
		this.iptcFieldDao = iptcFieldDao;
	}

	protected IIpticFieldDAO getIptcFieldDao() {
		return iptcFieldDao;
	}

	public void saveOrUpdateIptcGroup(IptcGroup group) {
		dao.saveOrUpdate(group);
	}

	public void saveOrUpdateIptcField(IptcField field) {
		iptcFieldDao.saveOrUpdate(field);
	}
}
