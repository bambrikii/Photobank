package org.bambrikii.photobank.web.documents;

public class PaymentCertificateDataItem {
	private String filename;
	private String name;
	private String sizeName;
	private Double price;

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

}
