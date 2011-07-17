package org.bambrikii.web.site.services.payment.model;

public class SiteOrderItemProperty {
	private Integer id;
	private SiteOrderItem item;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setItem(SiteOrderItem item) {
		this.item = item;
	}

	public SiteOrderItem getItem() {
		return item;
	}
}
