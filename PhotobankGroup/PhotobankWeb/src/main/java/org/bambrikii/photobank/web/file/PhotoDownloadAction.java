package org.bambrikii.photobank.web.file;

import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

public class PhotoDownloadAction extends AbstractPhotoDownloadAction {
	private static final long serialVersionUID = 4333848587426085405L;

	private PhotoBean photoBean;

	// Beans
	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public String item() throws Exception {
		setInputStream(getPhotoBean().getPhotoStream(getId(),
				(Integer) getSession().get(AuthBean.USER_ID_KEY)));
		return "item";
	}
}
