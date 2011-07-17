package org.bambrikii.photobank.web.dtutils.remoteuploader3.core;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadEventArgs;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadEventArgs;

public abstract class UploadThreadBase implements Runnable {

	private List<ItemUploadCompleteListener> itemUploadCompleteListener = new ArrayList<ItemUploadCompleteListener>();
	private List<FullUploadCompleteListener> fullUploadCompleteListener = new ArrayList<FullUploadCompleteListener>();
	private String url;
	private File sourceDir;
	private Status status = Status.NOOP;

	protected List<ItemUploadCompleteListener> getItemUploadCompleteListeners() {
		return itemUploadCompleteListener;
	}

	protected List<FullUploadCompleteListener> getFullUploadCompleteListeners() {
		return fullUploadCompleteListener;
	}

	public void addFullUploadCompleteHandler(FullUploadCompleteListener listener) {
		fullUploadCompleteListener.add(listener);
	}

	public void removeFullUploadCompleteHandler(
			FullUploadCompleteListener listener) {
		fullUploadCompleteListener.remove(listener);
	}

	public void addItemUploadCompleteHandler(ItemUploadCompleteListener listener) {
		itemUploadCompleteListener.add(listener);
	}

	public void removeItemUploadCompleteHandler(
			ItemUploadCompleteListener listener) {
		itemUploadCompleteListener.remove(listener);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setSourceDir(File sourceDir) {
		this.sourceDir = sourceDir;
	}

	public File getSourceDir() {
		return sourceDir;
	}

	public void uploadFile(File file) {
		HttpClient httpclient = new DefaultHttpClient();

		httpclient.getParams().setParameter(
				CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				new Integer(10000));
		httpclient.getParams().setParameter(
				CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");

		HttpPost request = new HttpPost(url);

		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.STRICT);
		String response = null;
		try {
			entity.addPart("Filename", new StringBody(file.getName(),
					"text/plain", Charset.forName("UTF-8")));
			entity.addPart("Filedata", new FileBody((file),
					"application/octet-stream"));
			entity.addPart("Upload", new StringBody("Submit Query",
					"text/plain", Charset.forName("UTF-8")));
			request.setEntity(entity);

			response = EntityUtils.toString(httpclient.execute(request)
					.getEntity(), "UTF-8");
			if (response == null) {
				throw new CustomUploadException("Response empty!");
			}
			for (ItemUploadCompleteListener handler : itemUploadCompleteListener) {
				handler.complete(new ItemUploadEventArgs(file.getName(), file
						.getAbsolutePath(), response));
			}
		} catch (UnsupportedEncodingException ex1) {
			logFail(file, response, ex1);
		} catch (ParseException ex2) {
			logFail(file, response, ex2);
		} catch (ClientProtocolException ex3) {
			logFail(file, response, ex3);
		} catch (IOException ex4) {
			logFail(file, response, ex4);
		} catch (CustomUploadException ex5) {
			logFail(file, response, ex5);
		}

		httpclient.getConnectionManager().shutdown();
	}

	private void logFail(File file, String response, Throwable throwable) {
		for (ItemUploadCompleteListener handler : itemUploadCompleteListener) {
			handler.failed(
					new ItemUploadEventArgs(file.getName(), file
							.getAbsolutePath(), response), throwable);
		}
	}

	public abstract void uploadDirectory(File file);

	public void uploadAll() {
		setStatus(Status.RUNNING);
		File sourceDir = getSourceDir();
		File[] files = sourceDir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				uploadDirectory(file);
			} else {
				uploadFile(file);
			}
		}

		for (FullUploadCompleteListener handler : fullUploadCompleteListener) {
			setStatus(Status.COMPLETE);
			handler.complete(new FullUploadEventArgs(sourceDir
					.getAbsolutePath()));
		}
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void run() {
		uploadAll();
	}
}
