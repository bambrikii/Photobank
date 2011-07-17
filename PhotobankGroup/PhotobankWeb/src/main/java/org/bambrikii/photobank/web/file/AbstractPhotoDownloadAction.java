package org.bambrikii.photobank.web.file;

import java.io.InputStream;

import org.bambrikii.site.base.struts2.core.SiteBaseAction;

public abstract class AbstractPhotoDownloadAction extends SiteBaseAction {
	private static final long serialVersionUID = -4794089947747814659L;

	private Integer id;

	private String contentType = "image/jpeg";
	private String filename;
	private InputStream inputStream;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}


}
