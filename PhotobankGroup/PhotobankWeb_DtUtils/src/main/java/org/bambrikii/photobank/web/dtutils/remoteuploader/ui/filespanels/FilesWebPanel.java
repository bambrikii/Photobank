package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.filespanels;

public class FilesWebPanel extends FilesAbstractPanel {
	private static final long serialVersionUID = -4640650927207150041L;

	@Override
	public void upload() throws Exception {
		uploader.uploadWeb(url, chooser.getPath());
	}
}
