package org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadEventArgs;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.UploadItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemUploadCompleteListenerPreviewImpl extends
		ItemUploadCompleteListenerBase {
	private final Logger logger = LoggerFactory
			.getLogger(ItemUploadCompleteListenerPreviewImpl.class);

	public final static String PREVIEW_VALIDATION_PATTERN = "^id:(\\d+)$";
	private final Pattern filewebpattern = Pattern
			.compile(PREVIEW_VALIDATION_PATTERN);

	public void complete(final ItemUploadEventArgs e) {
		incFilesTotal();
		if (e.getResponse() != null) {
			Matcher m = filewebpattern.matcher(e.getResponse());
			if (m.matches()) {
				logger.info("{} OK.", e.getFilename());
				incFilesSuccess();
			} else {
				getFilesFailed().add(new UploadItem() {
					{
						setAbsolutePath(e.getAbsolutePath());
					}
				});
				logger.error("{} FAIL! SERVER SIDE. {}", e.getFilename(),
						e.getResponse());
			}
		} else {
			getFilesFailed().add(new UploadItem() {
				{
					setAbsolutePath(e.getAbsolutePath());
				}
			});
			logger.error("{} FAIL. No response!", e.getFilename());
		}
	}

	public void failed(final ItemUploadEventArgs e, Throwable throwable) {
		incFilesTotal();
		getFilesFailed().add(new UploadItem() {
			{
				setAbsolutePath(e.getAbsolutePath());
			}
		});
		logger.error(MessageFormat.format("{0} FAIL!", e.getFilename()),
				throwable);
	}
}
