package org.bambrikii.photobank.web.file;

import java.io.File;
import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;

public class PhotoUploadAction extends SiteBaseAction {
	private static final long serialVersionUID = 4913677422064900420L;
	// Upload action
	private List<File> filedata;
	private List<String> filename;
	private Category category;
	private LegalOwner legalOwner;

	private PhotoBean photoBean;

	private Integer id;

	public List<File> getFiledata() {
		return filedata;
	}

	public void setFiledata(List<File> filedata) {
		this.filedata = filedata;
	}

	public List<String> getFilename() {
		return filename;
	}

	public void setFilename(List<String> filename) {
		this.filename = filename;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public void setLegalOwner(LegalOwner legalOwner) {
		this.legalOwner = legalOwner;
	}

	public LegalOwner getLegalOwner() {
		return legalOwner;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Actions
	public String execute() {
		return SUCCESS;
	}

	public String massUpload() throws Exception {
		if (getFiledata() != null) {
			for (int i = 0; i < getFiledata().size(); i++) {
				org.bambrikii.photobank.model.File result = getPhotoBean()
						.saveFile(getFiledata().get(i), getFilename().get(i));
				setId(result.getId());
			}
			return "uploadResult";
		} else {
			return ERROR;
		}
	}

	public String massUpload10x15() throws Exception {
		if (getFiledata() != null) {
			for (int i = 0; i < getFiledata().size(); i++) {
				getPhotoBean().saveFile10x15(getFiledata().get(i),
						getFilename().get(i));
				setId(0);
			}
			return "uploadResult";
		} else {
			return ERROR;
		}
	}
}
