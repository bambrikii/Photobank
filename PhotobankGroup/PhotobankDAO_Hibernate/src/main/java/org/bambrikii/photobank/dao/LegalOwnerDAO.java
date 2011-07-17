package org.bambrikii.photobank.dao;

import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class LegalOwnerDAO extends DAOBase<LegalOwner> implements ILegalOwnerDAO {

	public LegalOwnerDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.ILegalOwnerDAO#getByName(java.lang.String)
	 */
	@Override
	public LegalOwner getByName(String name) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("name", name));
		return (LegalOwner) criteria.uniqueResult();
	}
}
