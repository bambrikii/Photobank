package org.bambrikii.site.base.auth.dao;

import org.bambrikii.site.base.auth.model.Group;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class GroupDAO extends DAOBase<Group> implements IGroupDAO {

	public GroupDAO(PersistenceConnector connector) {
		super(connector);
	}

}
