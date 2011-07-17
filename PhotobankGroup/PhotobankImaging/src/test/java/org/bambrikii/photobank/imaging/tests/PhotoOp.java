package org.bambrikii.photobank.imaging.tests;

public class PhotoOp {
	private String sourceFile;
	private String dstFileName;
	private int maxDim = 50;
	private String watermark;

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String file) {
		this.sourceFile = file;
	}

	public int getMaxDim() {
		return maxDim;
	}

	public void setMaxDim(int maxDim) {
		this.maxDim = maxDim;
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String file) {
		this.watermark = file;
	}

	public void setDstFileName(String dstFileName) {
		this.dstFileName = dstFileName;
	}

	public String getDstFileName() {
		return dstFileName;
	}
}
