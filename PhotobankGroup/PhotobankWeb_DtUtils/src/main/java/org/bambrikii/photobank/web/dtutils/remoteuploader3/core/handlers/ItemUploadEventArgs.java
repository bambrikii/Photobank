package org.bambrikii.photobank.web.dtutils.remoteuploader3.core.handlers;

public class ItemUploadEventArgs {
	private String filename;
	private String response;
	private String absolutepath;

	public ItemUploadEventArgs(String filename, String absolutepath,
			String response) {
		setFilename(filename);
		setAbsolutePath(absolutepath);
		setResponse(response);
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public String getAbsolutePath() {
		return absolutepath;
	}

	public void setAbsolutePath(String absolutepath) {
		this.absolutepath = absolutepath;
	}

}
