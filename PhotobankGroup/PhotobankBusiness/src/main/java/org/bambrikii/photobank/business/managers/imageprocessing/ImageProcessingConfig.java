package org.bambrikii.photobank.business.managers.imageprocessing;

public class ImageProcessingConfig {
	private String destFolderName;
	private String wmFileName;
	private String webSubFolderName;
	private String smallPreviewFolderName;
	private String largePreviewFolderName;
	private Integer smallDim;
	private Integer largeDim;

	public void setDestFolderName(String destFolderName) {
		this.destFolderName = destFolderName;
	}

	public String getDestFolderName() {
		return destFolderName;
	}

	public void setWmFileName(String wmFileName) {
		this.wmFileName = wmFileName;
	}

	public String getWmFileName() {
		return wmFileName;
	}

	public void setWebSubFolderName(String webSubFolderName) {
		this.webSubFolderName = webSubFolderName;
	}

	public String getWebSubFolderName() {
		return webSubFolderName;
	}

	public void setSmallPreviewFolderName(String smallPreviewFolderName) {
		this.smallPreviewFolderName = smallPreviewFolderName;
	}

	public String getSmallPreviewFolderName() {
		return smallPreviewFolderName;
	}

	public void setLargePreviewFolderName(String largePreviewFolderName) {
		this.largePreviewFolderName = largePreviewFolderName;
	}

	public String getLargePreviewFolderName() {
		return largePreviewFolderName;
	}

	public void setSmallDim(Integer smallDim) {
		this.smallDim = smallDim;
	}

	public Integer getSmallDim() {
		return smallDim;
	}
}
