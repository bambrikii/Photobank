package org.bambrikii.photobank.web.payment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.web.payment.beans.FilePriceBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.Price;
import org.bambrikii.site.base.struts2.core.SiteBaseDictionaryAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class FilePriceAction extends
		SiteBaseDictionaryAction<FileDimension> {
	private static final long serialVersionUID = -4045336159714973207L;

	private FileDimension model;
	private List<Currency> allCurrencies;
	private Map<Integer, Double> prices;

	private FilePriceBean filePriceBean;

	public void setModel(FileDimension model) {
		this.model = model;
	}

	public FileDimension getModel() {
		return model;
	}

	public void setAllCurrencies(List<Currency> allCurrencies) {
		this.allCurrencies = allCurrencies;
	}

	public List<Currency> getAllCurrencies() {
		return allCurrencies;
	}

	public void setPrices(Map<Integer, Double> prices) {
		this.prices = prices;
	}

	public Map<Integer, Double> getPrices() {
		return prices;
	}

	public void setFilePriceBean(FilePriceBean filePriceBean) {
		this.filePriceBean = filePriceBean;
	}

	public FilePriceBean getFilePriceBean() {
		return filePriceBean;
	}

	public void validate() {
		try {
			setAllCurrencies(getFilePriceBean().getAllActiveCurrencies());
		} catch (ManagerException e) {
			e.printStackTrace();
		}
	}

	public enum PriceFoundStatusEnum {
		PRESENT, VALUE_DIFFER, ABSEND
	}

	@Override
	public String save() throws Exception {
		FileDimension dim = getModel() != null && getModel().getId() != null ? getFilePriceBean()
				.getById(getModel().getId()) : new FileDimension();
		dim.setName(getModel().getName());
		dim.setOrder(getModel().getOrder());
		dim.setActive(getModel().getActive());
		if (dim.getPrices() == null) {
			dim.setPrices(new ArrayList<Price>());
		}
		for (Integer currencyId : getPrices().keySet()) {
			Currency currency = getFilePriceBean().getCurrencyById(currencyId);
			Double value = getPrices().get(currencyId);
			PriceFoundStatusEnum status = PriceFoundStatusEnum.ABSEND;
			for (Price price : dim.getPrices()) {
				if (price.getCurrency().equals(currency)) {
					if (price.getValue().equals(value)) {
						status = PriceFoundStatusEnum.PRESENT;
						break;
					} else {
						status = PriceFoundStatusEnum.VALUE_DIFFER;
						price.setValue(getPrices().get(currencyId));
						break;
					}
				}
			}
			switch (status) {
			case VALUE_DIFFER:
			case PRESENT:
				break;
			case ABSEND:
				Price price = new Price();
				price.setCurrency(currency);
				price.setValue(value);
				dim.getPrices().add(price);
				break;
			}
			// TODO:
			// dim.getPrices().put(currency, getPrices().get(currencyId));
		}
		dim.setMaxDim(getModel().getMaxDim());
		getFilePriceBean().saveOrUpdate(dim);
		setModel(dim);
		setAllCurrencies(getFilePriceBean().getAllActiveCurrencies());
		return list();
	}

	@Override
	public String delete() throws Exception {
		FileDimension dim = getFilePriceBean().getById(getModel().getId());
		getFilePriceBean().delete(dim);
		return list();
	}

	@Override
	public String edit() throws Exception {
		if (getModel() != null) {
			FileDimension dim = getFilePriceBean().getById(getModel().getId());
			setModel(dim);
			Map<Integer, Double> prices1 = new LinkedHashMap<Integer, Double>();
			for (Price price1 : dim.getPrices()) {
				prices1.put(price1.getCurrency().getId(), price1.getValue());
			}
			setPrices(prices1);
		}
		setAllCurrencies(getFilePriceBean().getAllActiveCurrencies());
		return EDIT_RESULT;
	}

	public String execute() throws Exception {
		return list();
	}

	@Override
	public String list() throws Exception {
		setPager(getFilePriceBean().getDimensions("active DESC, name",
				getRequestedPage()));
		return LIST_RESULT;
	}
}
