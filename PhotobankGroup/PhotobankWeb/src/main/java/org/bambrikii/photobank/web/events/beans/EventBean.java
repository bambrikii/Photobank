package org.bambrikii.photobank.web.events.beans;

import java.util.List;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudBean;

public class EventBean extends BaseCrudBean<Event, EventManager> {
	private static final String BRIEF_EVENTS_LIST_MAX_RECORDS_COUNT = ".ru.psfotos.events.briefListMaxRecordsCount";

	public Pager<Event> getEvents(Category category, int cols, int rows,
			int currPage) throws Exception {
		try {
			EventManager mgr = (EventManager) getContainer().getManager(
					EventManager.class);
			return mgr.getEventPager(category, new Pager<Event>(cols, rows,
					currPage));
		} catch (ManagerException ex) {
			throw new WebException("Cannot list categories", ex);
		}
	}

	public Category getCategory(Integer categoryId) throws WebException {
		try {
			CategoryManager mgr = (CategoryManager) getContainer().getManager(
					CategoryManager.class);
			Category category = mgr.getById(categoryId);
			return category;
		} catch (ManagerException ex) {
			throw new WebException("CategoryManager failed!", ex);
		}
	}

	public Event getEvent(Integer id) throws WebException {
		try {
			EventManager mgr = (EventManager) getContainer().getManager(
					EventManager.class);
			Event event = mgr.getById(id);
			return event;
		} catch (ManagerException ex) {
			throw new WebException("EventManager failed", ex);
		}
	}

	public Pager<File> getFiles(Event event, int currPage)
			throws ManagerException {
		FileManager mgr = (FileManager) getContainer().getManager(
				FileManager.class);
		Pager<File> filesPager = mgr.getFilesPager(event, currPage);
		return filesPager;
	}

	public List<File> getFiles(Event event) throws ManagerException {
		FileManager mgr = (FileManager) getContainer().getManager(
				FileManager.class);
		return mgr.getFiles(event, "modificationTime DESC");
	}

	public List<Category> getCategories(CategoryTypeEnum categoryType)
			throws WebException {
		try {
			CategoryManager mgr = (CategoryManager) getContainer().getManager(
					CategoryManager.class);
			List<Category> filesPager = mgr.getList(null, null, categoryType);
			return filesPager;
		} catch (ManagerException ex) {
			throw new WebException("CategoryManager failed", ex);
		}
	}

	public List<Event> getEventBriefList(Category categ)
			throws ManagerException {
		ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);
		Integer mx = Integer.parseInt(cfgMgr
				.getCacheConfigValue(BRIEF_EVENTS_LIST_MAX_RECORDS_COUNT));
		return getManager().getEventsList(categ,
				"insertionTime DESC, modificationTime DESC", mx);
	}
}
