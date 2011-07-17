package org.bambrikii.photobank.web.news;

import org.bambrikii.photobank.news.model.News;
import org.bambrikii.photobank.web.news.beans.NewsBean;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;

public class NewsAction extends SiteBasePagerAction<Pager<News>> {
	private static final long serialVersionUID = -8153786520718867515L;
	private News model;
	private NewsBean newsBean;

	public void setNewsBean(NewsBean newsBean) {
		this.newsBean = newsBean;
	}

	public NewsBean getNewsBean() {
		return newsBean;
	}

	public void setModel(News model) {
		this.model = model;
	}

	public News getModel() {
		return model;
	}

	// Actions
	public String execute() throws Exception {
		return list();
	}

	public String list() throws Exception {
		setPager(getNewsBean().getPager(getRequestedPage()));
		return SUCCESS;
	}

	public String preview() throws Exception {
		News news = getNewsBean().getById(getModel().getId());
		setModel(news);
		return "preview";
	}
}
