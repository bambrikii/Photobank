package org.bambrikii.web.site.services.discussion.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.bambrikii.web.site.services.discussion.model.Message;

public class MessageDAO extends DAOBase<Message> {

	public MessageDAO(PersistenceConnector connector) {
		super(connector);
	}

}
