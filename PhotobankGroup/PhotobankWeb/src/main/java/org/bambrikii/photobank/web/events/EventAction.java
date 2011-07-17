package org.bambrikii.photobank.web.events;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.web.core.AbstractFilesAction;
import org.bambrikii.photobank.web.events.beans.EventBean;
import org.bambrikii.site.base.business.pagers.Pager;

public class EventAction extends AbstractFilesAction<Event> {
	private static final long serialVersionUID = -8153786520718867515L;
	private EventBean eventBean;
	private Event model;
	private Map<Category, List<Event>> mainList;
	private Category category;

	public EventBean getEventBean() {
		return eventBean;
	}

	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}

	public Event getModel() {
		return model;
	}

	public void setModel(Event model) {
		this.model = model;
	}

	public void setMainList(Map<Category, List<Event>> mainList) {
		this.mainList = mainList;
	}

	public Map<Category, List<Event>> getMainList() {
		return mainList;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	// Actions
	public String execute() throws Exception {
		return list();
	}

	public String files() throws Exception {
		Event event = getEventBean().getEvent(
				getModel() != null ? getModel().getId() : null);
		setModel(event);
		Pager<File> filesPager = getEventBean().getFiles(event,
				getRequestedPage());
		setFilesPager(filesPager);
		return "files";
	}

	public String list() throws Exception {
		if (getModel() != null) {
			setCategory(getEventBean().getCategory(getModel().getId()));
			setPager(getEventBean().getEvents(getCategory(), 3, 7,
					getRequestedPage()));
		} else {
			List<Category> mainCategs = getEventBean().getCategories(
					CategoryTypeEnum.MAIN_EVENT);
			Map<Category, List<Event>> mainList2 = new LinkedHashMap<Category, List<Event>>();
			for (Category categ : mainCategs) {
				mainList2.put(categ, getEventBean().getEventBriefList(categ));
			}
			setMainList(mainList2);
		}
		return SUCCESS;
	}

	public String briefList() throws Exception {
		if (getModel() != null) {
			setCategory(getEventBean().getCategory(getModel().getId()));
			setPager(getEventBean().getEvents(getModel(), 1, 1024,
					getRequestedPage()));
			return "briefList";
		}
		throw new Exception("Model required. Category's not defined.");
	}
}
