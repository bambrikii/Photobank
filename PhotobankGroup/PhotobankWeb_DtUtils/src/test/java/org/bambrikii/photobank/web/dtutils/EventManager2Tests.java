package org.bambrikii.photobank.web.dtutils;

import java.text.ParseException;
import java.util.List;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.imageprocessing.AbstractImageManagerHandler;
import org.bambrikii.photobank.business.managers.imageprocessing.handlers.EventManager2;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventManager2Tests {
	protected ManagerContainer container;

	@Before
	public void before() {
		container = ManagerContainer.getNewInstance();
		container.open();
	}

	@After
	public void after() {
		container.close();
		container = null;
	}

	@Test
	public void list1Test() throws ManagerException, ParseException {
		EventManager2 mgr2 = (EventManager2) container
				.getManager(EventManager2.class);
		CategoryManager categMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
		Category baseCateg = categMgr.getById(16845);
		List<Event> eventsList = mgr2
				.getList(
						"Cure in the Canyons IV for Breast Cancer Research - Arrivals",
						"10/03/2010 - Stephanie Gatschet - Cure in the Canyons IV for Breast Cancer Research - Arrivals - 13100 Mulholland Drive - Beverly Hills, CA, USA - Keywords:  - 0 - Photo Credit: Tatiana  Beller / PR Photos - Contact (1-866-551-7827)",
						AbstractImageManagerHandler.parseDate("10", "10", "03"),
						baseCateg, "insertionTime DESC", null);
		System.out.printf("%s\n", eventsList.size());
		for (Event event : eventsList) {
			System.out.printf("%s\n\t%s\n\t%s\n\t%s\n", event.getId(),
					event.getInsertionTime(), event.getText(),
					event.getDescription());
		}
	}
}
