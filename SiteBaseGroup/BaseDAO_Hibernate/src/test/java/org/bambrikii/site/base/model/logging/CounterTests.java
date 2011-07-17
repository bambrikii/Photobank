package org.bambrikii.site.base.model.logging;

import java.util.Calendar;

import junit.framework.Assert;

import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.logging.dao.CounterDAO;
import org.bambrikii.site.base.logging.model.Counter;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Before;
import org.junit.Test;

public class CounterTests extends DAOTestBase<CounterDAO> {
	@Before
	public void before() throws DAOException {
		super.before();
	}

	@Test
	public void crudCounter() {
		Counter counter = new Counter();
		counter.setTime(Calendar.getInstance().getTime());
		dao.saveOrUpdate(counter);
		Assert.assertTrue(counter.getId() > 0);
	}
}
