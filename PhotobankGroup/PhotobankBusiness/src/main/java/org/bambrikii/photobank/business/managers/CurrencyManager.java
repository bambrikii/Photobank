package org.bambrikii.photobank.business.managers;

import java.util.List;

import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.payment.dao.CurrencyDAO;
import org.bambrikii.site.base.payment.model.Currency;

public class CurrencyManager extends ManagerBase<Currency, CurrencyDAO> {

	public CurrencyManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public List<Currency> getCurrencies(Boolean activeOnly) {
		return dao.getList(activeOnly);
	}

	public Currency getCurrencyById(Integer id) {
		return dao.getById(id);
	}

	public Currency getByCode(String code) {
		return dao.getByCode(code);
	}
}
