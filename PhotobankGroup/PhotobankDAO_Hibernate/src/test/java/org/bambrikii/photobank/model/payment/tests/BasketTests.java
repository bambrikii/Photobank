package org.bambrikii.photobank.model.payment.tests;

import java.util.List;

import org.bambrikii.photobank.payment.dao.PhotoOrderDAO;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.payment.dao.CurrencyDAO;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;

public class BasketTests extends DAOTestBase<PhotoOrderDAO> {

	private UserDAO userDao;
	private CurrencyDAO currencyDao;


	@Before
	public void before() throws DAOException{
		super.before();
		userDao	= new UserDAO(cn);
		currencyDao = new CurrencyDAO(cn);
	}

	private void printList(List<Object[]> list1){
		System.out.printf("--- size: %s\n", list1.size());
		for (Object[] l2 : list1) {
			for (Object str2 : l2) {
				System.out.printf("%s, ", str2);
			}
			System.out.printf("\n");
		}
	}

	@Test
	public void listBasketTest() {

		User user	= userDao.getByLogin("asd");
		Currency currency = currencyDao.getByCode("OceanBankR");

		Query q1 = dao
				.getConnector()
				.getSession()
				.createQuery(
						"select " +
						"	o1, " +
						"	curr1, " +
						"	sum(pr1.value) " +
						" from " +
						"	PhotoOrder o1 " +
						"	inner join o1.items as oi1 " +
						"	inner join oi1.dimension dim1 " +
						"	inner join dim1.prices pr1 " +
						"	inner join pr1.currency curr1 " +
						"	" +
						" where o1.client = :user or 1=1" +
						"	and curr1 = :currency"

						).setParameter("user", user).setParameter("currency", currency);
		@SuppressWarnings("unchecked")
		List<Object[]> list1 = q1.list();
		printList(list1);
	}

	@Test
	public void listBaskets(){
		User user	= userDao.getByLogin("asd");
		Currency currency = currencyDao.getByCode("OceanBankR");
		List<Object[]> list1 = dao.getBaskets(user, currency, 0, 25);
		printList(list1);
	}

	@Test
	public void listCurrentBasketItems(){
		User user	= userDao.getByLogin("asd");
		Currency currency = currencyDao.getByCode("OceanBankR");
		List<Object[]> list1 = dao.getBasketItems(user, currency, 0, 25);
		printList(list1);
	}

	@Test
	public void getBasketSummaryTest(){
		User user	= userDao.getByLogin("asd");
		PhotoOrder order	= dao.getOrders(user, OrderStatusEnum.NEW, null).get(0);
		List<Object[]> summary = dao.getBasketSummary(order);
		printList(summary);
	}
}
