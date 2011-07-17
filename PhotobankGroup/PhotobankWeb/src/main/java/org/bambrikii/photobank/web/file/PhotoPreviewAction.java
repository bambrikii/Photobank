package org.bambrikii.photobank.web.file;

import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.file.beans.PreviewTypeEnum;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

public class PhotoPreviewAction extends AbstractPhotoDownloadAction {
	private static final long serialVersionUID = -54729072350305006L;

	private PhotoBean photoBean;

	// Beans
	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	// Actions
	public String small() throws WebException {
		try {
			setInputStream(getPhotoBean().getPhotoStream(getId(),
					PreviewTypeEnum.SMALL_PREVIEW));
		} catch (Exception ex) {
			throw new WebException("Download failed", ex);
		}
		return "small";
	}

	@SiteBaseSecurityAware
	public String large() throws WebException {
		setInputStream(getPhotoBean().getPhotoStream(getId(),
				PreviewTypeEnum.LARGE_PREVIEW));
		return "large";
	}
}
