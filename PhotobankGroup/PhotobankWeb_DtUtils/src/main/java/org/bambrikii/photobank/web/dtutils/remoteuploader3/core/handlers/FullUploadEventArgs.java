package org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers;

public class FullUploadEventArgs {
	private String path;

	public FullUploadEventArgs(String path) {
		this.path = path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
