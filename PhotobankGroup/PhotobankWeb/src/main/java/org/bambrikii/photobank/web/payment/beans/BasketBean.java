package org.bambrikii.photobank.web.payment.beans;

import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bambrikii.payment.gateways.roboxchange.RoboxchangeServiceException;
import org.bambrikii.photobank.business.managers.FileDimensionManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.managers.PhotoOrderManager;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.UserManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;
import org.bambrikii.site.base.payment.model.Price;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.springframework.util.StringUtils;

public class BasketBean extends SiteBaseBean {
	public static final String DIMENSION_ORDER_ITEM_PROPERTY = "dim";
	private RobocashBean robocashBean;

	public void setRobocashBean(RobocashBean robocashBean) {
		this.robocashBean = robocashBean;
	}

	public RobocashBean getRobocashBean() {
		return robocashBean;
	}

	public User getUser(Map<?, ?> session) throws ManagerException {
		UserManager usrMgr = (UserManager) this.getContainer().getManager(
				UserManager.class);
		Integer userId = (Integer) session.get(AuthBean.USER_ID_KEY);
		User user = usrMgr.getById(userId);
		return user;
	}

	public PhotoOrder getOrder(Map<?, ?> session) throws WebException {
		try {
			PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
					.getManager(PhotoOrderManager.class);
			User user = getUser(session);
			PhotoOrder order = mgr.getCurrentOrder(user, true);
			if (order == null) {
				order = new PhotoOrder();
				order.setClient(user);
				order.setStatus(OrderStatusEnum.NEW);
				mgr.saveOrUpdate(order);
			}
			return order;
		} catch (ManagerException ex) {
			throw new WebException("Cannot instantiate OrderManager", ex);
		}
	}

	public Pager<PhotoOrderItem> getItemsPager(PhotoOrder order, int currPage)
			throws WebException, ManagerException {
		PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
				.getManager(PhotoOrderManager.class);
		return mgr.getItemsPager(order, currPage);
	}

	public void removeItem(PhotoOrder order, int itemId) throws WebException {
		try {
			this.getContainer().begin();
			try {
				PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
						.getManager(PhotoOrderManager.class);
				PhotoOrderItem item1 = mgr.getItemById(itemId);
				order.getItems().remove(item1);
				mgr.saveOrUpdate(order);
				this.getContainer().commit();
			} catch (Exception ex) {
				this.getContainer().rollback();
				throw new WebException("Cannot delete OrderItem!", ex);
			}
		} catch (ManagerException ex2) {
			throw new WebException("Failed to initialize transaction!", ex2);
		}
	}

	public String formatItemName(PhotoOrderItem item) throws ManagerException {
		return MessageFormat.format("{0}", item.getFile().getCategory()
				.getDescription());
	}

	public void addItem(PhotoOrder order, Integer fileId, Integer itemDimension)
			throws WebException {
		try {
			this.getContainer().begin();
			FileManager fileMgr = (FileManager) this.getContainer().getManager(
					FileManager.class);
			File file = fileMgr.getById(fileId);
			try {
				PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
						.getManager(PhotoOrderManager.class);
				FileDimensionManager filePriceMgr = (FileDimensionManager) this
						.getContainer().getManager(FileDimensionManager.class);
				PhotoOrderItem item1 = mgr.createItem(order, file,
						filePriceMgr.getById(itemDimension));
				item1.setName(formatItemName(item1));
				this.getContainer().commit();
			} catch (Exception ex) {
				this.getContainer().rollback();
				throw new WebException("Cannot add OrderItem!", ex);
			}
		} catch (ManagerException ex2) {
			throw new WebException("Failed to initialize transaction!", ex2);
		}
	}

	public void updateItem(Integer itemId, Integer itemDimension)
			throws WebException {
		try {
			this.getContainer().begin();
			try {
				PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
						.getManager(PhotoOrderManager.class);
				FileDimensionManager filePriceMgr = (FileDimensionManager) this
						.getContainer().getManager(FileDimensionManager.class);
				PhotoOrderItem item = mgr.getItemById(itemId);
				item.setName(formatItemName(item));
				item.setDimension(filePriceMgr.getById(itemDimension));
				mgr.saveOrUpdateOrderItem(item);
				this.getContainer().commit();
			} catch (Exception ex) {
				this.getContainer().rollback();
				throw new WebException("Cannot update OrderItem!", ex);
			}
		} catch (ManagerException ex2) {
			throw new WebException("Failed to initialize transaction!", ex2);
		}
	}

	public PhotoOrderItem getItemById(int itemId) throws ManagerException {
		PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
				.getManager(PhotoOrderManager.class);
		return mgr.getItemById(itemId);
	}

	public Pager<Object[]> getBasketPager(Map<?, ?> session, Currency currency,
			Integer currPage) throws Exception {
		User user = getUser(session);

		PhotoOrderManager mgr = (PhotoOrderManager) this.getContainer()
				.getManager(PhotoOrderManager.class);
		Pager<Object[]> baskets = mgr.getOrders(user, visibleStatuses,
				currency, currPage);
		return baskets;
	}

	public static List<OrderStatusEnum> visibleStatuses = new ArrayList<OrderStatusEnum>() {
		private static final long serialVersionUID = -5546606592037723245L;
		{
			add(OrderStatusEnum.CONFIRMED_BY_CLIENT);
			add(OrderStatusEnum.PENDING);
			add(OrderStatusEnum.APPROVED);
			add(OrderStatusEnum.CANCELLED);
			add(OrderStatusEnum.REJECTED);
		}
	};

	public String getDimensionPricesSummary(Integer dimensionId)
			throws ManagerException, NumberFormatException, RemoteException,
			RoboxchangeServiceException {
		FileDimensionManager filePriceMgr = (FileDimensionManager) this
				.getContainer().getManager(FileDimensionManager.class);
		return getDimensionPricesSummary(filePriceMgr.getById(dimensionId));
	}

	public String getDimensionPricesSummary(FileDimension dim) {
		List<String> list1 = new ArrayList<String>();
		for (Price price : dim.getPrices()) {
			list1.add(price.getValue() + " "
					+ price.getCurrency().getDisplayName());
		}
		return StringUtils.arrayToDelimitedString(list1.toArray(), " / ");
	}

	public BasketSummary getBasketSummary(PhotoOrder order)
			throws ManagerException {
		PhotoOrderManager mgr = (PhotoOrderManager) getContainer().getManager(
				PhotoOrderManager.class);
		return mgr.getBasketSummary(order);
	}

	public void emptyBaskey(PhotoOrder order) throws Exception {
		order.getItems().clear();
		PhotoOrderManager mgr = (PhotoOrderManager) getContainer().getManager(
				PhotoOrderManager.class);
		getContainer().begin();
		try {
			mgr.saveOrUpdate(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed to clean order");
		}
	}
}
