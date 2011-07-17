package org.bambrikii.photobank.web.category;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.web.category.beans.CategoryBean;
import org.bambrikii.photobank.web.core.AbstractFilesAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class CategoryAction extends AbstractFilesAction<Category> {
	private static final long serialVersionUID = -7766397136351117582L;

	private Category model;

	private CategoryBean categoryBean;

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setModel(Category model) {
		this.model = model;
	}

	public Category getModel() {
		return model;
	}

	// Actions
	public String execute() throws WebException {
		Category category = getCategoryBean().getCategory(
				getModel() != null ? getModel().getId() : null);
		setModel(category);
		setPager(getCategoryBean().getCategories(category, getRequestedPage()));
		return SUCCESS;
	}

	public String files() throws WebException {
		Category category = getCategoryBean().getCategory(
				getModel() != null ? getModel().getId() : null);
		setModel(category);
		setFilesPager(getCategoryBean().getFiles(category, getRequestedPage()));
		return "files";
	}
}
