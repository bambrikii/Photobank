package org.bambrikii.photobank.model.tests;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.dao.FileDAO;
import org.bambrikii.photobank.dao.IptcFieldDAO;
import org.bambrikii.photobank.dao.IptcGroupDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.IptcField;
import org.bambrikii.photobank.model.IptcGroup;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.junit.Before;
import org.junit.Test;

public class IptcTests extends DAOTestBase<IptcGroupDAO> {
	private CategoryDAO categDao;
	private FileDAO fileDao;
	private IptcFieldDAO iptcFieldDao;

	@Before
	public void before() throws DAOException {
		super.before();
		categDao = new CategoryDAO(cn);
		fileDao = new FileDAO(cn);
		iptcFieldDao = new IptcFieldDAO(cn);
	}

	@Test
	public void listCategoriesContainingFilesWithIptcData() {
		List<Category> list = dao.listCategoriesWithIptcFiles();
		for (Category cat : list) {
			System.out.printf("\t cat: %s, %s, %s\n", cat.getId(),
					cat.getDescription(), cat.getModificationTime());
			List<File> files = cat.getFiles();
			for (File file : files) {
				System.out.printf("\t\t file: %s, %s, %s\n", file.getId(),
						file.getFileName(), file.getModificationTime());
				List<IptcGroup> iptcGroups = file.getIptcGroups();
				for (IptcGroup iptcGroup : iptcGroups) {
					System.out.printf("\t\t\t iptcGroup: %s: %s\n",
							iptcGroup.getName(),
							iptcGroup.getModificationTime());
					List<IptcField> iptcFields = iptcGroup.getFields();
					for (IptcField iptcField : iptcFields) {
						System.out.printf("\t\t\t\t iptcField: %s: %s\n",
								iptcField.getName(), iptcField.getValue());
					}
				}
			}
			break;
		}
	}

	@Test
	public void deleteAllIptcGroupsTest() throws PersistenceException {
		Category category = categDao.getById(CategoryTests.TEST_CATEGORY_ID);

		File file = new File();
		file.setCategory(category);
		file.setActive(true);
		file.setDescription("File 1");
		file.setFileName("a.txt");
		file.setOrder(0);
		file.setModificationTime(Calendar.getInstance().getTime());
		cn.beginTransaction();
		fileDao.saveOrUpdate(file);
		cn.commitTransaction();
		IptcGroup g = new IptcGroup();
		g.setFile(file);
		g.setName("group1");
		cn.beginTransaction();
		dao.saveOrUpdate(g);
		cn.commitTransaction();

		IptcField f = new IptcField();
		f.setGroup(g);
		f.setName("field1");
		f.setValue("value1");
		cn.beginTransaction();
		dao.saveOrUpdate(g);
		iptcFieldDao.saveOrUpdate(f);
		cn.commitTransaction();

		fileDao.refresh(file);
		Assert.assertTrue("IptcGroup not been inserted correctly.",
				file.getIptcGroups() != null
						&& file.getIptcGroups().size() == 1);
		dao.refresh(file.getIptcGroups().get(0));
		Assert.assertTrue("IptcField have not been inserted correctly.", file
				.getIptcGroups().get(0).getFields() != null
				&& file.getIptcGroups().get(0).getFields().size() == 1);

		cn.beginTransaction();
		file.getIptcGroups().clear();
		cn.commitTransaction();
		// fileDao.refresh(file);
		Assert.assertTrue("Iptc have not been deleted.",
				file.getIptcGroups() == null
						|| file.getIptcGroups().size() == 0);
	}
}
