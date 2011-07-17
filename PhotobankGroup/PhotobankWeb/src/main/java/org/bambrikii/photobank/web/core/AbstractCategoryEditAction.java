package org.bambrikii.photobank.web.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudAction;

public abstract class AbstractCategoryEditAction extends SiteBaseAction
		implements BaseCrudAction {
	private static final long serialVersionUID = -2873110646277458179L;
	private List<LegalOwner> legalOwners = new ArrayList<LegalOwner>();
	private LegalOwner legalOwner;
	protected List<File> coverFiles = new ArrayList<File>();

	public void setLegalOwners(List<LegalOwner> legalOwners) {
		this.legalOwners = legalOwners;
	}

	public List<LegalOwner> getLegalOwners() {
		return legalOwners;
	}

	public void setLegalOwner(LegalOwner legalOwner) {
		this.legalOwner = legalOwner;
	}

	public LegalOwner getLegalOwner() {
		return legalOwner;
	}

	public List<CategoryTypeEnum> getCategoryTypeList() {
		return Arrays.asList(CategoryTypeEnum.values());
	}

	public void setCoverFiles(List<File> coverFiles) {
		this.coverFiles = coverFiles;
	}

	public List<File> getCoverFiles() {
		return coverFiles;
	}
}
