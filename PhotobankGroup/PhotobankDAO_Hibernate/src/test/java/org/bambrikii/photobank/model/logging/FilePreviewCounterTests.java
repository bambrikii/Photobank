package org.bambrikii.photobank.model.logging;

import java.util.Calendar;

import junit.framework.Assert;

import org.bambrikii.photobank.dao.FileDAO;
import org.bambrikii.photobank.logging.dao.FilePreviewCounterDAO;
import org.bambrikii.photobank.logging.model.FilePreviewCounter;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.hibernate.Criteria;
import org.junit.Before;
import org.junit.Test;

public class FilePreviewCounterTests extends DAOTestBase<FilePreviewCounterDAO> {
	private FileDAO fileDao;

	@Before
	public void before() throws DAOException {
		super.before();
		fileDao = new FileDAO(cn);
	}

	@Test
	public void crudTest() {
		Criteria crit = fileDao.getCriteria();
		crit.setMaxResults(1);
		File file = (File) crit.list().get(0);

		FilePreviewCounter c = new FilePreviewCounter();
		c.setTime(Calendar.getInstance().getTime());
		c.setFile(file);
		dao.saveOrUpdate(c);
		Assert.assertTrue(c.getId() > 0);
	}
}
