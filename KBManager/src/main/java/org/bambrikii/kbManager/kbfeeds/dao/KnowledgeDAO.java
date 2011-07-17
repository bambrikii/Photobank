package org.bambrikii.kbManager.kbfeeds.dao;

import org.bambrikii.kbManager.parser.model.Knowledge;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class KnowledgeDAO extends DAOBase<Knowledge> {
	public KnowledgeDAO(PersistenceConnector connector) {
		super(connector);
	}
}
