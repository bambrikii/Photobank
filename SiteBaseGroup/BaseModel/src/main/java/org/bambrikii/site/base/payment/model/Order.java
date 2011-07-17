package org.bambrikii.site.base.payment.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bambrikii.site.base.auth.model.User;

public class Order {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private List<OrderItem> items = new ArrayList<OrderItem>();

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public User getClient() {
		return client;
	}

	private OrderStatusEnum status;
	private User client;

	private Date modificationTime;

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
}
