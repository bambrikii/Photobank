package org.bambrikii.photobank.business.managers.imageprocessing;

import org.bambrikii.site.base.business.managers.core.ManagerException;

public interface ImageManagerListener {
	public Object saveImageComplete(ImageManagerEvent evt)
			throws ManagerException;
}
