package org.bambrikii.photobank.payment.dao;

import java.util.List;

import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PhotoOrderItemDAO extends DAOBase<PhotoOrderItem> {

	public PhotoOrderItemDAO(PersistenceConnector connector) {
		super(connector);
	}

	protected Criteria getItemsCriteria(PhotoOrder order) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("order", order));
		return criteria;
	}

	public int getCount(PhotoOrder order) {
		Criteria criteria = getItemsCriteria(order);
		return getCount(criteria);
	}

	public List<PhotoOrderItem> getList(PhotoOrder order, String sortOrder,
			int start, int length) {
		Criteria criteria = getItemsCriteria(order);
		return getList(criteria, sortOrder, start, length);
	}

	public PhotoOrderItem getItem(Integer orderItemId, Integer userId) {
		Criteria crit = getCriteria();
		crit.add(Restrictions.eq("id", orderItemId));
		crit.createAlias("order", "ordr1");
		crit.add(Restrictions.eq("ordr1.status", OrderStatusEnum.APPROVED));
		crit.createAlias("ordr1.client", "clnt1");
		crit.add(Restrictions.eq("clnt1.id", userId));
		return (PhotoOrderItem) crit.uniqueResult();
	}
}
