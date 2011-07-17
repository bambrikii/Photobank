package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;

public interface IIpticGroupDAO {

	public abstract List<Category> listCategoriesWithIptcFiles();

}