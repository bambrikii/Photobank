package org.bambrikii.lang.translation.translationmodule;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GoogleTranslator {
	public String translate(String fromLanguage, String phrase,
			String toLanguage) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://translate.google.com/translate_a/t?client=t&text="
						+ phrase
						+ "&hl=en&sl=auto&tl=ru&multires=1&prev=btn&ssel=0&tsel=0&uptl="
						+ toLanguage + "&alttl=en&sc=1");

		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		StringWriter writer = new StringWriter();
		IOUtils.copy(entity.getContent(), writer,//
				"windows-1251"
		// "ISO-8859-1" //
		// "US-ASCII"//
		// "utf-8"
		);
		client.getConnectionManager().shutdown();
		return StringUtils.U2U(writer.toString());
	}

	public void deserialize(String str) {

	}
}
