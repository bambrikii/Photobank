package org.bambrikii.payment.gateways.roboxchange;

public class RobocashPaymentInfo {
	private String merchantLogin;
	private String outSum;
	private String invId;
	private String invDesc;
	private String signatureValue;
	private String incCurrLabel;
	private String culture;
	private String encoding;

	private String email;

	private String serviceUrl;

	public void setMerchantLogin(String merchantLogin) {
		this.merchantLogin = merchantLogin;
	}

	public String getMerchantLogin() {
		return merchantLogin;
	}

	public void setOutSum(String outSum) {
		this.outSum = outSum;
	}

	public String getOutSum() {
		return outSum;
	}

	public void setInvId(String invId) {
		this.invId = invId;
	}

	public String getInvId() {
		return invId;
	}

	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}

	public String getInvDesc() {
		return invDesc;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	public String getSignatureValue() {
		return signatureValue;
	}

	public void setIncCurrLabel(String incCurrLabel) {
		this.incCurrLabel = incCurrLabel;
	}

	public String getIncCurrLabel() {
		return incCurrLabel;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getCulture() {
		return culture;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}
}
