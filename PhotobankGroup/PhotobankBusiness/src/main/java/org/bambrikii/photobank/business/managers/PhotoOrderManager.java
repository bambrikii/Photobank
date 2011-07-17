package org.bambrikii.photobank.business.managers;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.payment.dao.PhotoOrderDAO;
import org.bambrikii.photobank.payment.dao.PhotoOrderItemDAO;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;

public class PhotoOrderManager extends ManagerBase<PhotoOrder, PhotoOrderDAO> {
	private PhotoOrderItemDAO photoOrderItemDao;
	private Pager<PhotoOrderItem> itemsPager = new Pager<PhotoOrderItem>(1, 25);
	private Pager<Object[]> basketPager = new Pager<Object[]>(1, 25);

	public PhotoOrderManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
		photoOrderItemDao = new PhotoOrderItemDAO(
				connector.getPersistenceConnector());
	}

	public PhotoOrder create(User client) {
		PhotoOrder order = new PhotoOrder();
		order.setClient(client);
		order.setModificationTime(Calendar.getInstance().getTime());
		order.setStatus(OrderStatusEnum.NEW);
		return order;
	}

	public PhotoOrderItem createItem(PhotoOrder order, File file,
			FileDimension fileDim) {
		PhotoOrderItem item = new PhotoOrderItem();
		item.setName(MessageFormat.format("{0} ({1})", file.getFileName(),
				file.getDescription()));
		item.setFile(file);
		item.setDimension(fileDim);
		dao.refresh(order);
		order.getItems().add(item);
		return item;
	}

	public void saveOrUpdate(PhotoOrder order) {
		order.setModificationTime(Calendar.getInstance().getTime());
		dao.saveOrUpdate(order);
	}

	public void confirmByClient(PhotoOrder order) {
		order.setStatus(OrderStatusEnum.CONFIRMED_BY_CLIENT);
		saveOrUpdate(order);
	}

	public void checkout(PhotoOrder order) {
		order.setStatus(OrderStatusEnum.PENDING);
		saveOrUpdate(order);
	}

	public void approve(PhotoOrder order) {
		order.setStatus(OrderStatusEnum.APPROVED);
		dao.saveOrUpdate(order);
	}

	public void reject(PhotoOrder order) {
		order.setStatus(OrderStatusEnum.REJECTED);
		dao.saveOrUpdate(order);
	}

	public void delete(PhotoOrder order) {
		dao.delete(order);
	}

	public PhotoOrder getCurrentOrder(User user) throws ManagerException {
		return getCurrentOrder(user, false);
	}

	public PhotoOrder getCurrentOrder(User user, boolean cleanOldOnes)
			throws ManagerException {
		List<PhotoOrder> orders = dao.getOrders(user, OrderStatusEnum.NEW,
				"modificationTime DESC");
		int n = orders.size();
		switch (orders.size()) {
		case 0:
			return null;
		case 1:
			return orders.get(0);
		default:
			if (cleanOldOnes) {
				for (int index = 1; index < n - 1; index++) {
					PhotoOrder order = orders.get(index);
					delete(order);
				}
				return orders.get(0);
			} else {
				throw new ManagerException(
						"Only one or zero orders expected, but more than one found!");
			}
		}
	}

	public Pager<PhotoOrderItem> getItemsPager(PhotoOrder order, int currPage) {
		Pager<PhotoOrderItem> pgr = itemsPager.clone();
		pgr.setCurrPage(currPage);
		pgr.setTotalRecordsCount(photoOrderItemDao.getCount(order));
		pgr.setRecords(photoOrderItemDao.getList(order, null, pgr.getStart(),
				pgr.getLength()));
		return pgr;
	}

	public void saveOrUpdateOrderItem(PhotoOrderItem item) {
		photoOrderItemDao.saveOrUpdate(item);
	}

	public PhotoOrderItem getItemById(int itemId) {
		return photoOrderItemDao.getById(itemId);
	}

	private Pager<PhotoOrder> orderPager = new Pager<PhotoOrder>(1, 150);

	// Order administering
	public Pager<PhotoOrder> getOrderPager(User user,
			List<OrderStatusEnum> status, String sortOrder, Integer currPage) {
		Pager<PhotoOrder> pg = orderPager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getCount(user, status));
		pg.setRecords(dao.getList(user, status, sortOrder, pg.getStart(),
				pg.getLength()));
		return pg;
	}

	public PhotoOrderItem getOrderItem(Integer orderItemId, Integer userId) {
		return photoOrderItemDao.getItem(orderItemId, userId);
	}

	// Basket
	public Pager<Object[]> getOrders(User user, List<OrderStatusEnum> status,
			Currency currency, int currPage) {
		Pager<Object[]> pgr = basketPager.clone();
		pgr.setCurrPage(currPage);
		pgr.setTotalRecordsCount(dao.getCount(user, status));
		pgr.setRecords(dao.getBaskets(user, currency, pgr.getStart(),
				pgr.getLength()));
		return pgr;
	}

	public BasketSummary getBasketSummary(PhotoOrder order) {
		BasketSummary sum = new BasketSummary();
		List<Object[]> sum2 = dao.getBasketSummary(order);
		for (Object[] obj : sum2) {
			sum.getPrices().put((Currency) obj[0], (Double) obj[1]);
		}
		return sum;
	}
}
