package org.bambrikii.photobank.business.managers.basket.model;

import java.util.HashMap;
import java.util.Map;

import org.bambrikii.site.base.payment.model.Currency;

public class BasketSummary {
	private Map<Currency, Double> prices = new HashMap<Currency, Double>();

	public void setPrices(Map<Currency, Double> prices) {
		this.prices = prices;
	}

	public Map<Currency, Double> getPrices() {
		return prices;
	}
}
