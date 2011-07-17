package org.bambrikii.photobank.dao;

import java.util.Date;
import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;

public interface IFileDAO {

	public abstract List<File> getList(Category parent);

	public abstract List<File> getFromSubCategories(Category category,
			Date from, Date till);

	public abstract List<File> getList(Category parent, String fileName);

	// Pager for Events
	public abstract int getFilesCount(Event event);

	public abstract List<File> getFiles(Event event, String order,
			Integer start, Integer length);

	// Pager for Categories
	public abstract int getFilesCount(Category category);

	public abstract List<File> getFiles(Category category, String order,
			int start, int length);

	// FullText search
	public abstract List<File> find(String searchString, String sortOrder,
			Integer start, Integer length);

	public abstract Integer findCount(String searchString);

	public abstract Integer findCount();

	public abstract List<File> find(String order, Integer start, Integer length);

	public abstract List<File> getTopNFiles(Integer n);

	public abstract List<File> getTopNFilesByCounter(Integer n);

}