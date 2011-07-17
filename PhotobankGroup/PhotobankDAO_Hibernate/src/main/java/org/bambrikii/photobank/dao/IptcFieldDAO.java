package org.bambrikii.photobank.dao;

import org.bambrikii.photobank.model.IptcField;
import org.bambrikii.photobank.model.IptcGroup;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class IptcFieldDAO extends DAOBase<IptcField> implements IIpticFieldDAO {

	public IptcFieldDAO(PersistenceConnector connector) {
		super(connector);
	}
}
