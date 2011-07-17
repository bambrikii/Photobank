package org.bambrikii.site.base.payment.model;

public class PaymentSystem {
	private int id;
	private String name;
	private String checkoutUrl;
	private String defaultMerchantLogin;
	private int order;
	private PaymentSystemStatusEnum status;
	private Currency currency;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCheckoutUrl(String checkoutUrl) {
		this.checkoutUrl = checkoutUrl;
	}

	public String getCheckoutUrl() {
		return checkoutUrl;
	}

	public void setDefaultMerchantLogin(String defaultMerchantLogin) {
		this.defaultMerchantLogin = defaultMerchantLogin;
	}

	public String getDefaultMerchantLogin() {
		return defaultMerchantLogin;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setStatus(PaymentSystemStatusEnum status) {
		this.status = status;
	}

	public PaymentSystemStatusEnum getStatus() {
		return status;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}
}
