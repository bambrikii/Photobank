package org.bambrikii.site.base.model.logging;

import java.util.Calendar;

import junit.framework.Assert;

import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.logging.dao.LogDAO;
import org.bambrikii.site.base.logging.dao.SourceDAO;
import org.bambrikii.site.base.logging.model.Log;
import org.bambrikii.site.base.logging.model.LogLevelEnum;
import org.bambrikii.site.base.logging.model.Source;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Before;
import org.junit.Test;

public class LoggingTests extends DAOTestBase<LogDAO> {
	private SourceDAO sourceDao;

	@Before
	public void before() throws DAOException {
		super.before();
		sourceDao = new SourceDAO(cn);
	}

	@Test
	public void sourceTest() {
		Source source = sourceDao.checkSource("Test");
		Assert.assertTrue(source != null && source.getId() > 0);
	}

	@Test
	public void logTest() {
		Source source = sourceDao.getByName("Test");
		Log log = new Log();
		log.setLevel(LogLevelEnum.INFO);
		log.setName("Test log");
		log.setText("Test text");
		log.setSource(source);
		log.setTime(Calendar.getInstance().getTime());
		dao.saveOrUpdate(log);
		Assert.assertTrue(log.getId() > 0);
	}
}
