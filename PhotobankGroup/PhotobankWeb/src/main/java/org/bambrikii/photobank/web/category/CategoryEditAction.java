package org.bambrikii.photobank.web.category;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.web.category.beans.CategoryBean;
import org.bambrikii.photobank.web.core.AbstractCategoryEditAction;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class CategoryEditAction extends AbstractCategoryEditAction {
	private static final long serialVersionUID = 5467058621414573799L;

	private CategoryBean categoryBean;
	private PhotoBean photoBean;

	private Category model;

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

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

	private void processLegalOwner() throws WebException {
		setLegalOwners(getPhotoBean().getLegalOwners());
		if (getLegalOwner() == null) {
			setLegalOwner(getLegalOwners().get(0));
		}
	}

	// Validation
	public void validate() {

	}

	// Actions
	public String execute() throws Exception {
		return edit();
	}

	@Override
	public String save() throws WebException {
		Category obj = null;
		if (getModel() != null && getModel().getId() != null) {
			obj = getCategoryBean().getById(getModel().getId());
		}
		if (obj == null) {
			obj = new Category();
			obj.setCategoryType(CategoryTypeEnum.DEFAULT);
			obj.setParent(getCategoryBean().getCategory(
					getModel().getParent().getId()));
		}
		obj.setActive(getModel().getActive());
		obj.setCoverFile(getModel().getCoverFile() != null ? getPhotoBean()
				.getById(getModel().getCoverFile().getId()) : null);
		obj.setOrder(getModel().getOrder());
		obj.setDescription(getModel().getDescription());
		obj.setCategoryType(getModel().getCategoryType());
		getCategoryBean().saveOrUpdate(obj);
		setModel(obj);
		processLegalOwner();
		return SUCCESS;
	}

	@Override
	public String delete() throws WebException {
		if (getModel() != null && getModel().getId() != null) {
			Category obj = getCategoryBean().getById(getModel().getId());
			// obj.setActive(false); // using active = false instead of
			// delete();
			// getCategoryBean().saveOrUpdate(obj);
			getCategoryBean().delete(obj);
		}
		processLegalOwner();
		return SUCCESS;
	}

	@Override
	public String edit() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			setModel(getCategoryBean().getById(getModel().getId()));
		}
		processLegalOwner();
		return SUCCESS;
	}

}
