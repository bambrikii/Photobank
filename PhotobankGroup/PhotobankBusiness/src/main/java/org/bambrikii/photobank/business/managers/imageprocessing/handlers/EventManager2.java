package org.bambrikii.photobank.business.managers.imageprocessing.handlers;

import java.util.Date;
import java.util.List;

import org.bambrikii.photobank.dao.EventDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class EventManager2 extends ManagerBase<Event, EventDAO> {

	public EventManager2(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	@SuppressWarnings("unchecked")
	public List<Event> getList(String description, String text, Date date,
			Category baseCateg, String order, Integer maxRecordsCount) {
		Criteria crit = dao.getCriteria();
		crit.add(Restrictions.eq("description", description));
		crit.add(Restrictions.eq("text", text));
		crit.add(Restrictions.eq("parent", baseCateg));
		crit.add(Restrictions.eq("active", true));
		crit.add(Restrictions.eq("insertionTime", date));
		dao.setOrder(crit, order);
		dao.setLimit(crit, 0, maxRecordsCount);
		return crit.list();
	}
}
