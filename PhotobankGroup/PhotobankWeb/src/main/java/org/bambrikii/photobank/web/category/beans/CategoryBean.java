package org.bambrikii.photobank.web.category.beans;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudBean;

public class CategoryBean extends BaseCrudBean<Category, CategoryManager> {
	public Pager<Category> getCategories(Category parentCategory, int currPage)
			throws WebException {
		try {
			CategoryManager mgr = (CategoryManager) getContainer().getManager(
					CategoryManager.class);
			Pager<Category> pager = mgr.getCategoriesPager(parentCategory,
					parentCategory != null ? null : CategoryTypeEnum.MAIN,
					currPage);
			return pager;
		} catch (ManagerException ex) {
			throw new WebException("Cannot list categories.", ex);
		}
	}

	public Category getCategory(Integer id) throws WebException {
		try {
			CategoryManager mgr = (CategoryManager) getContainer().getManager(
					CategoryManager.class);
			Category category = mgr.getById(id);
			return category;
		} catch (ManagerException ex) {
			throw new WebException("Cannot get category.", ex);
		}
	}

	public Pager<File> getFiles(Category category, int requestedPage)
			throws WebException {
		try {
			FileManager mgr = (FileManager) getContainer().getManager(
					FileManager.class);
			Pager<File> pager = mgr.getFilesPager(category, requestedPage);
			return pager;
		} catch (ManagerException ex) {
			throw new WebException("Cannot get category.", ex);
		}
	}
}
