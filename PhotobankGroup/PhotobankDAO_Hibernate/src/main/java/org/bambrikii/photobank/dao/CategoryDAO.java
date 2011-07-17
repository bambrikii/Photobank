package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class CategoryDAO extends DAOBase<Category> implements ICategoryDAO {

	public CategoryDAO(PersistenceConnector connector) {
		super(connector);
	}

	protected Criteria getCategoriesCriteria(Category parent, String name,
			CategoryTypeEnum categoryType) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		if (parent != null) {
			criteria.add(Restrictions.eq("parent", parent));
		}
		if (name != null) {
			criteria.add(Restrictions.like("description", name));
		}
		if (categoryType != null) {
			criteria.add(Restrictions.eq("categoryType", categoryType));
		}
		criteria.add(Restrictions.eq("active", true));
		return criteria;
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.ICategoryDAO#getListCount(org.bambrikii.photobank.model.Category, java.lang.String, org.bambrikii.photobank.model.CategoryTypeEnum)
	 */
	@Override
	public Integer getListCount(Category parentCategory, String name,
			CategoryTypeEnum categoryType) {
		Criteria criteria = getCategoriesCriteria(parentCategory, name,
				categoryType);
		return getCount(criteria);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.ICategoryDAO#getList(org.bambrikii.photobank.model.Category, java.lang.String, org.bambrikii.photobank.model.CategoryTypeEnum)
	 */
	@Override
	public List<Category> getList(Category parent, String name,
			CategoryTypeEnum categoryType) {
		return getList(parent, name, categoryType,
				"order, modificationTime DESC", 0, 0);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.ICategoryDAO#getList(org.bambrikii.photobank.model.Category, java.lang.String, org.bambrikii.photobank.model.CategoryTypeEnum, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Category> getList(Category parent, String name,
			CategoryTypeEnum categoryType, String order, Integer start,
			Integer length) {
		Criteria criteria = getCategoriesCriteria(parent, name, categoryType);
		return getList(criteria, order, start, length);
	}
}
