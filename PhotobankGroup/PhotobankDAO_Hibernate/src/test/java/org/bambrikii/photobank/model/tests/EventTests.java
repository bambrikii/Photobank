package org.bambrikii.photobank.model.tests;

import java.util.Date;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.dao.EventDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.junit.Before;
import org.junit.Test;

public class EventTests extends DAOTestBase<EventDAO> {
	CategoryDAO catDao;

	@Before
	public void before() throws DAOException {
		super.before();
		catDao = new CategoryDAO(cn);
	}

	@Test
	public void crudTest() throws PersistenceException {
		Date dt = new Date();

		cn.beginTransaction();
		Event event = new Event();
		event.setDescription("Event 1");
		Category cat0 = catDao.getById(CategoryTests.TEST_PARENT_ID);

		event.setModificationTime(dt);
		event.setCategoryType(CategoryTypeEnum.DEFAULT);
		event.setText(event.getDescription() + " / Text.");
		event.setOrder(0);
		event.setParent(cat0);

		event.setInsertionTime(dt);
		event.setModificationTime(dt);
		dao.saveOrUpdate(event);
		cn.commitTransaction();

		cn.beginTransaction();
		dao.delete(event);
		cn.commitTransaction();

	}
}
