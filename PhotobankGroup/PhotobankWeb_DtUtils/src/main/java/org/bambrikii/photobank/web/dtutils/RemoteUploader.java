package org.bambrikii.photobank.web.dtutils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.bambrikii.photobank.web.dtutils.remoteuploader.OrderUploaderResponseHandler;
import org.bambrikii.photobank.web.dtutils.remoteuploader.RemoteUploaderResponseListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader.WmUploaderResponseHandler;

public class RemoteUploader {
	public void uploadWeb(String url, String sourceDir) throws IOException {
		upload(url + "/photoUpload!massUpload.action", sourceDir,
				new WmUploaderResponseHandler());
	}

	public void uploadOrder(String url, String sourceDir)
			throws ParseException, ClientProtocolException, IOException {
		upload(url + "/photoUpload!massUpload10x15.action", sourceDir,
				new OrderUploaderResponseHandler());
	}

	protected void upload(String url, String sourceDir,
			RemoteUploaderResponseListener handler) throws ParseException,
			ClientProtocolException, IOException {
		File dir = new File(sourceDir);
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.matches(".*((\\d+)|(PS)|(PP)|(PRP))\\.jp*g$");
			}
		};
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			uploadFile(url, file, handler);
		}
	}

	public void uploadFile(String url, File file,
			RemoteUploaderResponseListener handler) throws ParseException,
			ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();

		httpclient.getParams().setParameter(
				CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				new Integer(10000));
		httpclient.getParams().setParameter(
				CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");

		HttpPost request = new HttpPost(url);

		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.STRICT);

		entity.addPart("Filename", new StringBody(file.getName(), "text/plain",
				Charset.forName("UTF-8")));
		entity.addPart("Filedata", new FileBody((file),
				"application/octet-stream"));
		entity.addPart("Upload", new StringBody("Submit Query", "text/plain",
				Charset.forName("UTF-8")));
		request.setEntity(entity);

		String response = EntityUtils.toString(httpclient.execute(request)
				.getEntity(), "UTF-8");

		handler.uploaded(file.getName(), file.length(), response);

		httpclient.getConnectionManager().shutdown();
	}
}
