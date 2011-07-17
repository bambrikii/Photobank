package org.bambrikii.photobank.web.payment;

import org.bambrikii.payment.gateways.roboxchange.RobocashPaymentInfo;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.payment.beans.BasketBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware
public class BasketAction extends SiteBasePagerAction<Pager<PhotoOrderItem>> {
	private static final long serialVersionUID = 5791561372315170662L;
	private BasketBean basketBean;

	private RobocashPaymentInfo robocashPaymentInfo;

	private BasketSummary basketSummary;

	public BasketBean getBasketBean() throws WebException {
		return basketBean;
	}

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	public PhotoOrder getCurrentOrder() throws WebException {
		return getBasketBean().getOrder(getSession());
	}

	public BasketSummary getBasketSummary() {
		return basketSummary;
	}

	public void setBasketSummary(BasketSummary basketSummary) {
		this.basketSummary = basketSummary;
	}

	public void setRobocashPaymentInfo(
			org.bambrikii.payment.gateways.roboxchange.RobocashPaymentInfo robocashPaymentInfo) {
		this.robocashPaymentInfo = robocashPaymentInfo;
	}

	public RobocashPaymentInfo getRobocashPaymentInfo() {
		return robocashPaymentInfo;
	}

	protected void preparePager() throws Exception {
		setPager(getBasketBean().getItemsPager(getCurrentOrder(),
				getRequestedPage()));
	}

	public String getReadableFileName(String name) {
		return PhotoBean.getReadableFileName(name);
	}

	protected void prepareBasketInfo() throws Exception {
		PhotoOrder order = getCurrentOrder();
		BasketSummary summary = getBasketBean().getBasketSummary(order);
		setBasketSummary(summary);
	}

	public String getDimensionPricesSummary(Integer dimensionId)
			throws WebException, ManagerException {
		try {
			return getBasketBean().getDimensionPricesSummary(dimensionId);
		} catch (Exception ex) {
			throw new WebException("Failed to get dimensions", ex);
		}
	}

	// Actions

	// basket views
	// 1. default basket view with the list of files and total price
	// 2. checkout view: personal info
	// 3. checkout complete info: checkout complete
	//
	// 4. payment success
	// 5. payment error
	//

	public String execute() throws Exception {
		preparePager();
		prepareBasketInfo();
		return SUCCESS;
	}

	public String checkout() throws Exception {
		prepareBasketInfo();

		setRobocashPaymentInfo(getBasketBean().getRobocashBean().checkout(
				getCurrentOrder(), getBasketSummary()));

		return "checkout";
	}
}
