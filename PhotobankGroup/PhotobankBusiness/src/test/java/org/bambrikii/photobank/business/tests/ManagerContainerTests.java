package org.bambrikii.photobank.business.tests;

import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagerContainerTests {
	ManagerContainer mgrContainer;

	@Before
	public void before() {
		mgrContainer = ManagerContainer.getNewInstance();
		mgrContainer.open();
	}

	@After
	public void after() {
		mgrContainer.close();
	}

	@Test
	public void test1() throws ManagerException {
		@SuppressWarnings("unused")
		EventManager mgr1 = (EventManager) mgrContainer
				.getManager(EventManager.class);
		/*
		 * List<Event> events = mgr1.getEventsList(0); for (Event event1 :
		 * events) { System.out.printf("%s, %s, %s", event1.getId(),
		 * event1.getDescription(), event1.getModificationTime()); }
		 */
	}
}
