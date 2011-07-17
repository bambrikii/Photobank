package org.bambrikii.photobank.model;

import org.bambrikii.site.base.payment.model.Product;

public class FileDimension extends Product {

	private Integer maxDim;
	private Integer order;

	public void setMaxDim(Integer maxDim) {
		this.maxDim = maxDim;
	}

	public Integer getMaxDim() {
		return maxDim;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}
}
