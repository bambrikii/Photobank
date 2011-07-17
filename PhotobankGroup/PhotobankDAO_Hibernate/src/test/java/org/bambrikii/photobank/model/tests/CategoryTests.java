package org.bambrikii.photobank.model.tests;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTests extends DAOTestBase<CategoryDAO> {
	public static int TEST_PARENT_ID = 1;
	public static int TEST_CATEGORY_ID = 2;

	public static void print(List<Category> list, int level) {
		for (Category item : list) {
			print(item, level);
			if (item.getChildren() != null && item.getChildren().size() > 0) {
				print(item.getChildren(), level + 1);
			}
		}
	}

	public static void print(Category item, int level) {
		String spc = "\t";
		String spc2 = "";
		for (int i = 0; i < level; i++) {
			spc2 += spc;
		}
		System.out.println(MessageFormat.format(
				"{2} - Category: {0}, {1}, {3}", item.getId(),
				item.getDescription(), spc2, item.getCategoryType()));
	}

	public static void print(List<Category> list) {
		for (Category item : list) {
			System.out
					.println(MessageFormat.format("Category: {0}, {1}, {2}",
							item.getId(), item.getDescription(),
							item.getCategoryType()));
		}
	}

	@Before
	public void before() throws DAOException {
		dao = new CategoryDAO(cn);
		super.before();
	}

	@Test
	public void getCategoriesPagedList() {
		String orderBy = "";
		List<Category> list = dao.getList(orderBy, 0, 3);
		print(list, 0);
	}

	@Test
	public void crudTest() throws PersistenceException {
		cn.beginTransaction();
		Category cat = new Category();
		cat.setActive(true);
		cat.setCategoryType(CategoryTypeEnum.DEFAULT);
		cat.setDescription("TestCategory "
				+ Calendar.getInstance().getTimeInMillis());
		cat.setOrder(0);
		cat.setParent(dao.getById(TEST_PARENT_ID));
		cat.setModificationTime(Calendar.getInstance().getTime());
		dao.saveOrUpdate(cat);
		cn.commitTransaction();
		int id2 = cat.getId();
		cat = null;
		Assert.assertTrue("Category should have been given a new id value!",
				id2 > 0);
		Category cat2 = dao.getById(id2);
		Assert.assertEquals(
				"Category type value should have been set to 'DEFAULT'!",
				cat2.getCategoryType(), CategoryTypeEnum.DEFAULT);
		cn.beginTransaction();
		dao.delete(cat2);
		cn.commitTransaction();
		Category cat3 = dao.getById(id2);
		Assert.assertEquals("Category should have been deleted!", cat3, null);
	}
}
