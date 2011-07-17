package org.bambrikii.lang.translation.translationmodule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private static final Pattern p = Pattern.compile("\\\\u([0-9A-F]{4})");

	public static String U2U(String s) {
		String res = s;
		Matcher m = p.matcher(res);
		while (m.find()) {
			res = res
					.replaceAll(
							"\\" + m.group(0),
							Character.toString((char) Integer.parseInt(
									m.group(1), 16)));
		}
		return res;
	}
}
