package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.FileDimension;

public interface IFileDimensionDAO {

	public abstract List<FileDimension> getList(Boolean active, String order);

	public abstract FileDimension getByName(String name);

}