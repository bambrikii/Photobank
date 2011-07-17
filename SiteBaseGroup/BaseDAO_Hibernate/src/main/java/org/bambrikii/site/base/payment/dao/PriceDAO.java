package org.bambrikii.site.base.payment.dao;

import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.payment.model.Price;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class PriceDAO extends DAOBase<Price> implements IPriceDAO {
	public PriceDAO(PersistenceConnector connector) {
		super(connector);
	}
}
