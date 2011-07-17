package org.bambrikii.photobank.web.news;

import java.util.Arrays;
import java.util.List;

import org.bambrikii.photobank.news.model.News;
import org.bambrikii.photobank.news.model.NewsStatusEnum;
import org.bambrikii.photobank.web.news.beans.NewsBean;
import org.bambrikii.site.base.struts2.core.SiteBaseDictionaryAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;

@SiteBaseSecurityAware(allowedRoles = "service_manager")
public class NewsEditAction extends SiteBaseDictionaryAction<News> {
	private static final long serialVersionUID = 4673685629501386444L;

	private News model;
	private NewsBean newsBean;

	public void setModel(News model) {
		this.model = model;
	}

	public News getModel() {
		return model;
	}

	public void setNewsBean(NewsBean newsBean) {
		this.newsBean = newsBean;
	}

	public NewsBean getNewsBean() {
		return newsBean;
	}

	public List<NewsStatusEnum> getStatusesList() {
		return Arrays.asList(NewsStatusEnum.values());
	}

	// Actions

	public String execute() throws Exception {
		return list();
	}

	@Override
	public String save() throws Exception {
		News news = getModel() == null || getModel().getId() == null ? new News()
				: getNewsBean().getById(getModel().getId());
		news.setTime(getModel().getTime());
		news.setTitle(getModel().getTitle());
		news.setContent(getModel().getContent());
		news.setStatus(getModel().getStatus());
		getNewsBean().saveOrUpdate(news);
		return list();
	}

	@Override
	public String delete() throws Exception {
		News news = getNewsBean().getById(getModel().getId());
		getNewsBean().delete(news);
		return list();
	}

	@Override
	public String edit() throws Exception {
		if (!(getModel() == null || getModel().getId() == null)) {
			News news = getNewsBean().getById(getModel().getId());
			setModel(news);
		}
		return EDIT_RESULT;
	}

	@Override
	public String list() throws Exception {
		setPager(getNewsBean().getPager(getRequestedPage()));
		return LIST_RESULT;
	}

}
