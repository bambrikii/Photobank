package org.bambrikii.site.base.core.dao;

public interface IDAOPageBuilder<T> {

	public abstract void addRestrictionLike(String propertyName, Object value);

}