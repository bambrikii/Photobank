package org.bambrikii.site.base.dao;

import java.util.List;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class LanguageDAO extends DAOBase<Language> implements ILanguageDAO {
	public LanguageDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.dao.ILanguageDAO#getList(java.lang.Boolean, java.lang.String)
	 */
	@Override
	public List<Language> getList(Boolean active, String order) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("active", active));
		setOrder(criteria, order);
		return criteria.list();
	}
}
