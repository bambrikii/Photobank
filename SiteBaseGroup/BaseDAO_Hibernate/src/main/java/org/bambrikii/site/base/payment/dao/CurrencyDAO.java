package org.bambrikii.site.base.payment.dao;

import java.util.List;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CurrencyDAO extends DAOBase<Currency> implements ICurrencyDAO {
	public CurrencyDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.payment.dao.ICurrencyDAO#getList(java.lang.Boolean)
	 */
	@Override
	public List<Currency> getList(Boolean activeOnly) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.addOrder(Order.asc("order"));
		if (activeOnly) {
			criteria.add(Restrictions.eq("active", activeOnly));
		}
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.payment.dao.ICurrencyDAO#getByCode(java.lang.String)
	 */
	@Override
	public Currency getByCode(String code) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("active", true));
		criteria.add(Restrictions.eq("code", code));
		return (Currency) criteria.uniqueResult();
	}
}
