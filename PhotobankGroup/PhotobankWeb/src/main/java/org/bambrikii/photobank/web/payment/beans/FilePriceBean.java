package org.bambrikii.photobank.web.payment.beans;

import java.util.List;

import org.bambrikii.photobank.business.managers.CurrencyManager;
import org.bambrikii.photobank.business.managers.FileDimensionManager;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudBean;

public class FilePriceBean extends
		BaseCrudBean<FileDimension, FileDimensionManager> {

	public Pager<FileDimension> getDimensions(String sortOrder,
			Integer requestedPage) throws ManagerException {
		return getManager().getPager(sortOrder, requestedPage);
	}

	public List<Currency> getAllActiveCurrencies() throws ManagerException {
		CurrencyManager currMgr = (CurrencyManager) this.getContainer()
				.getManager(CurrencyManager.class);
		return currMgr.getCurrencies(true);
	}

	public Currency getCurrencyById(Integer id) throws ManagerException {
		CurrencyManager currMgr = (CurrencyManager) this.getContainer()
				.getManager(CurrencyManager.class);
		return currMgr.getCurrencyById(id);
	}
}
