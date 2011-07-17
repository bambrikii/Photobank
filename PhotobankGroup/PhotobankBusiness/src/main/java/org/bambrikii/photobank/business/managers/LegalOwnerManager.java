package org.bambrikii.photobank.business.managers;

import java.util.List;

import org.bambrikii.photobank.dao.LegalOwnerDAO;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class LegalOwnerManager extends ManagerBase<LegalOwner, LegalOwnerDAO> {
	public LegalOwnerManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
	}

	public LegalOwner getByName(String name) {
		return dao.getByName(name);
	}

	public List<LegalOwner> getList() {
		return dao.getList("id");
	}
}
