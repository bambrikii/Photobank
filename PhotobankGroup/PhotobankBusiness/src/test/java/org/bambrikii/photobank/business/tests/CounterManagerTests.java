package org.bambrikii.photobank.business.tests;

import org.bambrikii.photobank.business.managers.CounterManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.photobank.logging.model.FilePreviewCounter;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.Assert;
import org.junit.Test;

public class CounterManagerTests extends ManagerTestBase<CounterManager> {

	@Test
	public void crudTest() throws ManagerException {
		FileManager fileMgr = (FileManager) container
				.getManager(FileManager.class);
		File file = fileMgr.getTopNFiles(1).get(0);

		container.begin();
		FilePreviewCounter fpc = mgr.countFilePreview(file);
		container.commit();
		Assert.assertTrue(fpc != null && fpc.getId() > 0);

	}

}
