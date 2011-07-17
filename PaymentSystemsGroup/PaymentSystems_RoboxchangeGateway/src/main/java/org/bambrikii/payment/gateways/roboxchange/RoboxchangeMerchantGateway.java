package org.bambrikii.payment.gateways.roboxchange;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import org.bambrikii.payment.Payment;
import org.bambrikii.payment.merchant.Merchant;
import org.bambrikii.payment.merchant.MerchantGateway;
import org.bambrikii.payment.merchant.MerchantGatewayException;
import org.bambrikii.payment.merchant.MerchantResponse;
import org.bambrikii.payment.merchant.MerchantResponseResult;

public class RoboxchangeMerchantGateway implements MerchantGateway {

	private static final String gatewayUrl = "https://merchant.roboxchange.com/Index.aspx";
	private Merchant _merchant;

	public RoboxchangeMerchantGateway(Merchant merchant) {
		_merchant = merchant;
	}

	private String getCrc(String sCrcBase) throws MerchantGatewayException {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new MerchantGatewayException("Cannot digest!", e);
		}
		CharsetEncoder asciiEncoder = Charset.forName("ASCII").newEncoder();
		CharBuffer cb = CharBuffer.wrap(sCrcBase);
		ByteBuffer enc1;
		try {
			enc1 = asciiEncoder.encode(cb);
		} catch (CharacterCodingException e) {
			throw new MerchantGatewayException("Cannot encode to ByteBuffer!",
					e);
		}
		digest.update(enc1);
		byte[] bSignature = digest.digest();

		StringBuilder sbSignature = new StringBuilder();
		for (byte b : bSignature) {
			sbSignature.append(MessageFormat.format("{0}",
					Integer.toHexString(b)));
		}
		String sCrc = sbSignature.toString();
		return sCrc;
	}

	@Override
	public String getRedirectToPaymentUrl(Payment payment)
			throws MerchantGatewayException {

		String sCrcBase = MessageFormat.format("{0}:{1}:{2}:{3}",
				_merchant.getLogin(), payment.getOutSum(),
				_merchant.getAccount(), _merchant.getPassword());
		String sCrc = getCrc(sCrcBase);

		String url;
		try {
			url = gatewayUrl + "?" + "MrchLogin="
					+ URLEncoder.encode(_merchant.getLogin(), "UTF-8")
					+ "&OutSum="
					+ URLEncoder.encode(payment.getOutSum(), "UTF-8")
					+ "&InvId="
					+ URLEncoder.encode(_merchant.getAccount(), "UTF-8")
					+ "&Desc="
					+ URLEncoder.encode(payment.getDescription(), "UTF-8")
					+ "&SignatureValue=" + sCrc;
		} catch (UnsupportedEncodingException e) {
			throw new MerchantGatewayException("Cannot urlencode!", e);
		}
		return url;
	}

	@Override
	public MerchantResponseResult checkResult(MerchantResponse response)
			throws MerchantGatewayException {

		String sCrcBase = MessageFormat.format("{0}:{1}:{2}",
				response.getOutSum(), _merchant.getAccount(),
				_merchant.getPassword());

		String sMyCrc = getCrc(sCrcBase);

		if (sMyCrc.equalsIgnoreCase(response.getSignatureValue())) {
			// return MessageFormat.format("OK{0}", _merchant.getAccount());
			return MerchantResponseResult.OK;
		} else {
			// return "bad sign";
			return MerchantResponseResult.BadSign;
		}

	}
}
