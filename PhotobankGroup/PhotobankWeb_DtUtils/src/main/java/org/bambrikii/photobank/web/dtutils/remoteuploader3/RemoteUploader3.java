package org.bambrikii.photobank.web.dtutils.remoteuploader3;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.CustomUploadException;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.threads.Uploader3Impl;

public class RemoteUploader3 {
	public static void main(String[] args) throws InterruptedException,
			CustomUploadException {
		String url = args[0];
		String webSourceDir = args[1];
		String orderSourceDir = args[2];
		Uploader3Impl uploader = new Uploader3Impl(url, webSourceDir,
				orderSourceDir);
		String failedFileName = null;

		if (args.length > 3) {
			failedFileName = args[3];
		}
		if (failedFileName == null || "".equals(failedFileName)) {
			uploader.upload();
		} else {
			uploader.upload(failedFileName);
		}
	}
}
