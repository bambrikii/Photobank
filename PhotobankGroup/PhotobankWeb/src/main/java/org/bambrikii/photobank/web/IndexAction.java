package org.bambrikii.photobank.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.news.model.News;
import org.bambrikii.photobank.web.events.beans.EventBean;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.news.beans.NewsBean;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;

public class IndexAction extends SiteBaseAction {
	private static final long serialVersionUID = -7188003518812383764L;

	private EventBean eventBean;
	private PhotoBean photoBean;
	private NewsBean newsBean;

	private Map<Category, List<Event>> mainList;
	private List<File> topFiles;
	private List<News> topNews;

	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}

	public EventBean getEventBean() {
		return eventBean;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public void setNewsBean(NewsBean newsBean) {
		this.newsBean = newsBean;
	}

	public NewsBean getNewsBean() {
		return newsBean;
	}

	public void setMainList(Map<Category, List<Event>> mainList) {
		this.mainList = mainList;
	}

	public Map<Category, List<Event>> getMainList() {
		return mainList;
	}

	public void setTopFiles(List<File> topFiles) {
		this.topFiles = topFiles;
	}

	public List<File> getTopFiles() {
		return topFiles;
	}

	public void setTopNews(List<News> topNews) {
		this.topNews = topNews;
	}

	public List<News> getTopNews() {
		return topNews;
	}

	// Actions
	public String execute() throws Exception {

		List<Category> mainCategs = getEventBean().getCategories(
				CategoryTypeEnum.MAIN_EVENT);
		Map<Category, List<Event>> mainList2 = new LinkedHashMap<Category, List<Event>>();
		for (Category categ : mainCategs) {
			mainList2.put(categ, getEventBean().getEventBriefList(categ));
		}
		setMainList(mainList2);

		setTopFiles(getPhotoBean().getTopOrderedFiles());
		setTopNews(getNewsBean().getTopNews());

		return SUCCESS;
	}
}
