package org.bambrikii.photobank.model.tests;

import java.util.List;

import org.bambrikii.photobank.dao.FileDimensionDAO;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.payment.dao.CurrencyDAO;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTests extends DAOTestBase<CurrencyDAO> {
	private FileDimensionDAO fileDimDao;

	@Before
	public void before() throws DAOException {
		super.before();
		fileDimDao = new FileDimensionDAO(cn);
	}

	@Test
	public void readCurrencyTest() {
		List<Currency> list = dao.getList();
		for (Currency curr : list) {
			System.out.printf("	%s, %s, %s, %s, %s\n", curr.getId(),
					curr.getName(), curr.getActive(), curr.getCode(),
					curr.getSign());
		}
	}

	@Test
	public void readFileDimensionPrices() {
		List<FileDimension> dims = fileDimDao.getList();
		for (FileDimension dim : dims) {
			System.out.printf("	%s, %s, %s\n", dim.getId(), dim.getName(),
					dim.getOrder());
			if (dim.getPrices() != null) {
				for (Price price : dim.getPrices()) {
					Currency curr	= price.getCurrency();
					System.out.printf("		%s, %s\n", curr.getCode(), price.getValue());
				}
			}
		}
	}

	@Test
	public void getByCodeTest() {
		List<Currency> currs = dao.getList(true);
		Assert.assertTrue("No active currencies found", currs.size() > 0);
		for (Currency curr : currs) {
			Currency currByCode = dao.getByCode(curr.getCode());
			Assert.assertEquals("Cannot find currency by code", curr,
					currByCode);
		}
	}
}
