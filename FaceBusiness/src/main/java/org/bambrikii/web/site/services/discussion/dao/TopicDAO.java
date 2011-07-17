package org.bambrikii.web.site.services.discussion.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.bambrikii.web.site.services.discussion.model.Topic;

public class TopicDAO extends DAOBase<Topic> {
	public TopicDAO(PersistenceConnector connector) {
		super(connector);
	}
}
