package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;

public interface ICategoryDAO {

	public abstract Integer getListCount(Category parentCategory, String name,
			CategoryTypeEnum categoryType);

	public abstract List<Category> getList(Category parent, String name,
			CategoryTypeEnum categoryType);

	public abstract List<Category> getList(Category parent, String name,
			CategoryTypeEnum categoryType, String order, Integer start,
			Integer length);

}