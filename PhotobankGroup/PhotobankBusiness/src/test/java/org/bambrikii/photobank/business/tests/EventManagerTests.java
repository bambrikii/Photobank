package org.bambrikii.photobank.business.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.junit.Assert;
import org.junit.Test;

public class EventManagerTests extends ManagerTestBase<EventManager> {
	public static int TEST_PARENT_ID = 2;
	public static int TEST_EVENT_PARENT_CATEGORY_ID = 3;
	public static int TEST_EVENT_ID = 41527;

	@Test
	public void crudTest() throws ManagerException {
		container.begin();
		CategoryManager catMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
		Category cat = catMgr.getById(TEST_PARENT_ID);
		Event event = create(cat, "PhotobankEvent+ "
				+ Calendar.getInstance().getTimeInMillis(), "Random text...");
		container.commit();
		container.begin();
		mgr.delete(event);
		container.commit();
	}

	public Event create(Category parentCategory, String description, String text) {
		Date currentTime = Calendar.getInstance().getTime();
		Event event = new Event();
		event.setDescription(description);
		event.setText(text);
		event.setActive(true);
		event.setInsertionTime(Calendar.getInstance().getTime());
		event.setCategoryType(CategoryTypeEnum.DEFAULT);
		event.setDescription(description);
		event.setParent(parentCategory);
		DateFormat dateformatYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
		event.setOrder(Integer.parseInt(dateformatYYYYMMDD.format(currentTime)));
		return event;
	}

	protected void printEvent(Pager<Event> pgr) {
		for (Event event : pgr.getRecords()) {
			System.out.printf("%s, %s, %s, %s, %s\n", event.getId(),
					event.getDescription(), event.getDescription(),
					event.getInsertionTime(), event.getModificationTime());
		}
	}

	@Test
	public void listEventsTest() throws ManagerException {
		CategoryManager categMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
		Category categ = categMgr.getById(TEST_EVENT_PARENT_CATEGORY_ID);
		System.out.printf("---\nPage 0:\n");
		Pager<Event> pgr = mgr.getEventPager(categ, new Pager<Event>(3, 7, 0));
		printEvent(pgr);
		System.out.printf("---\nPage 1:\n");
		pgr = mgr.getEventPager(categ, new Pager<Event>(3, 7, 0));
		printEvent(pgr);
	}

	@Test
	public void listFilesTest() throws ManagerException {
		EventManager eventMgr = (EventManager) container
				.getManager(EventManager.class);
		FileManager fileMgr = (FileManager) container
				.getManager(FileManager.class);
		Event event = eventMgr.getById(TEST_EVENT_ID);
		List<File> files = fileMgr.getFiles(event, "modificationTime DESC");
		Assert.assertTrue(files.size() > 0);
		for (File file : files) {
			System.out.printf("%s, %s, %s\n", file.getId(), file.getFileName(),
					file.getDescription());
		}
	}
}
