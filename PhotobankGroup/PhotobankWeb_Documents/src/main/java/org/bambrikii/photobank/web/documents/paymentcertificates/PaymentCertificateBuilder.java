package org.bambrikii.photobank.web.documents.paymentcertificates;

import java.io.OutputStream;

import org.bambrikii.photobank.web.documents.DocumentGenerationException;

public interface PaymentCertificateBuilder {
	public void setResourcesPath(String resourcesPath);

	public void setData(PaymentCertificateData data);

	public void build(OutputStream outputStream)
			throws DocumentGenerationException;
}