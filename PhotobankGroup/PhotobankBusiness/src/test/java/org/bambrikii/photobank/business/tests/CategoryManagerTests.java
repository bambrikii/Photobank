package org.bambrikii.photobank.business.tests;

import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.junit.Test;

public class CategoryManagerTests extends ManagerTestBase<CategoryManager> {
	@Test
	public void listCategoriesHavingNoParentCategories() {
		List<Category> categories = mgr.getList((Category) null);
		Assert.assertTrue("Categories should exist!", categories != null);
		Assert.assertTrue("Categories contains zero records!",
				categories.size() > 0);
	}

	@Test
	public void categoriesPagerTest() throws ManagerException {
		Category parentCategory = mgr.getById(EventManagerTests.TEST_PARENT_ID);
		Pager<Category> pager = mgr.getCategoriesPager(parentCategory, null, 0);
		Assert.assertTrue("Failed to get pager.", pager != null);
	}

	@Test
	public void listCategoriesByTypeTest() {
		List<Category> categories = mgr.getList(null, null,
				CategoryTypeEnum.MAIN);
		for (Category category : categories) {
			System.out.printf("	%s, %s, %s\n", category.getId(),
					category.getDescription(), category.getCategoryType());
		}

	}
}
