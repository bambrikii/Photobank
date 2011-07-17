package org.bambrikii.photobank.web.dtutils;

import java.io.IOException;

import org.junit.Test;

public class RemoteUploaderTests {
	private String url = "http://localhost:8080/photobank";
	private String sourceDirWm = "D:\\Temporary Files\\personastars.com";

	@Test
	public void uploadWmTest() throws IOException {
		RemoteUploader uploader = new RemoteUploader();
		uploader.uploadWeb(url, sourceDirWm);
	}

	@Test
	public void uploadOrderTest() throws IOException {
		RemoteUploader uploader = new RemoteUploader();
		uploader.uploadOrder(url, sourceDirWm);
	}
}
