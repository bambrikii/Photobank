package org.bambrikii.site.base.core.dao;

import java.util.List;
import java.util.Set;

import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DAOBase<T> implements IDAOBase<T> {

	private PersistenceConnector _connector;
	protected Class<T> persistentClass;

	public DAOBase(PersistenceConnector connector) {
		evalPersistenceClass();
		_connector = connector;
	}

	public PersistenceConnector getConnector() {
		return _connector;
	}

	private void evalPersistenceClass() {
		persistentClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#saveOrUpdate(T)
	 */
	@Override
	public void saveOrUpdate(T obj) {
		_connector.getSession().saveOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#delete(T)
	 */
	@Override
	public void delete(T obj) {
		_connector.getSession().delete(obj);
	}

	public void refresh(T obj) {
		_connector.getSession().refresh(obj);
	}

	public void merge(T obj) {
		_connector.getSession().merge(obj);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#getList()
	 */
	@Override
	public List<T> getList() {
		return getList(null);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#getList(java.lang.String)
	 */
	@Override
	public List<T> getList(String order) {
		return getList(order, 0, 0);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#getList(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<T> getList(String order, Integer start, Integer length) {
		Criteria crit1 = _connector.getSession()
				.createCriteria(persistentClass);
		return getList(crit1, order, start, length);
	}

	protected List<T> getList(Criteria criteria, String order, Integer start,
			Integer length) {
		setOrder(criteria, order);
		setLimit(criteria, start, length);
		return criteria.list();
	}

	public void setOrder(Criteria criteria, String order) {
		if (order != null && order != "") {
			String[] order1 = order.split("\\s*,\\s*", 0);
			for (String order2 : order1) {
				String[] order3 = order2.trim().split(" ");
				if (order3.length > 0) {
					String orderName = order3[0].trim();
					if (orderName != null) {
						if (order3.length > 1
								&& "DESC".equals(order3[1].trim())) {
							criteria.addOrder(Order.desc(orderName));
						} else {
							criteria.addOrder(Order.asc(orderName));
						}
					}
				}
			}
		}
	}

	public void setLimit(Criteria criteria, Integer start, Integer length) {
		if (start != null && start != 0) {
			criteria.setFirstResult(start);
		}
		if (length != null && length != 0) {
			criteria.setMaxResults(length);
		}
	}

	protected Integer getCount(Criteria criteria) {
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#getById(java.lang.Integer)
	 */
	@Override
	public T getById(Integer id) {
		T obj = (T) _connector.getSession().createCriteria(persistentClass)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return obj;
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.core.dao.IDAOBase#getByIds(java.util.Set)
	 */
	@Override
	public List<T> getByIds(Set<Integer> ids) {
		Criteria criteria = _connector.getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	public Criteria getCriteria() {
		return getConnector().getSession().createCriteria(persistentClass);
	}
}
