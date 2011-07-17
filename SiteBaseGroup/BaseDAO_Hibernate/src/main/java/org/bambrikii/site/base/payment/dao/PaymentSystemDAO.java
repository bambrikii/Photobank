package org.bambrikii.site.base.payment.dao;

import java.util.List;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.payment.model.PaymentSystemStatusEnum;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PaymentSystemDAO extends DAOBase<PaymentSystem> implements IPaymentSystemDAO {

	public PaymentSystemDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.payment.dao.IPaymentSystemDAO#getByName(java.lang.String)
	 */
	@Override
	public PaymentSystem getByName(String name) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("name", name));
		return (PaymentSystem) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.payment.dao.IPaymentSystemDAO#getList(org.bambrikii.site.base.payment.model.PaymentSystemStatusEnum, java.lang.String)
	 */
	@Override
	public List<PaymentSystem> getList(PaymentSystemStatusEnum status,
			String order) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("status", status));
		setOrder(criteria, order);
		return getList(criteria, order, 0, 0);
	}
}
