package org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers;

import java.util.Set;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.UploadItem;

public interface ItemUploadCompleteListener {
	public void complete(ItemUploadEventArgs e);

	public void failed(ItemUploadEventArgs e, Throwable throwable);

	public Integer getFilesTotal();

	public Integer getFilesSuccess();

	public Set<UploadItem> getFilesFailed();
}
