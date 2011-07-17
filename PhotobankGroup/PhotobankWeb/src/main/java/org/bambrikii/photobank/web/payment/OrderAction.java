package org.bambrikii.photobank.web.payment;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.payment.beans.BasketBean;
import org.bambrikii.photobank.web.payment.beans.OrderManagementBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.struts2.core.SiteBaseDictionaryAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class OrderAction extends SiteBaseDictionaryAction<PhotoOrder> implements
		ServletContextAware {
	private static final long serialVersionUID = 5707169192297188611L;

	private PhotoOrder model;
	private BasketBean basketBean;
	private OrderManagementBean orderManagementBean;
	private Integer paymentSystemId;
	private List<PaymentSystem> paymentSystems;
	private ServletContext servletContext;

	public void setModel(PhotoOrder model) {
		this.model = model;
	}

	public PhotoOrder getModel() {
		return model;
	}

	public void setOrderManagementBean(OrderManagementBean orderManagementBean) {
		this.orderManagementBean = orderManagementBean;
	}

	public OrderManagementBean getOrderManagementBean() {
		return orderManagementBean;
	}

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	public BasketBean getBasketBean() {
		return basketBean;
	}

	public void setPaymentSystemId(Integer paymentSystemId) {
		this.paymentSystemId = paymentSystemId;
	}

	public Integer getPaymentSystemId() {
		return paymentSystemId;
	}

	public void setPaymentSystems(List<PaymentSystem> paymentSystems) {
		this.paymentSystems = paymentSystems;
	}

	public List<PaymentSystem> getPaymentSystems() {
		return paymentSystems;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public String execute() throws Exception {
		return list();
	}

	public String getReadableFileName(String name) {
		return PhotoBean.getReadableFileName(name);
	}

	public BasketSummary getBasketSummary(PhotoOrder order)
			throws ManagerException {
		return getBasketBean().getBasketSummary(order);
	}

	@Override
	public String save() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			PhotoOrder order = getOrderManagementBean().getOrder(
					getModel().getId());
			order.setStatus(getModel().getStatus());
			getOrderManagementBean().saveOrder(order);
		}
		return EDIT_RESULT;
	}

	public String approve() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			getOrderManagementBean().approveOrder(
					getModel().getId(),
					getOrderManagementBean().getPaymentSystem(
							getPaymentSystemId()),
					getServletContext().getRealPath(""));
		}
		return list();
	}

	public String reject() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			getOrderManagementBean().rejectOrder(getModel().getId());
		}
		return list();
	}

	@Override
	public String delete() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			getOrderManagementBean().deleteOrder(getModel().getId());
		}
		return list();
	}

	@Override
	public String edit() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			setModel(getOrderManagementBean().getOrder(getModel().getId()));
		}
		return EDIT_RESULT;
	}

	@Override
	public String list() throws Exception {
		setPager(getOrderManagementBean().getOrderPager(null,
				getRequestedPage()));
		setPaymentSystems(getOrderManagementBean().getPaymentSystems());
		return LIST_RESULT;
	}
}
