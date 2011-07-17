package org.bambrikii.photobank.utils.filestocategories;

import java.util.Calendar;
import java.util.List;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.dao.FileDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.junit.Ignore;
import org.junit.Test;

public class AppTest extends DAOTestBase<CategoryDAO> {
	@Test
	@Ignore
	public void filesToCategories() {
		Category c = dao.getById(41);
		List<Category> categories = dao.getList(c, null, null, null, 0, 0);

		for (Category category : categories) {
			System.out.format(" --- [%d] [%s] / [%d] [%s] \n",
					category.getId(), category.getDescription(), category
							.getParent().getId(), category.getParent()
							.getDescription());
		}
	}

	@Test
	@Ignore
	public void findByName() {
		Category c = dao.getById(41);
		List<Category> categories = dao.getList(c, "дубаи", null,
				"modificationTime DESC", null, null);

		System.out.format(" --- Records found: --- %d \n", categories.size());

		for (Category category : categories) {
			try {
				System.out.format(
						" --- Found by name! --- [%d] [%s] / [%d] [%s] \n",
						category.getId(), category.getDescription(), category
								.getParent() != null ? category.getParent()
								.getId() : 0,
						category.getParent() != null ? category.getParent()
								.getDescription() : "-");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	@Test
	@Ignore
	public void sync() throws DAOException, PersistenceException {
		// categDAO.beginTransaction();
		FileDAO fileDAO = new FileDAO(dao.getConnector());
		Integer defaultID = 7682;// 7529;
		Category parentCateg = dao.getById(defaultID);
		if (parentCateg == null) {
			throw new UnsupportedOperationException(
					"Parent category cannot be null");
		}
		List<File> files = fileDAO.getList(parentCateg);
		for (File f : files) {
			System.out.printf(" --- File: [%d], [%s], [%s]\n", f.getId(),
					f.getDescription(), f.getFileName());
			if (f.getDescription() != null
					&& !parentCateg.getDescription().equals(f.getDescription())) {
				List<Category> c2 = dao.getList(parentCateg,
						f.getDescription(), null, null, null, null);
				Category c3 = null;
				System.out.printf(" ... ");
				if (c2.size() > 0) {
					c3 = c2.get(0);
					System.out.printf("	    - existing category found [%d]\n",
							c3.getId());
				} else {
					System.out.printf("	    - creating new category\n");
					c3 = new Category();
					c3.setParent(parentCateg);
					c3.setDescription(f.getDescription());
					c3.setActive(true);
					c3.setModificationTime(Calendar.getInstance().getTime());
					c3.setCategoryType(CategoryTypeEnum.SEARCH_RESTRICTED);
					c3.setOrder(1);
					dao.saveOrUpdate(c3);
				}
				cn.beginTransaction();
				f.setCategory(c3);
				fileDAO.saveOrUpdate(f);
				cn.commitTransaction();
			}
		}
	}
}
