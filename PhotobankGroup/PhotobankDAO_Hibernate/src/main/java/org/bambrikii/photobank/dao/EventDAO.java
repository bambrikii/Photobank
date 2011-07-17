package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class EventDAO extends DAOBase<Event> implements IEventDAO {

	public EventDAO(PersistenceConnector connector) {
		super(connector);
	}

	protected Criteria getEventCriteria(Category parentCategory) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("parent", parentCategory));
		criteria.add(Restrictions.eq("active", true));
		return criteria;
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.IEventDAO#getEvents(org.bambrikii.photobank.model.Category, java.lang.String, int, int)
	 */
	@Override
	public List<Event> getEvents(Category parentCategory, String order, int start,
			int length) {
		Criteria criteria = getEventCriteria(parentCategory);
		return getList(criteria, order, start, length);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.IEventDAO#getEventCount(org.bambrikii.photobank.model.Category)
	 */
	@Override
	public int getEventCount(Category parentCategory) {
		Criteria criteria = getEventCriteria(parentCategory);
		return getCount(criteria);
	}
}
