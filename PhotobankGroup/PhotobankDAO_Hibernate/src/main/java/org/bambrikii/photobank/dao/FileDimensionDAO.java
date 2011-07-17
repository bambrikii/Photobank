package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FileDimensionDAO extends DAOBase<FileDimension> implements IFileDimensionDAO {

	public FileDimensionDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.IFileDimensionDAO#getList(java.lang.Boolean, java.lang.String)
	 */
	@Override
	public List<FileDimension> getList(Boolean active, String order) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("active", active));
		return getList(criteria, order, null, null);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.IFileDimensionDAO#getByName(java.lang.String)
	 */
	@Override
	public FileDimension getByName(String name) {
		Criteria criteria	= getCriteria();
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("active", true));
		return (FileDimension) criteria.uniqueResult();
	}
}
