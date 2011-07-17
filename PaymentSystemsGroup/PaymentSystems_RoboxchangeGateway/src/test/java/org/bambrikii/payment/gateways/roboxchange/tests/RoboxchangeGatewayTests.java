package org.bambrikii.payment.gateways.roboxchange.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import junit.framework.Assert;

import org.bambrikii.payment.Payment;
import org.bambrikii.payment.gateways.roboxchange.RoboxchangeMerchantGateway;
import org.bambrikii.payment.merchant.Merchant;
import org.bambrikii.payment.merchant.MerchantGatewayException;
import org.bambrikii.payment.merchant.MerchantResponse;
import org.bambrikii.payment.merchant.MerchantResponseResult;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RoboxchangeGatewayTests {

	private String gatewayUrl = "https://merchant.roboxchange.com/Index.aspx";

	RoboxchangeMerchantGateway _gateway;
	Merchant _merchant;

	@Before
	public void before() {
		_merchant = new Merchant();
		_merchant.setAccount("account1");
		_merchant.setLogin("prphotos.ru");
		_merchant.setPassword("secret");
		_gateway = new RoboxchangeMerchantGateway(_merchant);
	}

	@Test
	@Ignore
	public void checkoutTest2() throws IOException {
		URL url = new URL(gatewayUrl);
		URLConnection conn = url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		String data;
		data = URLEncoder.encode("key1", "UTF-8") + "="
				+ URLEncoder.encode("value1", "UTF-8");
		data += "&" + URLEncoder.encode("key2", "UTF-8") + "="
				+ URLEncoder.encode("value2", "UTF-8");

		wr.write(data);

		wr.flush();
		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			// Process line...
			sb.append(line);
		}
		wr.close();
		rd.close();
		System.out.println(sb.toString());
	}

	@Test
	@Ignore
	public void asciiEncodingTest() throws CharacterCodingException,
			NoSuchAlgorithmException {
		String sCrcBase = "some string 1";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		CharsetEncoder asciiEncoder = Charset.forName("ASCII").newEncoder();
		CharBuffer cb = CharBuffer.wrap(sCrcBase);
		ByteBuffer enc1 = asciiEncoder.encode(cb);
		digest.update(enc1);
		byte[] bSignature = digest.digest();
		StringBuilder sbSignature = new StringBuilder();
		for (byte b : bSignature) {
			sbSignature.append(MessageFormat.format("{0}",
					Integer.toHexString(b)));
		}

		System.out.print(sbSignature);

	}

	@Test
	public void getRedirectToPaymentUrlTest() throws MerchantGatewayException {
		Payment payment = new Payment();
		payment.setOutSum("100.1RUR");
		payment.setDescription("Test payment 1.");
		String url = _gateway.getRedirectToPaymentUrl(payment);
		System.out.println(url);
	}

	@Test
	public void checkResultTest() throws MerchantGatewayException {
		MerchantResponse response = new MerchantResponse();
		String signatureValue = // "6679fffffff1ffffffa45474ffffffb3ffffff9e6bffffff832128ffffff9e0ffffffb1ffffffc4"
		"ffffffa5ffffffb64d6a77ffffff8cffffffc17dffffffe436ffffff954d4f4bffffffc4ffffffaf";
		response.setSignatureValue(signatureValue);
		response.setOutSum("100.1RUR");
		response.setDescription("Test payment 1.");
		MerchantResponseResult result = _gateway.checkResult(response);
		Assert.assertTrue("Signature values should be equal!",
				result == MerchantResponseResult.OK);
	}
}
