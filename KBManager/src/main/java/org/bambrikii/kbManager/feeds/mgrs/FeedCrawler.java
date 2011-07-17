package org.bambrikii.kbManager.feeds.mgrs;

import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class FeedCrawler {
	public List<SyndEntry> getSyndFeedEntries(String url) throws Exception {
		try {
			URL feedUrl = new URL(url);

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));

			@SuppressWarnings("unchecked")
			List<SyndEntry> entries = (List<SyndEntry>) feed.getEntries();
			return entries;
		} catch (Exception ex) {
			throw new Exception(String.format(
					"Failed to get feed entries for %s", url), ex);
		}
	}
}
