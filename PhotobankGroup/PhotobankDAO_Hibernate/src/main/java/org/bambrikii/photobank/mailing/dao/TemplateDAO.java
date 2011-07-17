package org.bambrikii.photobank.mailing.dao;

import org.bambrikii.photobank.mailing.model.Template;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class TemplateDAO extends DAOBase<Template> {
	public TemplateDAO(PersistenceConnector connector) {
		super(connector);
	}

	public Template getByKey(String key) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("key", key));
		return (Template) criteria.uniqueResult();
	}
}
