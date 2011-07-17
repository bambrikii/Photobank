package org.bambrikii.photobank.model.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.dao.FileDimensionDAO;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.payment.dao.CurrencyDAO;
import org.bambrikii.site.base.payment.dao.PriceDAO;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.Price;
import org.junit.Before;
import org.junit.Test;

public class FileDimTests extends DAOTestBase<FileDimensionDAO> {

	private class CurrencyValuePair {
		private Currency currency;
		private Double value;

		public Currency getCurrency() {
			return currency;
		}

		public void setCurrency(Currency currency) {
			this.currency = currency;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	}

	private CurrencyDAO currencyDao;
	private PriceDAO priceDao;

	@Before
	public void before() throws DAOException {
		super.before();
		currencyDao = new CurrencyDAO(cn);
		priceDao = new PriceDAO(cn);
	}

	private void checkFileDimension(String name, Integer maxDim, Integer order, List<CurrencyValuePair> pairs) {

		FileDimension fileDim1 = dao.getByName(name);
		if (fileDim1 == null) {
			fileDim1 = new FileDimension();
			fileDim1.setName(name);
			fileDim1.setActive(true);
			fileDim1.setMaxDim(maxDim);
			fileDim1.setOrder(order);
			dao.saveOrUpdate(fileDim1);
		} else if (!(fileDim1.getActive() || fileDim1.getMaxDim().equals(maxDim) || fileDim1
				.getOrder().equals(order))) {
			fileDim1.setMaxDim(maxDim);
			fileDim1.setActive(true);
			fileDim1.setOrder(order);
			dao.saveOrUpdate(fileDim1);
		}

		if (fileDim1.getPrices() == null) {
			fileDim1.setPrices(new ArrayList<Price>());
		}

		for (CurrencyValuePair pair1 : pairs) {
			Boolean currencyExists = false;
			for (Price price1 : fileDim1.getPrices()) {
				if (price1.getCurrency().equals(pair1.getCurrency())) {
					currencyExists = true;
					if (!price1.getValue().equals(pair1.getValue())) {
						price1.setValue(pair1.getValue());
						priceDao.saveOrUpdate(price1);
					}
				}
			}
			if (!currencyExists) {
				Price price2 = new Price();
				price2.setCurrency(pair1.getCurrency());
				price2.setValue(pair1.getValue());
				fileDim1.getPrices().add(price2);
				dao.saveOrUpdate(fileDim1);
			}
		}
	}

	@Test
	public void createDefaultDimensionsWithPricesTests() throws Exception {
		cn.beginTransaction();
		try {
			Currency rur = currencyDao.getByCode("OceanBankR");
			Assert.assertNotNull(rur);

			// web
			final CurrencyValuePair pair1 = new CurrencyValuePair();
			pair1.setCurrency(rur);
			pair1.setValue(150.0);
			checkFileDimension("web", 650, 10, new ArrayList<CurrencyValuePair>() {
				private static final long serialVersionUID = 1L;
				{
					add(pair1);
				}
			});

			// 10x15 cm
			final CurrencyValuePair pair2 = new CurrencyValuePair();
			pair2.setCurrency(rur);
			pair2.setValue(300.0);
			checkFileDimension("10x15 cm", 0, 20, new ArrayList<CurrencyValuePair>() {
				private static final long serialVersionUID = 1L;
				{
					add(pair2);
				}
			});

		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
	}

}
