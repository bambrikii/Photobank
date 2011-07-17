package org.bambrikii.photobank.business.managers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.dao.EventDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;

public class EventManager extends ManagerBase<Event, EventDAO> {
	public EventManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		new CategoryDAO(connector.getPersistenceConnector());
	}

	public Event getById(int id) {
		return dao.getById(id);
	}

	public Pager<Event> getEventPager(Category parentCategory,
			Pager<Event> pager) {
		pager.setTotalRecordsCount(dao.getEventCount(parentCategory));
		pager.setRecords(dao.getEvents(parentCategory,
				"insertionTime DESC, modificationTime DESC", pager.getStart(),
				pager.getLength()));
		return pager;
	}

	public void saveOrUpdate(Event event) {
		Date currentTime = Calendar.getInstance().getTime();
		event.setModificationTime(currentTime);
		dao.saveOrUpdate(event);
	}

	public void delete(Event event) {
		dao.delete(event);
	}

	public List<Event> getEventsList(Category parentCategory, String order,
			Integer maxRecordsCount) {
		return dao.getEvents(parentCategory, order, 0, maxRecordsCount);
	}
}
