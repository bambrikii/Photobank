package org.bambrikii.photobank.web.dtutils.remoteuploader3.threads;

import java.io.File;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.UploadThreadBase;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadEventArgs;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadCompleteListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadOrderThread extends UploadThreadBase {
	private final Logger logger = LoggerFactory
			.getLogger(UploadOrderThread.class);

	@Override
	public void uploadDirectory(final File file) {
		logger.info("Scanning directory {}.", file.getAbsoluteFile());
		UploadOrderThread t2 = new UploadOrderThread();
		t2.setUrl(getUrl());
		t2.setSourceDir(file);
		for (ItemUploadCompleteListener handler : getItemUploadCompleteListeners()) {
			t2.addItemUploadCompleteHandler(handler);
		}
		t2.addFullUploadCompleteHandler(new FullUploadCompleteListener() {
			public void complete(FullUploadEventArgs e) {
				logger.info("Directory {} scanning complete.",
						file.getAbsoluteFile());
			}
		});
		t2.uploadAll();
	}
}
