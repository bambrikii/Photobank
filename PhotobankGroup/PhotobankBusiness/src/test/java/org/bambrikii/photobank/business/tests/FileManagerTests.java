package org.bambrikii.photobank.business.tests;

import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.junit.Test;

public class FileManagerTests extends ManagerTestBase<FileManager> {

	private void print(Pager<File> pager) {
		System.out
				.printf("Pager<File>:\n\tcols: %s,\n\trows: %s,\n\tcurrPage: %s,\n\trecords: %s\n",
						pager.getColsCount(), pager.getRowsCount(),
						pager.getCurrPage(), pager.getTotalRecordsCount());
		print(pager.getRecords());
	}

	private void print(List<File> files) {
		for (File item : files) {
			System.out.printf("%s, %s, %s\n", item.getId(), item.getFileName(),
					item.getDescription());
		}
	}

	@Test
	public void search1Test() {
		Pager<File> pgr = mgr.find("Afef Provera Tronchetti",
				"modificationTime DESC", 0, null);
		Assert.assertTrue("Number of records should be less or equal!",
				pgr.getColsCount() * pgr.getRowsCount() >= pgr.getRecords()
						.size());
		print(pgr);
	}

	@Test
	public void search2Test() {
		Pager<File> pgr = mgr.find("Afef", null, 14, null);
		Assert.assertTrue("Number of records should be less or equal!",
				pgr.getColsCount() * pgr.getRowsCount() >= pgr.getRecords()
						.size());
		print(pgr);
	}

	@Test
	public void listByCategoryAndFileNameTest() throws ManagerException {
		CategoryManager catMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
		Category categ = catMgr.getById(EventManagerTests.TEST_PARENT_ID);
		List<File> files = mgr.getList(categ, "%");
		for (File file : files) {
			System.out.printf("%s, %s, %s", file.getId(), file.getFileName(),
					file.getDescription());
		}
	}

	@Test
	public void listEventFilesTest() throws ManagerException {
		EventManager eventMgr = (EventManager) container
				.getManager(EventManager.class);
		Event event = eventMgr.getById(EventManagerTests.TEST_PARENT_ID);
		Pager<File> pager1 = mgr.getFilesPager(event, 0);
		System.out.printf("Number of files in the event: %s\n",
				pager1.getTotalRecordsCount());
		for (File file : pager1.getRecords()) {
			System.out.printf("%s, %s, %s, %s\n", file.getId(),
					file.getFileName(), file.getDescription(),
					file.getModificationTime());
		}
	}

	@Test
	public void getTopNFiles() throws ManagerException {
		Integer n = 10;
		FileManager fileMgr = (FileManager) container
				.getManager(FileManager.class);
		List<File> files = fileMgr.getTopNFiles(n);
		print(files);
	}
}
