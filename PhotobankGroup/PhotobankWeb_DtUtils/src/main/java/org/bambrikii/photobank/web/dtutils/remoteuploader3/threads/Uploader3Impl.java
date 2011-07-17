package org.bambrikii.photobank.web.dtutils.remoteuploader3.threads;

import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.CustomUploadException;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.Status;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.UploadThreadBase;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.FullUploadEventArgs;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.ItemUploadCompleteListenerOrderImpl;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.ItemUploadCompleteListenerPreviewImpl;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.UploadDataManager;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.FailedFiles;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.PersistenceContainer;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.UploadItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Uploader3Impl {
	private final Logger logger = LoggerFactory.getLogger(Uploader3Impl.class);

	public final static String PREVIEW_QUEUE_MARKER = "Preview";
	public final static String ORDER_QUEUE_MARKER = "Order";

	private String url;
	private String previewSourceDir;
	private String orderSourceDir;
	public String DATE_FORMAT = "yyyy.MM.dd_hh.mm";
	public String UPLOAD_FAILED_FILES = "FailedUploads.{0}.xml";

	public Uploader3Impl(String url, String webSourceDir, String orderSourceDir) {
		this.url = url;
		this.previewSourceDir = webSourceDir;
		this.orderSourceDir = orderSourceDir;
	}

	public void upload(String failedListFileName) throws CustomUploadException {

		logger.info(" >>> Starting failed upload...");

		PersistenceContainer pc1 = UploadDataManager
				.unmarshal(failedListFileName);
		PersistenceContainer pc2 = new PersistenceContainer();
		List<ItemUploadCompleteListener> listeners = new LinkedList<ItemUploadCompleteListener>();
		for (final FailedFiles failed : pc1.getFailedFiles()) {
			ItemUploadCompleteListener listener = null;
			UploadThreadBase thread = null;
			if (PREVIEW_QUEUE_MARKER.equals(failed.getName())) {
				listener = new ItemUploadCompleteListenerPreviewImpl();
				thread = getPreviewThread(listener);
			} else if (ORDER_QUEUE_MARKER.equals(failed.getName())) {
				listener = new ItemUploadCompleteListenerOrderImpl();
				thread = getOrderThread(listener);

			}
			if (thread != null && listener != null) {
				for (UploadItem item : failed.getUploadItems()) {
					thread.uploadFile(new File(item.getAbsolutePath()));
				}
				listeners.add(listener);
				FailedFiles failed2 = new FailedFiles();
				failed2.setName(failed.getName());
				failed2.getUploadItems().addAll(
						new ArrayList<UploadItem>(listener.getFilesFailed()));

				if (listener.getFilesFailed().size() > 0) {
					pc2.getFailedFiles().add(failed2);
				}
			}
		}
		for (ItemUploadCompleteListener listener : listeners) {
			printResults(listener);
		}
		if (pc2.getFailedFiles().size() > 0) {
			saveFailedXml(pc2);
		}

		logger.info(" <<< Upload complete.");

	}

	private UploadThreadBase getPreviewThread(
			ItemUploadCompleteListener listener) {
		UploadThreadBase previewThread = new UploadPreviewThread();
		previewThread.setUrl(url + "/photoUpload!massUpload.action");
		previewThread.setSourceDir(new File(previewSourceDir));
		previewThread.addItemUploadCompleteHandler(listener);
		previewThread
				.addFullUploadCompleteHandler(new FullUploadCompleteListener() {

					public void complete(FullUploadEventArgs e) {
						logger.info("Preview thread complete {}!", e.getPath());
					}
				});
		return previewThread;
	}

	private UploadThreadBase getOrderThread(ItemUploadCompleteListener listener) {
		UploadThreadBase orderThread = new UploadOrderThread();
		orderThread.setUrl(url + "/photoUpload!massUpload10x15.action");
		orderThread.setSourceDir(new File(orderSourceDir));
		orderThread.addItemUploadCompleteHandler(listener);
		orderThread
				.addFullUploadCompleteHandler(new FullUploadCompleteListener() {
					public void complete(FullUploadEventArgs e) {
						logger.info("Order thread complete {}!", e.getPath());
					}
				});
		return orderThread;
	}

	public void upload() throws InterruptedException, CustomUploadException {

		logger.info(" >>> Starting upload...");

		final ItemUploadCompleteListener previewListener = new ItemUploadCompleteListenerPreviewImpl();
		final ItemUploadCompleteListener orderListener = new ItemUploadCompleteListenerOrderImpl();

		UploadThreadBase previewThread = getPreviewThread(previewListener);
		UploadThreadBase orderThread = getOrderThread(orderListener);

		new Thread(previewThread).start();
		new Thread(orderThread).start();
		while (!(previewThread.getStatus() == Status.COMPLETE && orderThread
				.getStatus() == Status.COMPLETE)) {
			Thread.sleep(1000);
		}

		printResults(previewListener);
		printResults(orderListener);

		if (previewListener.getFilesFailed().size() > 0
				|| orderListener.getFilesFailed().size() > 0) {
			// Persisting failed files
			PersistenceContainer pc1 = new PersistenceContainer();

			// Persisting failed preview files
			pc1.getFailedFiles().add(new FailedFiles() {
				{
					setName(PREVIEW_QUEUE_MARKER);
					getUploadItems().addAll(
							new ArrayList<UploadItem>(previewListener
									.getFilesFailed()));
				}
			});

			// Persisting failed order files
			pc1.getFailedFiles().add(new FailedFiles() {
				{
					setName(ORDER_QUEUE_MARKER);
					getUploadItems().addAll(
							new ArrayList<UploadItem>(orderListener
									.getFilesFailed()));
				}
			});

			saveFailedXml(pc1);
		}

		logger.info(" <<< Upload complete.");

	}

	private void saveFailedXml(PersistenceContainer pc1)
			throws CustomUploadException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String failedUploadsFileName = MessageFormat.format(
				UPLOAD_FAILED_FILES,
				sdf.format(Calendar.getInstance().getTime()));
		logger.info("	# Failed uploads exist. Saving to {}.",
				failedUploadsFileName);
		UploadDataManager.marshal(pc1, failedUploadsFileName);
	}

	private void printResults(ItemUploadCompleteListener listener) {
		logger.info("	>	% {}: files total {}, files success {}.", new Object[] {
				listener.getClass().getName(), listener.getFilesTotal(),
				listener.getFilesSuccess() });
		if (listener.getFilesFailed().size() > 0) {
			logger.error("		Failed uploads:");
			for (UploadItem item : listener.getFilesFailed()) {
				logger.debug("			{}", new Object[] { item.getAbsolutePath() });
			}
		} else {
			logger.info("		All uploads succeeded.");
		}
		logger.info("	<");
	}
}
