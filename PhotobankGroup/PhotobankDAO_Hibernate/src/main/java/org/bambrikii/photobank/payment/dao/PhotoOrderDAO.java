package org.bambrikii.photobank.payment.dao;

import java.util.List;

import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class PhotoOrderDAO extends DAOBase<PhotoOrder> {

	public PhotoOrderDAO(PersistenceConnector connector) {
		super(connector);
	}

	public List<PhotoOrder> getOrders(User user, OrderStatusEnum orderStatus,
			String sortOrder) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("client", user));
		criteria.add(Restrictions.eq("status", orderStatus));
		setOrder(criteria, sortOrder);
		return criteria.list();
	}

	protected Criteria getOrdersCriteria(User user, List<OrderStatusEnum> status) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		if (user != null) {
			criteria.add(Restrictions.eq("client", user));
		}
		if (status != null && status.size() > 0) {
			criteria.add(Restrictions.in("status", status));
		}
		return criteria;
	}

	public Integer getCount(User user, List<OrderStatusEnum> status) {
		Criteria criteria = getOrdersCriteria(user, status);
		return getCount(criteria);
	}

	public List<PhotoOrder> getList(User user, List<OrderStatusEnum> status,
			String order, Integer start, Integer length) {
		Criteria criteria = getOrdersCriteria(user, status);
		setLimit(criteria, start, length);
		setOrder(criteria, order);
		return criteria.list();
	}

	public List<Object[]> getBaskets(User user, Currency currency,
			Integer start, Integer length) {
		Query q1 = getConnector().getSession().createQuery(
				"select " + "		o1, " + "		curr1, " + "		sum(pr1.value) "
						+ "	from" + "		PhotoOrder o1"
						+ "		inner join o1.items i1 "
						+ "		inner join i1.dimension dim1 "
						+ "		inner join dim1.prices pr1 "
						+ "		inner join pr1.currency curr1 "
						+ "	where o1.client	= :user "
						+ "		and curr1 = :currency " + "	group by " + "		o1, "
						+ "		curr1 " + "	order by o1.modificationTime DESC ");
		q1.setParameter("user", user);
		q1.setParameter("currency", currency);
		q1.setFirstResult(start);
		q1.setMaxResults(length);
		return q1.list();
	}

	public List<Object[]> getBasketItems(User user, Currency currency,
			Integer start, Integer length) {
		Query q1 = getConnector().getSession().createQuery(
				"select " + "		o1, " + "		i1, " + "		dim1, " + "		pr1 "
						+ "	from " + "		PhotoOrder o1 "
						+ "		inner join o1.items i1 "
						+ "		inner join i1.dimension dim1 "
						+ "		inner join dim1.prices pr1 "
						+ "		inner join pr1.currency curr1 "
						+ "	where o1.client = :user "
						+ "		and curr1 = :currency "
						+ "		and o1.status = :status "
						+ "	order by i1.id DESC ");
		q1.setParameter("user", user);
		q1.setParameter("currency", currency);
		q1.setParameter("status", OrderStatusEnum.NEW);
		q1.setFirstResult(start);
		q1.setMaxResults(length);
		return q1.list();
	}

	public List<Object[]> getBasketSummary(PhotoOrder order) {
		Query query = getConnector().getSession().createQuery(
				"select " + "		curr1 as currency, "
						+ "		sum(pr1.value) as totalPrice " + "	from "
						+ "		PhotoOrder o1 " + "		inner join o1.items i1 "
						+ "		inner join i1.dimension dim1 "
						+ "		inner join dim1.prices pr1 "
						+ "		inner join pr1.currency curr1 "
						+ "	where o1 = :order " + "	group by " + "		curr1 "
						+ "	order by curr1.order ");
		query.setParameter("order", order);
		return query.list();
	}
}
