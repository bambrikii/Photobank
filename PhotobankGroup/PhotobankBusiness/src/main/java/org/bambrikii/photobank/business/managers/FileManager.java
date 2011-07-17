package org.bambrikii.photobank.business.managers;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.bambrikii.photobank.dao.FileDAO;
import org.bambrikii.photobank.dao.FileDimensionDAO;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;

public class FileManager extends ManagerBase<File, FileDAO> {
	public FileManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		new FileDimensionDAO(connector.getPersistenceConnector());
	}

	private static Pager<File> pager = new Pager<File>(5, 5);

	public static Pager<File> getPager() {
		return pager;
	}

	public Pager<File> find(String searchString, String order,
			Integer currPage, Integer topRecords) {
		Pager<File> pgr = pager.clone();
		pgr.setCurrPage(currPage);
		return find(pgr, searchString, order, topRecords);
	}

	public Pager<File> find(Pager<File> pager, String searchString,
			String order, Integer topRecords) {
		Integer totalRecords = dao.findCount(searchString);
		pager.setTotalRecordsCount(topRecords != null
				&& topRecords < totalRecords ? topRecords : totalRecords);
		pager.setRecords(dao.find(searchString, order, pager.getStart(),
				pager.getLength()));
		return pager;
	}

	public Pager<File> find(Pager<File> pager, String order, Integer topRecords) {
		Integer totalRecords = dao.findCount();
		pager.setTotalRecordsCount(topRecords != null
				&& topRecords < totalRecords ? topRecords : totalRecords);
		pager.setRecords(dao.find(order, pager.getStart(), pager.getLength()));
		return pager;
	}

	public List<File> getByIds(Set<Integer> ids) {
		return dao.getByIds(ids);
	}

	public List<File> getList(Category parent, String fileName) {
		return dao.getList(parent, fileName);
	}

	@Override
	public void saveOrUpdate(File file) throws ManagerException {
		file.setModificationTime(Calendar.getInstance().getTime());
		super.saveOrUpdate(file);
	}

	public Pager<File> getFilesPager(Event event, Integer currPage) {
		Pager<File> pg = pager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getFilesCount(event));
		pg.setRecords(dao.getFiles(event, "modificationTime DESC",
				pg.getStart(), pg.getLength()));
		return pg;
	}

	public Pager<File> getFilesPager(Category category, Integer currPage) {
		Pager<File> pg = pager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getFilesCount(category));
		pg.setRecords(dao.getFiles(category, "modificationTime DESC",
				pg.getStart(), pg.getLength()));
		return pg;
	}

	public List<File> getFiles(Event event, String order) {
		return dao.getFiles(event, order, null, null);
	}

	public List<File> getTopNFiles(Integer n) {
		return dao.getTopNFilesByCounter(n);
	}
}
