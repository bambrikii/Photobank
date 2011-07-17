package org.bambrikii.photobank.web.file;

import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class PhotoEditAction extends SiteBaseAction {
	private static final long serialVersionUID = 5160273693622720533L;

	private File model;

	private PhotoBean photoBean;

	public File getModel() {
		return model;
	}

	public void setModel(File model) {
		this.model = model;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public String delete() throws WebException {
		if (getModel() != null && getModel().getId() != null) {
			getPhotoBean().deleteFile(getModel().getId());
		}
		return SUCCESS;
	}
}
