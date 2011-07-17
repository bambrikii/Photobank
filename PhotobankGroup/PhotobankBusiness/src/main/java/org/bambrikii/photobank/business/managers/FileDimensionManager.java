package org.bambrikii.photobank.business.managers;

import java.util.List;

import org.bambrikii.photobank.dao.FileDimensionDAO;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.dao.CurrencyDAO;

public class FileDimensionManager extends
		ManagerBase<FileDimension, FileDimensionDAO> {
	private static Pager<FileDimension> pager = new Pager<FileDimension>(1, 50);

	public FileDimensionManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
		new CurrencyDAO(connector.getPersistenceConnector());
	}

	public List<FileDimension> getDimensions() {
		return dao.getList(true, "order");
	}

	public FileDimension getDimensionById(Integer id) {
		return dao.getById(id);
	}

	public Pager<FileDimension> getPager(String sortOrder, Integer currentPage) {
		Pager<FileDimension> pg = pager.clone();
		pg.setCurrPage(currentPage);
		List<FileDimension> dimList = dao.getList(sortOrder, pg.getStart(),
				pg.getLength());
		pg.setTotalRecordsCount(dimList.size());
		pg.setRecords(dimList);
		return pg;
	}

	public List<FileDimension> getList() {
		return dao.getList(true, "order");
	}
}
