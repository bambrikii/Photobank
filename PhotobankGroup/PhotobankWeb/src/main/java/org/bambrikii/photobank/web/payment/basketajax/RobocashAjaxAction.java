package org.bambrikii.photobank.web.payment.basketajax;

import org.apache.struts2.json.annotations.JSON;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.web.payment.beans.BasketBean;
import org.bambrikii.photobank.web.payment.beans.OrderManagementBean;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware
public class RobocashAjaxAction extends SiteBaseAction {
	private static final long serialVersionUID = -4569863262740741450L;
	private BasketBean basketBean;
	private OrderManagementBean orderManagementBean;

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	@JSON(deserialize = false, serialize = false)
	public BasketBean getBasketBean() {
		return basketBean;
	}

	public void setOrderManagementBean(OrderManagementBean orderManagementBean) {
		this.orderManagementBean = orderManagementBean;
	}

	@JSON(deserialize = false, serialize = false)
	public OrderManagementBean getOrderManagementBean() {
		return orderManagementBean;
	}

	private PhotoOrder getCurrentOrder() throws WebException {
		return getBasketBean().getOrder(getSession());
	}

	// Actions
	public String confirmCurrentOrder() throws Exception {
		getOrderManagementBean().confirmByClient(getCurrentOrder());
		return SUCCESS;
	}
}
