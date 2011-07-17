package org.bambrikii.site.base.logging.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.logging.model.Source;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class SourceDAO extends DAOBase<Source> implements ISourceDAO {

	public SourceDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.logging.dao.ISourceDAO#getByName(java.lang.String)
	 */
	@Override
	public Source getByName(String name) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Source) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.logging.dao.ISourceDAO#checkSource(java.lang.String)
	 */
	@Override
	public Source checkSource(String name) {
		Source source = getByName(name);
		if (source == null) {
			source = new Source();
			source.setName(name);
			saveOrUpdate(source);
		}
		return source;
	}
}
