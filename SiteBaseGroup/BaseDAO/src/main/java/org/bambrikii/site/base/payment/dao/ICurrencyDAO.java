package org.bambrikii.site.base.payment.dao;

import java.util.List;

import org.bambrikii.site.base.payment.model.Currency;

public interface ICurrencyDAO {

	public abstract List<Currency> getList(Boolean activeOnly);

	public abstract Currency getByCode(String code);

}