package org.bambrikii.photobank.web.payment;

import java.util.List;

import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.payment.beans.BasketBean;
import org.bambrikii.photobank.web.payment.beans.FilePriceBean;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;

public class BasketArchiveAction extends
		SiteBasePagerAction<Pager<Object[]>> {
	private static final long serialVersionUID = -3073767880070300208L;

	private BasketBean basketBean;
	private FilePriceBean filePriceBean;

	private List<Currency> currencies;
	private Currency selectedCurrency;

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	public BasketBean getBasketBean() {
		return basketBean;
	}

	public void setFilePriceBean(FilePriceBean filePriceBean) {
		this.filePriceBean = filePriceBean;
	}

	public FilePriceBean getFilePriceBean() {
		return filePriceBean;
	}

	public void setSelectedCurrency(Currency selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public Currency getSelectedCurrency() {
		return selectedCurrency;
	}

	public String getReadableFileName(String name) {
		return PhotoBean.getReadableFileName(name);
	}

	// Actions
	// Archived orders
	public String execute() throws Exception {
		List<Currency> currs = getFilePriceBean().getAllActiveCurrencies();
		setCurrencies(currs);
		if (getSelectedCurrency() == null) {
			setSelectedCurrency(getCurrencies().get(0));
		} else if (getSelectedCurrency().getCode() == null) {
			setSelectedCurrency(getFilePriceBean().getCurrencyById(
					getSelectedCurrency().getId()));
		}
		setPager(getBasketBean().getBasketPager(getSession(),
				getSelectedCurrency(), getRequestedPage()));
		return SUCCESS;
	}
}
