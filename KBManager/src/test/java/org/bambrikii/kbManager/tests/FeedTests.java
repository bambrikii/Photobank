package org.bambrikii.kbManager.tests;

import java.util.List;

import org.bambrikii.kbManager.feeds.mgrs.FeedManager;
import org.bambrikii.kbManager.feeds.model.FeedNews;
import org.bambrikii.kbManager.feeds.model.FeedSite;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.tests.core.ManagerTestBase;
import org.junit.Before;
import org.junit.Test;

public class FeedTests extends ManagerTestBase<FeedManager> {
	private FeedManager mgr;

	@Before
	public void before() throws ManagerException {
		super.before();
		mgr = container.getManager(FeedManager.class);
	}

	@Test
	public void testFeedSourcesListing() throws Exception {
		List<FeedSite> sites = mgr.getSites();
		for (FeedSite site : sites) {
			System.out.printf("%s, %s, %s\n", site.getId(), site.getName(),
					site.getUrl());
		}
	}

	@Test
	public void testDownloadFeedEntries() throws Exception {
		testdownloadFeedEntries(mgr, "http://www.tert.am/");
		testdownloadFeedEntries(mgr, "http://www.panarmenian.net/");
		testdownloadFeedEntries(mgr, "http://www.azatutyun.am/");
		testdownloadFeedEntries(mgr, "http://groong.usc.edu/");
		// testdownloadFeedEntries(mgr, "http://www.euronews.net/");

	}

	@Test
	public void testDownloadFeedEntries_Euronews() throws Exception {
		testdownloadFeedEntries(mgr, "http://www.euronews.net/");
	}

	@Test
	public void testDownloadFeedEntries_Groong() throws Exception {
		testdownloadFeedEntries(mgr, "http://groong.usc.edu/");
	}

	private void testdownloadFeedEntries(FeedManager mgr, String siteName)
			throws Exception {
		FeedSite site = mgr.getSite(siteName);
		container.begin();
		try {
			mgr.downloadNews(site);
			container.commit();
			List<FeedNews> newss = site.getNews();
			for (FeedNews news : newss) {
				System.out.printf("%s, %s, %s\n", news.getId(),
						news.getTitle(), news.getUrl());
			}
		} catch (Exception ex) {
			container.rollback();
			// System.out.printf("Exception: %s, %s\n", ex.getMessage(),
			// ex.getStackTrace().toString());
			throw new Exception("Exception in test", ex);
		}
	}
}
