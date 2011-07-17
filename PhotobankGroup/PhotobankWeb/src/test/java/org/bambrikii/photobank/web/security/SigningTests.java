package org.bambrikii.photobank.web.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import junit.framework.Assert;

import org.bambrikii.payment.gateways.roboxchange.RobocashPaymentInfo;
import org.junit.Test;

public class SigningTests {
	@Test
	public void signateureTest1() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		RobocashPaymentInfo paymentInfo = new RobocashPaymentInfo();
		paymentInfo.setMerchantLogin("demo");
		paymentInfo.setOutSum("8.96");
		paymentInfo.setInvId("0");
		paymentInfo.setInvDesc("Техническая документация по ROBOKASSA");
		paymentInfo.setCulture("ru");
		paymentInfo.setEncoding("utf-8");
		paymentInfo.setIncCurrLabel("PCR");
		// paymentInfo.setShp_code("Net");
		// paymentInfo.setShp_item("2");
		// paymentInfo.setShp_demo("2");
		paymentInfo.setEmail("");

		String sCrcBase = MessageFormat
				.format("{0}:{1}:{2}:{3}:Shp_item={4}",
						paymentInfo.getMerchantLogin(),
						paymentInfo.getOutSum(), paymentInfo.getInvId(),
						"Morbid11", "1");

		System.out.printf("%s\n\n", sCrcBase);

		MessageDigest mdEnc = MessageDigest.getInstance("MD5");
		mdEnc.reset();
		mdEnc.update(sCrcBase.getBytes("utf-8"));
		byte[] digest = mdEnc.digest();
		String md5 = new BigInteger(1, digest).toString(16);

		paymentInfo.setSignatureValue(md5);

		System.out.printf("Calculated signature: %s\n",
				paymentInfo.getSignatureValue());

		String html = MessageFormat
				.format("<form id=\"aspnetForm\" action=\"https://merchant.roboxchange.com/Index.aspx\" method=\"post\" name=\"aspnetForm\">\n"
						+ "<input type=\"hidden\" value=\"{0}\" name=\"MrchLogin\">\n"
						+ "<input type=\"hidden\" value=\"{1}\" name=\"OutSum\">\n"
						+ "<input type=\"hidden\" value=\"{2}\" name=\"InvId\">\n"
						+ "<input type=\"hidden\" value=\"{3}\" name=\"Desc\">\n"
						+ "<input type=\"hidden\" value=\"0085a0d98cd142f55e9cd63c7b159924\" name=\"SignatureValue\">\n"
						+ "<input type=\"hidden\" value=\"{5}\" name=\"Shp_item\">\n"
						+ "<input type=\"hidden\" value=\"{6}\" name=\"Shp_demo\">\n"
						+ "<input type=\"hidden\" value=\"Net\" name=\"Shp_code\">\n"
						+ "<input type=\"hidden\" value=\"{7}\" name=\"IncCurrLabel\">\n"
						+ "<input type=\"hidden\" value=\"{8}\" name=\"Culture\">\n"
						+ "<input type=\"submit\" style=\"width: 80px;\" id=\"ctl00_ctl00_CPHMainContent_CPHMainContent_btnPay\" value=\"��������\" name=\"ctl00$ctl00$CPHMainContent$CPHMainContent$btnPay\">\n"
						+ "</form>\n", paymentInfo.getMerchantLogin(),
						paymentInfo.getOutSum(), paymentInfo.getInvId(),
						paymentInfo.getInvDesc(),
						paymentInfo.getSignatureValue(),
						"paymentInfo.getShp_item()",
						"paymentInfo.getShp_demo()",
						paymentInfo.getIncCurrLabel(), paymentInfo.getCulture());

		System.out.printf("Html: %s\n\n", html);

		Assert.assertEquals("Signatures are not equal!",
				"0085a0d98cd142f55e9cd63c7b159924",
				paymentInfo.getSignatureValue());
	}
}
