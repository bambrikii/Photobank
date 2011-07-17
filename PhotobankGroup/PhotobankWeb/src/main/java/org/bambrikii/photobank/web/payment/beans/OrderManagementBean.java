package org.bambrikii.photobank.web.payment.beans;

import java.io.ByteArrayOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.bambrikii.photobank.business.managers.PaymentSystemManager;
import org.bambrikii.photobank.business.managers.PhotoOrderManager;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.photobank.web.documents.PaymentCertificateDataItem;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateBuilder;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateData;
import org.bambrikii.photobank.web.documents.paymentcertificates.impl.PaymentCertificateBuilderRU;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderItem;
import org.bambrikii.site.base.payment.model.OrderStatusEnum;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.mailing.beans.MailingBean;

public class OrderManagementBean extends SiteBaseBean {

	private static final String APPROVE_ORDER__TEMPLATE_KEY = ".ru.psfotos.order.approve.mail.templateKey";
	private static final String REJECT_ORDER__TEMPLATE_KEY = ".ru.psfotos.order.reject.mail.templateKey";
	public static final String SITE_URL__CONFIGURATION_KEY = ".ru.psfotos.site.url";
	private MailingBean mailingBean;
	private BasketBean basketBean;

	public void setMailingBean(MailingBean mailingBean) {
		this.mailingBean = mailingBean;
	}

	public MailingBean getMailingBean() {
		return mailingBean;
	}

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	public BasketBean getBasketBean() {
		return basketBean;
	}

	public Pager<PhotoOrder> getOrderPager(User user, Integer currPage)
			throws ManagerException {
		PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
				.getManager(PhotoOrderManager.class);
		Pager<PhotoOrder> orders = orderMgr.getOrderPager(user,
				BasketBean.visibleStatuses, "modificationTime DESC", currPage);
		return orders;
	}

	public PhotoOrder getOrder(Integer orderId) throws Exception {
		PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
				.getManager(PhotoOrderManager.class);
		return orderMgr.getById(orderId);
	}

	public void waitOrder(Integer id) throws Exception {
		getContainer().begin();
		try {
			PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
					.getManager(PhotoOrderManager.class);
			PhotoOrder order = orderMgr.getById(id);
			orderMgr.checkout(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed to set order to pending state", ex);
		}
	}

	public void approveOrder(Integer id, PaymentSystem paymentSystem,
			String appPath) throws Exception {
		getContainer().begin();
		try {
			PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
					.getManager(PhotoOrderManager.class);
			final PhotoOrder order = orderMgr.getById(id);

			final ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
					.getManager(ConfigurationManager.class);
			final User user = order.getClient();
			PaymentCertificateBuilder certsBuilder = new PaymentCertificateBuilderRU();
			certsBuilder.setResourcesPath("file:///" + appPath
					+ "/WEB-INF/classes/");
			PaymentCertificateData certsData = new PaymentCertificateData();

			certsData.setNumber(order.getId());
			certsData.setDate(Calendar.getInstance().getTime());

			String firstname = user.getFirstname();
			String patronymic = user.getPatronymic();
			if (user.getPatronymic() != null
					&& user.getPatronymic().length() > 0) {
				firstname = user.getFirstname() != null
						&& user.getFirstname().length() > 0 ? user
						.getFirstname().substring(0, 1) + "." : "";
				patronymic = user.getPatronymic().substring(0, 1) + ".";
			} else {
				firstname = user.getFirstname();
				patronymic = "";
			}

			certsData.setLicensee(MessageFormat.format("{0} {1}{2}",
					user.getSurname(), firstname, patronymic));

			BasketSummary basketSummary = getBasketBean().getBasketSummary(
					order);
			Currency merchantCurrency = paymentSystem.getCurrency();
			certsData.setCurrency(merchantCurrency.getDisplayName());
			certsData.setTotal(basketSummary.getPrices().get(merchantCurrency));

			List<PaymentCertificateDataItem> items = new ArrayList<PaymentCertificateDataItem>();
			for (final OrderItem item2 : order.getItems()) {
				PaymentCertificateDataItem item3 = new PaymentCertificateDataItem();
				if (item2 instanceof PhotoOrderItem) {
					PhotoOrderItem item4 = (PhotoOrderItem) item2;
					item3.setFilename(PhotoBean.getReadableFileName(item4
							.getFile().getFileName()));
					// TODO: get(0)'s wrong!
					item3.setPrice(item4.getDimension().getPrices().get(0)
							.getValue());
					item3.setSizeName(item4.getDimension().getName());
				}
				item3.setName(item2.getName());
				items.add(item3);
			}
			certsData.setItems(items);

			certsBuilder.setData(certsData);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			certsBuilder.build(bos);
			final DataSource paymentCertDataSource = new ByteArrayDataSource(
					bos.toByteArray(), "application/pdf");
			((ByteArrayDataSource) paymentCertDataSource).setName("OrderCert"
					+ order.getId() + ".pdf");
			getMailingBean().email(
					cfgMgr.getCacheConfigValue(APPROVE_ORDER__TEMPLATE_KEY),
					getMailingBean().getLocale(user), user.getEmail(),
					new ArrayList<DataSource>() {
						private static final long serialVersionUID = -3381972012969473761L;
						{
							add(paymentCertDataSource);
						}
					}, new HashMap<String, Object>() {
						private static final long serialVersionUID = 1L;
						{
							put("firstname", user.getFirstname());
							put("surname", user.getSurname());
							put("order", order);
							put("downloadLink",
									cfgMgr.getCacheConfigValue(SITE_URL__CONFIGURATION_KEY)
											+ "/photoDownload!item.action?id=");
						}
					});
			bos.close();

			orderMgr.approve(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed to approve order", ex);
		}
	}

	public void rejectOrder(Integer id) throws Exception {
		getContainer().begin();
		try {
			PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
					.getManager(PhotoOrderManager.class);
			final PhotoOrder order = orderMgr.getById(id);

			ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
					.getManager(ConfigurationManager.class);
			final User user = order.getClient();
			getMailingBean().email(
					cfgMgr.getCacheConfigValue(REJECT_ORDER__TEMPLATE_KEY),
					getMailingBean().getLocale(user), user.getEmail(),
					new HashMap<String, Object>() {
						private static final long serialVersionUID = 1L;
						{
							put("firstname", user.getFirstname());
							put("surname", user.getSurname());
							put("order", order);
						}
					});

			orderMgr.reject(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed to reject order", ex);
		}
	}

	public void deleteOrder(Integer id) throws Exception {
		getContainer().begin();
		try {
			PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
					.getManager(PhotoOrderManager.class);
			PhotoOrder order = orderMgr.getById(id);
			orderMgr.delete(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed delete order", ex);
		}
	}

	public void saveOrder(PhotoOrder order) throws Exception {
		getContainer().begin();
		try {
			PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
					.getManager(PhotoOrderManager.class);
			orderMgr.saveOrUpdate(order);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new WebException("Failed delete order", ex);
		}
	}

	public PaymentSystem getPaymentSystem(String name) throws ManagerException {
		PaymentSystemManager paymentSystemMgr = (PaymentSystemManager) getContainer()
				.getManager(PaymentSystemManager.class);
		return paymentSystemMgr.getByName(name);
	}

	public PaymentSystem getPaymentSystem(Integer id) throws ManagerException {
		PaymentSystemManager paymentSystemMgr = (PaymentSystemManager) getContainer()
				.getManager(PaymentSystemManager.class);
		return paymentSystemMgr.getById(id);
	}

	public List<PaymentSystem> getPaymentSystems() throws ManagerException {
		PaymentSystemManager paymentSystemMgr = (PaymentSystemManager) getContainer()
				.getManager(PaymentSystemManager.class);
		return paymentSystemMgr.getActiveList();
	}

	public void confirmByClient(PhotoOrder currentOrder) throws Exception {
		currentOrder.setStatus(OrderStatusEnum.CONFIRMED_BY_CLIENT);
		saveOrder(currentOrder);
	}
}
