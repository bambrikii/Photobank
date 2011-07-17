package org.bambrikii.photobank.business.tests;

import java.util.List;

import org.bambrikii.photobank.business.managers.FileDimensionManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.managers.PhotoOrderManager;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.UserManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhotoOrderManagerTests extends ManagerTestBase<PhotoOrderManager> {
	public static String TEST_LOGIN = "asd";
	public static int TEST_CATEGORY_ID = 1;// 38;
	private UserManager usrMgr;
	private FileManager fileMgr;
	private FileDimensionManager fileDimMgr;
	private User client;
	private Category categ;
	private List<File> files;
	private List<FileDimension> fileDims;

	@Before
	public void before() throws ManagerException {
		super.before();
		usrMgr = (UserManager) container.getManager(UserManager.class);

		fileMgr = (FileManager) container.getManager(FileManager.class);
		fileDimMgr = (FileDimensionManager) container
				.getManager(FileDimensionManager.class);
		Pager<File> filesPager = fileMgr.find(null, null, 0, null);
		client = usrMgr.getUserByLogin(TEST_LOGIN);
		TEST_CATEGORY_ID = filesPager.getRecords().get(0).getCategory().getId();
		categ = filesPager.getRecords().get(0).getCategory();
		fileDims = fileDimMgr.getList();

		files = categ.getFiles();
	}

	private PhotoOrder getNewOrder() throws ManagerException {
		container.begin();
		PhotoOrder order = mgr.create(client);
		mgr.saveOrUpdate(order);
		for (File file : files) {
			PhotoOrderItem oi = mgr.createItem(order, file, fileDims.get(0));
			mgr.saveOrUpdateOrderItem(oi);
		}
		mgr.saveOrUpdate(order);
		container.commit();
		return order;
	}

	private void deleteOrder(PhotoOrder order) throws ManagerException {
		container.begin();
		mgr.delete(order);
		container.commit();
	}

	@Test
	public void crudTest() throws ManagerException {
		PhotoOrder order = getNewOrder();
		Assert.assertTrue("Order id should have been set after save!",
				order.getId() > 0);

		Assert.assertEquals(
				"Number of files and order items should be equal here!",
				files.size(), order.getItems().size());
		List<OrderItem> orderItems = order.getItems();
		int id = order.getId();

		System.out.printf("Order:	%s, %s, %s\n", order.getId(),
				order.getStatus(), order.getClient().getLogin());
		for (OrderItem orderItem : orderItems) {
			System.out.printf("OrderItem:	%s, %s, %s\n", orderItem.getId(),
					orderItem.getName(), ((PhotoOrderItem) orderItem).getFile()
							.getFileName());
		}
		// ?
		deleteOrder(order);
		PhotoOrder order2 = mgr.getById(id);
		Assert.assertEquals("Order should have been deleted!", order2, null);
	}

	@Test
	public void getOrderItemPager() throws Exception {
		PhotoOrder order = getNewOrder();
		container.begin();
		try {
			Pager<PhotoOrderItem> pgr = mgr.getItemsPager(order, 0);
			List<PhotoOrderItem> items = pgr.getRecords();
			Assert.assertEquals("Total records count evaluated failed!",
					(Integer) files.size(), pgr.getTotalRecordsCount());
			Assert.assertTrue("No records fetched!",
					(pgr.getRecords().size() > 0)
							&& (pgr.getRecords().size() <= files.size()));
			System.out.printf("Pager<OrderItem>: %s, %s\n",
					pgr.getTotalRecordsCount(), pgr.getRecords().size());
			for (PhotoOrderItem item : items) {
				System.out.printf("\t%s, %s, %s, %s\n", item.getId(), item
						.getName(), ((PhotoOrderItem) item).getFile()
						.getFileName(), item.getOrder());
			}
			container.commit();
		} catch (Exception ex) {
			container.rollback();
			throw new Exception("Exception in test.", ex);
		}
		deleteOrder(order);
	}

	@Test
	public void getUserCurrentOrder() throws ManagerException {
		PhotoOrder order;
		order = mgr.getCurrentOrder(client, true);
		if (order != null) {
			deleteOrder(order);
		}
	}

	@Test
	public void clearOrderItemsTest() throws ManagerException {
		PhotoOrder order = mgr.getCurrentOrder(client, true);
		if (order == null) {
			order = getNewOrder();
		}
		if (order.getItems().size() == 0) {
			container.begin();
			PhotoOrderItem oi = mgr.createItem(order, files.get(0),
					fileDims.get(0));
			mgr.saveOrUpdateOrderItem(oi);
			order.getItems().add(oi);
			mgr.saveOrUpdate(order);
			container.commit();
		}

		Assert.assertNotSame("Some items should exist", 0, order.getItems()
				.size());

		container.begin();
		order.getItems().clear();
		mgr.saveOrUpdate(order);
		container.commit();

		Assert.assertEquals("Here no records should exists.", 0, order
				.getItems().size());
	}

	@Test
	public void deleteOrderItemTest() throws ManagerException {
		PhotoOrder order = mgr.getCurrentOrder(client, true);
		if (order == null) {
			order = getNewOrder();
			container.begin();
			order.getItems().clear();
			mgr.saveOrUpdate(order);
			PhotoOrderItem oi = mgr.createItem(order, files.get(0),
					fileDims.get(0));
			mgr.saveOrUpdateOrderItem(oi);
			container.commit();
		} else {
			container.begin();
			mgr.saveOrUpdate(order);
			order.getItems().clear();
			mgr.saveOrUpdate(order);
			container.commit();

			Assert.assertEquals("Here no records should exists.", 0, order
					.getItems().size());

			container.begin();
			PhotoOrderItem item = new PhotoOrderItem();
			File file2 = files.get(0);
			item.setFile(file2);
			item.setDimension(fileDims.get(0));
			item.setName(file2.getFileName());
			order.getItems().add(item);
			mgr.saveOrUpdate(order);
			container.commit();

			Assert.assertTrue("OrderItem has not acquired valid identifier.",
					item.getId() != 0);
		}

		System.out.printf(" number of items: %s\n", order.getItems().size());

		Assert.assertEquals("Only one OrderItem should exist here.", 1, order
				.getItems().size());

		container.begin();
		order.getItems().clear();
		mgr.saveOrUpdate(order);
		container.commit();

		System.out.printf(" number of items: %s\n", order.getItems().size());

		Assert.assertEquals("No OrderItem should exist here.", 0, order
				.getItems().size());
	}

	@Test
	public void getBasketSummaryTest() throws ManagerException {
		PhotoOrder order = mgr.getCurrentOrder(client);
		BasketSummary summ = mgr.getBasketSummary(order);
		for (Currency curr : summ.getPrices().keySet()) {
			System.out.printf("	%s, %s\n", curr.getCode(), summ.getPrices()
					.get(curr));
		}
	}
}
