package org.bambrikii.kbManager.feeds.mgrs;

import java.util.List;

import org.bambrikii.kbManager.feeds.dao.FeedNewsDAO;
import org.bambrikii.kbManager.feeds.dao.FeedSiteDAO;
import org.bambrikii.kbManager.feeds.model.FeedNews;
import org.bambrikii.kbManager.feeds.model.FeedSite;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

import com.sun.syndication.feed.synd.SyndEntry;

public class FeedManager extends ManagerBase<FeedSite, FeedSiteDAO> {

	public FeedManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		_newsDao = new FeedNewsDAO(dao.getConnector());
		_feedCrawler = new FeedCrawler();
	}

	private FeedNewsDAO _newsDao;
	private FeedCrawler _feedCrawler;

	public List<FeedSite> getSites() throws Exception {
		return dao.getList();
	}

	public FeedSite getSite(String siteName) {
		return dao.getByName(siteName);
	}

	private String buildContent(List<String> content) {
		StringBuilder sb = new StringBuilder();
		for (String content1 : content) {
			sb.append(content1);
			sb.append("\n");
		}
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public void downloadNews(FeedSite site) throws Exception {
		List<SyndEntry> entries = _feedCrawler
				.getSyndFeedEntries(site.getUrl());
		for (SyndEntry entry : entries) {
			String url = entry.getLink();
			FeedNews news = _newsDao.getByUrl(site, url);
			if (news == null) {
				news = new FeedNews();
				news.setPubDate(entry.getPublishedDate());
				news.setUrl(url);
				news.setSite(site);
				if (entry.getDescription() != null) {
					news.setDescription(entry.getDescription().getValue());
				}
				news.setContent(buildContent((List<String>) entry.getContents()));
				news.setTitle(entry.getTitle());
				news.setAuthor(entry.getAuthor());
				_newsDao.saveOrUpdate(news);
			}

		}
	}
}
