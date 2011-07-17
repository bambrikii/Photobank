package org.bambrikii.photobank.business.managers.imageprocessing.handlers;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.LegalOwner;

public class ProcessedEventInfo {
	private String headline;
	private String caption;
	private LegalOwner legalOwner;
	private Category parentCategory;

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getHeadline() {
		return headline;
	}

	public ProcessedEventInfo() {
	}

	public LegalOwner getLegalOwner() {
		return legalOwner;
	}

	public void setLegalOwner(LegalOwner legalOwner) {
		this.legalOwner = legalOwner;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}
}
