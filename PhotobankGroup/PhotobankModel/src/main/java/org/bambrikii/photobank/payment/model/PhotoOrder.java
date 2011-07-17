package org.bambrikii.photobank.payment.model;

import org.bambrikii.site.base.payment.model.Order;

public class PhotoOrder extends Order {
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
