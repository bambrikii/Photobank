package org.bambrikii.photobank.web.events;

import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.web.core.AbstractCategoryEditAction;
import org.bambrikii.photobank.web.events.beans.EventBean;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware(allowedRoles = { "service_manager" })
public class EventEditAction extends AbstractCategoryEditAction {
	private static final long serialVersionUID = -730871801696927688L;

	private EventBean eventBean;
	private PhotoBean photoBean;

	private Event model;
	private File coverFile;

	public void setCoverFile(File coverFile) {
		this.coverFile = coverFile;
	}

	public File getCoverFile() {
		return coverFile;
	}

	public EventBean getEventBean() {
		return eventBean;
	}

	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public void setModel(Event model) {
		this.model = model;
	}

	public Event getModel() {
		return model;
	}

	private void processLegalOwner() throws WebException {
		setLegalOwners(getPhotoBean().getLegalOwners());
		if (getLegalOwner() == null) {
			setLegalOwner(getLegalOwners().get(0));
		}
	}

	private void processCoverFiles() throws ManagerException {
		if (getModel() != null && getModel().getId() != null) {
			setCoverFiles(getEventBean().getFiles(getModel()));
		}
	}

	// Validation

	public void validate() {

	}

	// Actions
	public String execute() throws Exception {
		return edit();
	}

	public String save() throws Exception {
		Event obj = null;
		if (getModel() != null && getModel().getId() != null) {
			obj = getEventBean().getById(getModel().getId());
		}
		if (obj == null) {
			obj = new Event();
			obj.setCategoryType(CategoryTypeEnum.DEFAULT);
			obj.setParent(getEventBean().getCategory(
					getModel().getParent().getId()));
		}
		obj.setActive(getModel().getActive());
		obj.setCoverFile(getCoverFile() != null ? getPhotoBean()
				.getById(getCoverFile().getId()) : null);
		obj.setOrder(getModel().getOrder());
		obj.setDescription(getModel().getDescription());
		obj.setText(getModel().getText());
		obj.setCategoryType(getModel().getCategoryType());
		getEventBean().saveOrUpdate(obj);
		setModel(obj);
		processLegalOwner();
		processCoverFiles();
		return SUCCESS;
	}

	public String delete() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			Event obj = getEventBean().getById(getModel().getId());
			obj.setActive(false); // using active = false instead of delete();
			getEventBean().saveOrUpdate(obj);
		}
		processLegalOwner();
		processCoverFiles();
		return SUCCESS;
	}

	@Override
	public String edit() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			setModel(getEventBean().getById(getModel().getId()));
		}
		processLegalOwner();
		processCoverFiles();
		return SUCCESS;
	}
}
