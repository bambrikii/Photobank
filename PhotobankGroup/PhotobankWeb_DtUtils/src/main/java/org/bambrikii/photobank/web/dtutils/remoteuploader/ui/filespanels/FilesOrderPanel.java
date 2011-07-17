package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.filespanels;

public class FilesOrderPanel extends FilesAbstractPanel {
	private static final long serialVersionUID = 4927732862424774617L;

	@Override
	public void upload() throws Exception {
		uploader.uploadOrder(url, chooser.getPath());
	}
}
