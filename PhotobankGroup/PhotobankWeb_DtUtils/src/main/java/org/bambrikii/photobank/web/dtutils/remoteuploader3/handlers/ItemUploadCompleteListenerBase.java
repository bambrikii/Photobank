package org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers.ItemUploadCompleteListener;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.UploadItem;

public abstract class ItemUploadCompleteListenerBase implements
		ItemUploadCompleteListener {
	private AtomicInteger filesTotal = new AtomicInteger(0);
	private AtomicInteger filesSuccess = new AtomicInteger(0);

	private Set<UploadItem> filesFailed = new HashSet<UploadItem>();

	protected synchronized void incFilesTotal() {
		filesTotal.addAndGet(1);
	}

	protected synchronized void incFilesSuccess() {
		filesSuccess.addAndGet(1);
	}

	public Integer getFilesTotal() {
		return filesTotal.get();
	}

	public Integer getFilesSuccess() {
		return filesSuccess.get();
	}

	public Set<UploadItem> getFilesFailed() {
		return filesFailed;
	}
}
