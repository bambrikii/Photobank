package org.bambrikii.photobank.web.tests;

import java.text.ParseException;
import java.util.List;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.imageprocessing.AbstractImageManagerHandler;
import org.bambrikii.photobank.business.managers.imageprocessing.handlers.EventManager2;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UploadTests {
	private ManagerContainer container = null;
	private CategoryManager categMgr = null;

	@Before
	public void before() throws ManagerException {
		container = new ManagerContainer();
		container.open();
		categMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
	}

	@After
	public void after() {
		container.close();
	}

	@Test
	public void test1() throws ManagerException {
		EventManager evtMgr = (EventManager) container
				.getManager(EventManager.class);

		Integer eventId = 41680;
		Category event = evtMgr.getById(eventId);
		List<Category> categs = categMgr.getList(event, "John Turturro", null);
		for (Category categ : categs) {
			System.out.printf("%s, %s, %s, %s\n", categ.getId(),
					categ.getDescription(), categ.getActive(),
					categ.getCategoryType());
		}
	}

	@Test
	public void test2() throws ManagerException, ParseException {
		Integer baseCategId = 16845;
		Category baseCateg = categMgr.getById(baseCategId);
		EventManager2 evtMgr2 = (EventManager2) container
				.getManager(EventManager2.class);

		String description = "67TH VENICE FILMFESTIVAL - JOHN TURTURRO - NO ITALIAN SALES";

		List<Event> evts2 = evtMgr2.getList(description, "",
				AbstractImageManagerHandler.parseDate("02", "09", "10"),
				baseCateg, null, 0);
		for (Event evt : evts2) {
			System.out.printf("%s, %s, %s\n", evt.getId(),
					evt.getDescription(), evt.getText());
		}
	}
}
