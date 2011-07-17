package org.bambrikii.photobank.mailing;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static String DEFAULT_TEMPLATE_KEY = "template1";
	public static String DEFAULT_TEMPLATE_SUBJECT = "Subject form for $companyName";
	public static String DEFAULT_TEMPLATE_BODY = "Hi $firstname $surname!\n"
			+ "Now you can login to http://www.personastars.com:8080/photobank";
	public static String DEFAULT_MAIL_FROM = "bambrikii@personastars.com";
	public static String DEFAULT_MAIL_TO = "shurik-a3-2@yandex.ru";
	public static String DEFAULT_MAIL_HOST = "personastars.com";
	public static String DEFAULT_CONTENT_TYPE = "text/plain";
	public static Map<String, Object> DEFAULT_TEMPLATE_PARAMETERS = new HashMap<String, Object>() {
		private static final long serialVersionUID = 6345100304574978207L;
		{
			put("companyName", "Oracle");
			put("firstname", "Alexander");
			put("surname", "Arakelyan");
			put("technology", "Java");
			put("currentTime", new Date());
		};
	};
}
