package org.bambrikii.web.site.discussions.managers.tests;

import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.web.site.services.discussion.business.MessageManager;
import org.bambrikii.web.site.services.discussion.model.Message;
import org.bambrikii.web.site.tests.core.ManagerTestBase;
import org.junit.Test;

public class MessageManagerTests extends ManagerTestBase<MessageManager> {
	@Test
	public void testPager() {
		Pager<Message> pager = mgr.getPager(null, null, "modificationTime", 0);
		System.out.printf("%s, %s\n", pager.getRowsCount(),
				pager.getTotalRecordsCount());
	}
}
