package org.bambrikii.site.base.core.dao;

import java.util.List;
import java.util.Set;

public interface IDAOBase<T> {

	public abstract void saveOrUpdate(T obj);

	public abstract void delete(T obj);

	public abstract List<T> getList();

	public abstract List<T> getList(String order);

	public abstract List<T> getList(String order, Integer start, Integer length);

	public abstract T getById(Integer id);

	public abstract List<T> getByIds(Set<Integer> ids);

}