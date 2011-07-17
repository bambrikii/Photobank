package org.bambrikii.site.base.payment.model;

import java.util.List;

public class Product {
	private Integer id;
	private String name;
	private boolean active;
	private List<Price> prices;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<Price> getPrices() {
		return prices;
	}
}
