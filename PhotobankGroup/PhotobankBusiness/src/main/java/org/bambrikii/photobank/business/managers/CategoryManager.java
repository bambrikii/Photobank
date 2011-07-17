package org.bambrikii.photobank.business.managers;

import java.util.Calendar;
import java.util.List;

import org.bambrikii.photobank.dao.CategoryDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;

public class CategoryManager extends ManagerBase<Category, CategoryDAO> {

	public CategoryManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public Pager<Category> pager = new Pager<Category>(3, 5);

	public List<Category> getList(Category parent) {
		return dao.getList(parent, null, null, "modificationTime DESC", null,
				null);
	}

	public List<Category> getList(Category parent, String name,
			CategoryTypeEnum categoryType) {
		return dao.getList(parent, name, categoryType);
	}

	@Override
	public void saveOrUpdate(Category category) throws ManagerException {
		category.setModificationTime(Calendar.getInstance().getTime());
		super.saveOrUpdate(category);
	}

	public Pager<Category> getCategoriesPager(Category parentCategory,
			CategoryTypeEnum categoryType, Integer currPage) {
		Pager<Category> pg = pager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getListCount(parentCategory, null,
				categoryType));
		pg.setRecords(dao.getList(parentCategory, null, categoryType,
				"order, modificationTime DESC", pg.getStart(), pg.getLength()));
		return pg;
	}
}
