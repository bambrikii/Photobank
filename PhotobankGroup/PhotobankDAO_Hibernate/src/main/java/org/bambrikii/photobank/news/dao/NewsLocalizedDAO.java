package org.bambrikii.photobank.news.dao;

import org.bambrikii.photobank.news.model.NewsLocalized;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class NewsLocalizedDAO extends DAOBase<NewsLocalized> {

	public NewsLocalizedDAO(PersistenceConnector connector) {
		super(connector);
	}
}
