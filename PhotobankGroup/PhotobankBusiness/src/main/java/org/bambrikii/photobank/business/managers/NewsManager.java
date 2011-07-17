package org.bambrikii.photobank.business.managers;

import java.util.Calendar;
import java.util.List;

import org.bambrikii.photobank.news.dao.NewsDAO;
import org.bambrikii.photobank.news.model.News;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;

public class NewsManager extends ManagerBase<News, NewsDAO> {

	private Pager<News> newsPager = new Pager<News>(1, 5);

	public NewsManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public Pager<News> getPager(Integer currPage) {
		Pager<News> pager = newsPager.clone();
		pager.setCurrPage(currPage);
		pager.setTotalRecordsCount(dao.getCount());
		pager.setRecords(dao.getList("time DESC", pager.getStart(),
				pager.getLength()));
		return pager;
	}

	public void saveOrUpdate(News news) throws ManagerException {
		news.setModificationTime(Calendar.getInstance().getTime());
		super.saveOrUpdate(news);
	}

	public List<News> getList(Integer maxRecords) {
		return dao.getList("time DESC", 0, maxRecords);
	}
}
