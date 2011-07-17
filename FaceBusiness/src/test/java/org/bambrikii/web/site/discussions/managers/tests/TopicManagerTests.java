package org.bambrikii.web.site.discussions.managers.tests;

import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.web.site.services.discussion.business.TopicManager;
import org.bambrikii.web.site.services.discussion.model.Topic;
import org.bambrikii.web.site.tests.core.ManagerTestBase;
import org.junit.Test;

public class TopicManagerTests extends ManagerTestBase<TopicManager> {
	@Test
	public void testPager() {
		Pager<Topic> pager = mgr.getPager(null, "modificationTime", 0);
		System.out.printf("%s, %s\n", pager.getRowsCount(),
				pager.getTotalRecordsCount());
	}
}
