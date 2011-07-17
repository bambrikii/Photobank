package org.bambrikii.site.base.core.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DAOPagerBuilder<T> implements IDAOPageBuilder<T> {

	private IDAOBase<T> dao;
	private Criteria criteria;

	public DAOPagerBuilder(IDAOBase<T> dao) {
		setDao(dao);
		setCriteria(((DAOBase<T>) getDao()).getCriteria());
	}

	protected void setDao(IDAOBase<T> dao) {
		this.dao = dao;
	}

	protected IDAOBase<T> getDao() {
		return dao;
	}

	protected void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	protected Criteria getCriteria() {
		return criteria;
	}

	protected void addRestrictionEq(String propertyName, Object value) {
		getCriteria().add(Restrictions.eq(propertyName, value));
	}

	protected void addRestrictionIn(String propertyName, Collection<?> value) {
		getCriteria().add(Restrictions.in(propertyName, value));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.site.base.core.dao.IDAOPageBuilder#addRestrictionLike(java
	 * .lang.String, java.lang.Object)
	 */
	@Override
	public void addRestrictionLike(String propertyName, Object value) {
		getCriteria().add(Restrictions.like(propertyName, value));
	}

	protected Integer getCount() {
		return ((DAOBase<T>) getDao()).getCount(getCriteria());
	}

	protected List<T> getList(String sortOrder, int start, int length) {
		// getCriteria().setProjection(null);
		// getCriteria().setResultTransformer(Criteria.ROOT_ENTITY);
		return ((DAOBase<T>) getDao()).getList(getCriteria(), sortOrder, start,
				length);
	}
}
