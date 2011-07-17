package org.bambrikii.photobank.web.dtutils.remoteuploader3.tests;

import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.CustomUploadException;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.UploadDataManager;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.FailedFiles;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.PersistenceContainer;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.UploadItem;
import org.junit.Ignore;
import org.junit.Test;

public class PersistenceContainerTests {
	public String TEST_FILE_NAME = "FailedUploads.test.xml";

	@Test
	public void testMarshalAndUnmarshal() throws CustomUploadException {
		marshal();
		unmarshal();
	}

	@Test
	@Ignore
	public void marshal() throws CustomUploadException {
		PersistenceContainer pc1 = new PersistenceContainer();
		FailedFiles ff1 = new FailedFiles();
		ff1.setName("Preview");
		ff1.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path1");
			}
		});
		ff1.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path2");
			}
		});
		ff1.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path3");
			}
		});

		FailedFiles ff2 = new FailedFiles();
		ff2.setName("Order");
		ff1.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path1");
			}
		});
		ff2.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path2");
			}
		});
		ff2.getUploadItems().add(new UploadItem() {
			{
				setAbsolutePath("path3");
			}
		});

		pc1.getFailedFiles().add(ff1);
		pc1.getFailedFiles().add(ff2);

		UploadDataManager.marshal(pc1, TEST_FILE_NAME);
	}

	@Test
	@Ignore
	public void unmarshal() throws CustomUploadException {
		PersistenceContainer pc1 = UploadDataManager.unmarshal(TEST_FILE_NAME);
		Assert.assertNotNull(pc1);
		Assert.assertTrue(pc1.getFailedFiles().size() == 2);
		Assert.assertTrue(pc1.getFailedFiles().get(0).getUploadItems().size() > 0);
		Assert.assertTrue(pc1.getFailedFiles().get(1).getUploadItems().size() > 0);
		System.out.printf("%s\n", "Preview");
		printUploadItems(pc1.getFailedFiles().get(0).getUploadItems());
		System.out.printf("%s\n", "Order");
		printUploadItems(pc1.getFailedFiles().get(1).getUploadItems());
	}

	private void printUploadItems(List<UploadItem> items) {
		for (UploadItem item : items) {
			System.out.printf("	%s\n", item.getAbsolutePath());
		}

	}
}
