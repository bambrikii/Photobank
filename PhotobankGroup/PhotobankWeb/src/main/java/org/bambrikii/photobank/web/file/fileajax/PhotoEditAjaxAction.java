package org.bambrikii.photobank.web.file.fileajax;

import org.apache.struts2.json.annotations.JSON;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class PhotoEditAjaxAction extends SiteBaseAction {
	private static final long serialVersionUID = -8665259960727069135L;
	private PhotoBean photoBean;
	private Integer[] itemIds;

	public void setItemIds(Integer[] itemIds) {
		this.itemIds = itemIds;
	}

	public Integer[] getItemIds() {
		return itemIds;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	@JSON(deserialize = false, serialize = false)
	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public String delete() throws WebException {
		for (Integer itemId : itemIds) {
			getPhotoBean().deleteFile(itemId);
		}
		return SUCCESS;
	}
}
