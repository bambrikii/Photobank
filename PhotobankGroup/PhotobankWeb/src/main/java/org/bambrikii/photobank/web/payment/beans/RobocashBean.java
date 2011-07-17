package org.bambrikii.photobank.web.payment.beans;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.bambrikii.payment.gateways.roboxchange.RobocashPaymentInfo;
import org.bambrikii.photobank.business.managers.PaymentSystemManager;
import org.bambrikii.photobank.business.managers.basket.model.BasketSummary;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.payment.model.Currency;
import org.bambrikii.site.base.payment.model.OrderItem;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.springframework.util.StringUtils;

public class RobocashBean extends SiteBaseBean {
	public static String CONFIG_PARAM__MERCHANT_LOGIN = ".ru.psfotos.robocash.merchantLogin";
	public static String CONFIG_PARAM__MERCHANT_PASSWORD = ".ru.psfotos.robocash.merchantPassword";
	public static String CONFIG_PARAM__MERCHANT_RESULT_CHECK_PASSWORD = ".ru.psfotos.robocash.merchantResultCheckPassword";
	public static String CONFIG_PARAM__PAYMENT_ENCODING = ".ru.psfotos.robocash.paymentEncoding";
	public static String CONFIG_PARAM__SERVICE_URL = ".ru.psfotos.robocash.serviceUrl";
	public static final String PAYMENT_SYSTEM_NAME = "Roboxchange";

	// Payment actions
	public RobocashPaymentInfo checkout(PhotoOrder order,
			BasketSummary basketSummary) throws ManagerException,
			NoSuchAlgorithmException, UnsupportedEncodingException {

		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);

		PaymentSystemManager paymentSystemMgr = (PaymentSystemManager) getContainer()
				.getManager(PaymentSystemManager.class);
		Currency merchantCurr = paymentSystemMgr.getByName(PAYMENT_SYSTEM_NAME)
				.getCurrency();

		RobocashPaymentInfo paymentInfo = new RobocashPaymentInfo();

		paymentInfo.setMerchantLogin(configMgr
				.getCacheConfigValue(CONFIG_PARAM__MERCHANT_LOGIN));
		paymentInfo.setEncoding(configMgr
				.getCacheConfigValue(CONFIG_PARAM__PAYMENT_ENCODING));
		paymentInfo.setServiceUrl(configMgr
				.getCacheConfigValue(CONFIG_PARAM__SERVICE_URL));

		paymentInfo.setOutSum(basketSummary.getPrices().get(merchantCurr)
				.toString());
		paymentInfo.setIncCurrLabel(merchantCurr.getCode());
		paymentInfo.setInvId(order.getId().toString());
		paymentInfo.setInvDesc(getOrderDescription(order));

		paymentInfo.setEmail(order.getClient().getEmail());

		paymentInfo.setCulture(order.getClient().getLanguage() != null ? order
				.getClient().getLanguage().getLocale() : "en");

		paymentInfo
				.setSignatureValue(encodeToMD5(MessageFormat.format(
						"{0}:{1}:{2}:{3}",
						paymentInfo.getMerchantLogin(),
						paymentInfo.getOutSum(),
						paymentInfo.getInvId(),
						configMgr
								.getCacheConfigValue(CONFIG_PARAM__MERCHANT_PASSWORD))));

		return paymentInfo;
	}

	private String getOrderDescription(PhotoOrder order) {
		List<OrderItem> items = order.getItems();
		List<String> fileNames = new ArrayList<String>();
		for (OrderItem item : items) {
			/*
			 * String name = ((PhotoOrderItem) item).getFile().getFileName();
			 * fileNames.add(name.substring(name.lastIndexOf("/") + 1,
			 * name.indexOf(".")));
			 */
			Integer id = ((PhotoOrderItem) item).getFile().getId();
			fileNames.add(id.toString());
		}
		return "#" + order.getId().toString() + ","
				+ StringUtils.arrayToDelimitedString(fileNames.toArray(), " ");
	}

	private String encodeToMD5(String str) throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		MessageDigest mdEnc = MessageDigest.getInstance("MD5");
		mdEnc.update(str.getBytes("UTF-8"));
		return new BigInteger(1, mdEnc.digest()).toString(16);
	}

	public Boolean checkResult(String outSum, String invId,
			String signatureValue) throws UnsupportedEncodingException,
			NoSuchAlgorithmException, ManagerException {
		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);
		return checkResultPrivate(
				outSum,
				invId,
				signatureValue,
				configMgr
						.getCacheConfigValue(CONFIG_PARAM__MERCHANT_RESULT_CHECK_PASSWORD));
	}

	public Boolean checkSuccessOrFail(String outSum, String invId,
			String signatureValue) throws UnsupportedEncodingException,
			NoSuchAlgorithmException, ManagerException {
		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);
		return checkResultPrivate(outSum, invId, signatureValue,
				configMgr.getCacheConfigValue(CONFIG_PARAM__MERCHANT_PASSWORD));
	}

	private Boolean checkResultPrivate(String outSum, String invId,
			String signatureValue, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String str = MessageFormat.format("{0}:{1}:{2}", outSum, invId,
				password);
		String str2 = encodeToMD5(str);
		return str2.equalsIgnoreCase(signatureValue);
	}
}
