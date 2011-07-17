package org.bambrikii.kbManager.kb2;

import java.text.MessageFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.bambrikii.kbManager.kb2.managers.ArtefactManager;
import org.bambrikii.kbManager.kb2.model.Artefact;
import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.business.tests.core.ManagerTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArtefactManagerTests extends ManagerTestBase<ArtefactManager> {
	@Before
	public void before() throws ManagerException {
		super.before();
	}

	@After
	public void after() {
		super.after();
	}

	@Test
	public void test1() throws Exception {
		ArtefactManager mgr = container.getManager(ArtefactManager.class);
		long millis = Calendar.getInstance().getTimeInMillis();
		Artefact a1 = new Artefact();
		a1.setKey("Test artefact " + millis);
		container.begin();
		try {
			mgr.saveOrUpdate(a1);
			container.commit();
		} catch (Exception ex) {
			container.rollback();
			throw ex;
		}
		container.begin();
		try {
			mgr.delete(a1);
			container.commit();
		} catch (Exception ex) {
			container.rollback();
			throw ex;
		}
	}

	private void printPager(Pager<ArtefactAsText> pager) {
		for (ArtefactAsText artefact : pager.getRecords()) {
			System.out.println(MessageFormat.format("{0} {1} {2} {3} {4}",
					artefact.getId(), artefact.getKey(), artefact.getTitle(),
					artefact.getText(), artefact.getPublicationTime()));
		}
	}

	@Test
	public void testPager() throws ManagerException {
		ArtefactManager mgr = container.getManager(ArtefactManager.class);
		Pager<ArtefactAsText> pager = mgr.getArtefacts("%", 0, 1, 150);
		Assert.assertTrue(pager.getTotalRecordsCount() > 0);
		Assert.assertTrue(pager.getRecords().size() > 0);
		System.out.println(MessageFormat.format(
				"pager.getTotalRecordsCount(): {0}",
				pager.getTotalRecordsCount()));
		printPager(pager);
	}

	@Test
	public void testArtefactAsTextPager() throws ManagerException {
		ArtefactManager mgr = container.getManager(ArtefactManager.class);
		Pager<ArtefactAsText> pager = mgr.getDstArtefacts(null, "Language", 0,
				1, 150);
		Assert.assertTrue(pager.getTotalRecordsCount() > 0);
		Assert.assertTrue(pager.getRecords().size() > 0);
		printPager(pager);
	}
}
