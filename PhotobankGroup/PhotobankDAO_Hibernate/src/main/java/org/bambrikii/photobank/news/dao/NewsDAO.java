package org.bambrikii.photobank.news.dao;

import java.util.List;

import org.bambrikii.photobank.news.model.News;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;

public class NewsDAO extends DAOBase<News> {
	public NewsDAO(PersistenceConnector connector) {
		super(connector);
	}

	public Integer getCount() {
		Criteria criteria = getCriteria();
		return getCount(criteria);
	}

	public List<News> getList(String sortOrder, Integer start, Integer length) {
		Criteria criteria = getCriteria();
		setOrder(criteria, sortOrder);
		setLimit(criteria, start, length);
		return criteria.list();
	}
}
