package org.bambrikii.photobank.model.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.dao.EventDAO;
import org.bambrikii.photobank.dao.FileDAO;
import org.bambrikii.photobank.dao.FileDimensionDAO;
import org.bambrikii.photobank.dao.FileFullTextWeight;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FilesTests extends DAOTestBase<FileDAO> {
	private EventDAO eventDao;
	private CategoryDAO categDao;
	private FileDimensionDAO fileDimDao;

	@Before
	public void before() throws DAOException {
		super.before();
		eventDao = new EventDAO(cn);
		categDao = new CategoryDAO(cn);
		fileDimDao = new FileDimensionDAO(cn);
	}

	private void print(List<File> list) {
		for (File item : list) {
			System.out.printf("%s, %s, %s\n", item.getId(), item.getFileName(),
					item.getDescription());
		}
	}

	@Test
	@Ignore
	public void clearCategory() throws PersistenceException, ParseException {
		Integer categID = 4129;
		Category categ = categDao.getById(categID);
		DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date from = formatter.parse("2001.01.01");
		Date till = formatter.parse("2009.12.31");

		cn.beginTransaction();
		List<File> files = dao.getFromSubCategories(categ, from, till);
		Integer i = 0;
		for (File f : files) {
			i++;
			System.out.printf(" --- Record: [%d]) [%d], [%s].\n", i, f.getId(),
					f.getFileName());
		}
		cn.commitTransaction();
	}

	@Test
	public void getAllDimensionsTest() {
		List<FileDimension> dimensions = fileDimDao.getList("order");
		printDimensions(dimensions);
	}

	@Test
	public void getAllActiveDimensionsTest() {
		List<FileDimension> dimensions = fileDimDao.getList(true, "order");
		printDimensions(dimensions);
	}

	private void printDimensions(List<FileDimension> dimensions) {
		Assert.assertTrue("No dimensions found!", dimensions.size() > 0);
		for (FileDimension dim : dimensions) {
			System.out.printf("%s, %s, %s\n", dim.getId(), dim.getName(),
					dim.getOrder());
		}
	}

	@Test
	public void getByIdsTest() {
		List<File> files = dao.find("afef a", "modificationTime", 0, 5);
		Assert.assertTrue("No files found!", files.size() > 0);
		Set<Integer> fileIds = new HashSet<Integer>();
		for (File file : files) {
			fileIds.add(file.getId());
		}
		List<File> files2 = dao.getByIds(fileIds);
		Assert.assertEquals("No files got by ids!", fileIds.size(),
				files2.size());
		for (File file : files2) {
			System.out.printf("%s, %s, %s\n", file.getId(), file.getFileName(),
					file.getDescription());
		}
	}

	@Test
	public void listFilesByCategoryTest() {
		Category categ = categDao.getById(CategoryTests.TEST_CATEGORY_ID);
		List<File> files = dao.getList(categ);
		print(files);
	}

	@Test
	public void listFilesByEventTest2() {
		Event event = eventDao.getById(CategoryTests.TEST_CATEGORY_ID);
		List<File> files = dao.getFiles(event, "modificationTime DESC", 0, 15);
		for (File file : files) {
			System.out.printf("%s, %s, %s, %s\n", file.getId(),
					file.getFileName(), file.getDescription(),
					file.getModificationTime());
		}
	}

	@Test
	public void fullTextSearchTest() {
		List<File> files = dao.find("afef provera", "modificationTime", 0, 5);
		Assert.assertTrue("No files found!", files.size() > 0);
		Set<Integer> fileIds = new HashSet<Integer>();
		for (File file : files) {
			fileIds.add(file.getId());
		}
		List<File> files2 = dao.getByIds(fileIds);
		Assert.assertEquals("No files got by ids!", fileIds.size(),
				files2.size());
		print(files2);
	}

	private void printFile(File file1) {
		System.out.printf("	%s,\n	%s,\n	%s,\n	%s,\n	%s,\n	%s,\n	%s\n",
				file1.getId(), file1.getFileName(), file1.getDescription(),
				file1.getModificationTime(), file1.getOrder(),
				file1.getActive(), file1.getCategory().getDescription());
	}

	@Test
	public void listMultipleCliteria() {
		List<?> list = dao.find("Александр",
				"weight DESC, modificationTime DESC", 0, 5);

		for (Object obj : list) {
			System.out.printf("%s\n", obj.toString());
			if (obj instanceof Object[]) {
				Object[] obj2 = (Object[]) obj;
				for (Object obj3 : obj2) {
					if (obj3 instanceof File) {
						File file1 = (File) obj3;
						printFile(file1);
					} else if (obj3 instanceof FileFullTextWeight) {
						FileFullTextWeight w = (FileFullTextWeight) obj3;
						System.out.printf("	%s\n",
								((FileFullTextWeight) obj3).getWeight());
					} else {
						Object[] obj4 = (Object[]) obj3;
						if (obj4 != null) {
							for (Object obj5 : obj4) {
								System.out.printf("	%s\n", obj5.toString());
							}
						}
					}
				}
			} else if (obj instanceof File) {
				File file1 = (File) obj;
				printFile(file1);
			} else if (obj instanceof Collection<?>) {
				List<?> obj2 = (List<?>) obj;
				for (Object obj3 : obj2) {
					System.out.printf("	%s\n", obj3.toString());
				}
			}
		}

		// LinkedHashMap<Class, Object> list2 = (LinkedHashMap<Class, Object>)
		// list;
		// list2.get(File.class);

	}

	@Test
	public void getTopNFiles() {
		Integer n = 10;
		List<File> files = dao.getTopNFiles(n);
		print(files);
	}

	@Test
	public void testTopFilesByCounter() {
		Integer n = 10;
		Query q = dao
				.getConnector()
				.getSession()
				.createQuery(
						" select f1 as n1 "
								+ " from FilePreviewCounter fpc join fpc.file f1 "
								+ " group by f1 " + " order by count(fpc) desc")
				.setMaxResults(n);
		List<File> list = (List<File>) q.list();
		Integer i1 = 0;
		for (File file1 : list) {
			System.out.printf("%s, %s, %s\n", file1.getId(),
					file1.getFileName(), file1.getModificationTime());
		}
	}

	@Test
	public void testTopFilesByCounterDao() {
		print(dao.getTopNFilesByCounter(10));
	}

	@Test
	public void getTopNFilesByCounter() {
		Integer n = 10;
		List<File> files = dao.getTopNFilesByCounter(n);
		print(files);
	}
}
