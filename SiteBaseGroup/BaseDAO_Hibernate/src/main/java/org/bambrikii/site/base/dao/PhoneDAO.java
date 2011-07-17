package org.bambrikii.site.base.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.model.Phone;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class PhoneDAO extends DAOBase<Phone> implements IPhoneDAO {

	public PhoneDAO(PersistenceConnector connector) {
		super(connector);
	}

}
