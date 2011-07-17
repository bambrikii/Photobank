package org.bambrikii.web.site.services.payment.model;

import java.util.ArrayList;
import java.util.List;

import org.bambrikii.site.base.payment.model.OrderItem;

public class SiteOrderItem extends OrderItem {
	private List<SiteOrderItemProperty> properties = new ArrayList<SiteOrderItemProperty>();

	public void setProperties(List<SiteOrderItemProperty> properties) {
		this.properties = properties;
	}

	public List<SiteOrderItemProperty> getProperties() {
		return properties;
	}
}
