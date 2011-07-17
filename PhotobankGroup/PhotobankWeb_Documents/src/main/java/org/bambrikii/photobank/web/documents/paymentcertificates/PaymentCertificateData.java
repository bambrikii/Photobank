package org.bambrikii.photobank.web.documents.paymentcertificates;

import java.util.Date;
import java.util.List;

import org.bambrikii.photobank.web.documents.PaymentCertificateDataItem;

public class PaymentCertificateData {
	private Integer number;
	private Date date;
	private String licensee;
	private List<PaymentCertificateDataItem> items;
	private String currency;
	private Double total;

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setLicensee(String licensee) {
		this.licensee = licensee;
	}

	public String getLicensee() {
		return licensee;
	}

	public void setItems(List<PaymentCertificateDataItem> items) {
		this.items = items;
	}

	public List<PaymentCertificateDataItem> getItems() {
		return items;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotal() {
		return total;
	}
}
