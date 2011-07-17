package org.bambrikii.photobank.web.news.beans;

import java.util.List;

import org.bambrikii.photobank.business.managers.NewsManager;
import org.bambrikii.photobank.news.model.News;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudBean;

public class NewsBean extends BaseCrudBean<News, NewsManager> {
	public Pager<News> getPager(Integer currPage) throws ManagerException {
		return getManager().getPager(currPage);
	}

	public List<News> getTopNews() throws ManagerException {
		return getManager().getList(3);
	}
}
