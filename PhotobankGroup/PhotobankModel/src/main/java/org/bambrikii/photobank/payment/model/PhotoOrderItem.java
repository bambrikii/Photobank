package org.bambrikii.photobank.payment.model;

import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.site.base.payment.model.OrderItem;

public class PhotoOrderItem extends OrderItem {
	private File file;
	private FileDimension dimension;

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setDimension(FileDimension dimension) {
		this.dimension = dimension;
	}

	public FileDimension getDimension() {
		return dimension;
	}

}
