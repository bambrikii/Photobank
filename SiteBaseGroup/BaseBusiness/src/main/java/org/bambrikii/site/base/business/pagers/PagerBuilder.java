package org.bambrikii.site.base.business.pagers;

import java.util.Collection;

import org.bambrikii.site.base.core.dao.DAOPagerBuilder;
import org.bambrikii.site.base.core.dao.IDAOBase;

public class PagerBuilder<T> extends DAOPagerBuilder<T> {

	public PagerBuilder(IDAOBase<T> dao) {
		super(dao);
	}

	public PagerBuilder<T> eq(String propertyName, Object value) {
		super.addRestrictionEq(propertyName, value);
		return this;
	}

	public PagerBuilder<T> like(String propertyName, Object value) {
		super.addRestrictionLike(propertyName, value);
		return this;
	}

	public PagerBuilder<T> in(String propertyName, Collection<?> value) {
		super.addRestrictionIn(propertyName, value);
		return this;
	}

	public Pager<T> getPager(int cols, int rows, String sortOrder, int currPage) {
		Pager<T> pager = new Pager<T>(cols, rows, currPage);
		pager.setRecords(getList(sortOrder, pager.getStart(), pager.getLength()));
		pager.setTotalRecordsCount(getCount());
		return pager;
	}
}
