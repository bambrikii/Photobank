package org.bambrikii.photobank.web.payment.basketajax;

import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.payment.model.PhotoOrder;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.logging.beans.LoggingBean;
import org.bambrikii.photobank.web.payment.beans.BasketBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware
public class BasketAjaxAction extends SiteBaseAction {
	private static final long serialVersionUID = -4141326314205836250L;
	private BasketBean basketBean;
	private PhotoBean photoBean;
	private LoggingBean loggingBean;

	private int itemId;
	private int fileId;

	private PhotoOrderItem item;
	private FileUI file;

	private Category contextCategory;
	private List<FileDimensionUI> dimensions;

	private int selectedDimensionId;

	public void setBasketBean(BasketBean basketBean) {
		this.basketBean = basketBean;
	}

	@JSON(deserialize = false, serialize = false)
	public BasketBean getBasketBean() {
		return basketBean;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	@JSON(deserialize = false, serialize = false)
	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public void setLoggingBean(LoggingBean loggingBean) {
		this.loggingBean = loggingBean;
	}

	@JSON(deserialize = false, serialize = false)
	public LoggingBean getLoggingBean() {
		return loggingBean;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setItem(PhotoOrderItem item) {
		this.item = item;
	}

	@JSON(deserialize = false, serialize = false)
	public PhotoOrderItem getItem() {
		return item;
	}

	public void setFile(FileUI file) {
		this.file = file;
	}

	public FileUI getFile() {
		return file;
	}

	public void setContextCategory(Category contextCategory) {
		this.contextCategory = contextCategory;
	}

	@JSON(deserialize = false, serialize = false)
	public Category getContextCategory() {
		return contextCategory;
	}

	public void setDimensions(List<FileDimensionUI> dimensions) {
		this.dimensions = dimensions;
	}

	// @JSON(deserialize = false, serialize = false)
	public List<FileDimensionUI> getDimensions() {
		return dimensions;
	}

	private PhotoOrder getCurrentOrder() throws WebException {
		return getBasketBean().getOrder(getSession());
	}

	public void setSelectedDimensionId(int selectedDimensionId) {
		this.selectedDimensionId = selectedDimensionId;
	}

	public int getSelectedDimensionId() {
		return selectedDimensionId;
	}

	private void fillDimensions() throws WebException {
		List<FileDimensionUI> dim1 = new LinkedList<FileDimensionUI>();
		List<FileDimension> dims2 = getPhotoBean().getFileDimensions();
		for (FileDimension dim2 : dims2) {
			if (dim2.getActive()) {
				dim1.add(new FileDimensionUI(dim2.getId(), dim2.getName(),
						getBasketBean().getDimensionPricesSummary(dim2)));
			}
		}
		setDimensions(dim1);
	}

	private void fillFile(File file) throws ManagerException {
		FileUI fileUI = new FileUI();
		fileUI.setId(file.getId());
		fileUI.setDescription(file.getDescription());
		Category contextCateg2 = getPhotoBean().getParent(file);
		if (contextCateg2 != null) {
			if (contextCateg2 instanceof Event) {
				Event contextCateg = (Event) contextCateg2;
				fileUI.setDate(contextCateg.getInsertionTime());
				fileUI.setEventName(contextCateg.getDescription());
			} else {
				fileUI.setDate(contextCateg2.getModificationTime());
			}
		}
		setFile(fileUI);
	}

	// Actions
	public String previewItem() throws Exception {
		PhotoOrderItem item = getBasketBean().getItemById(getItemId());
		setItem(item);
		// TODO: Display basket item
		fillFile(item.getFile());
		fillDimensions();
		setSelectedDimensionId(item.getDimension().getId());
		getLoggingBean().countFilePreview(item.getFile());
		return "previewItem";
	}

	public String previewFile() throws Exception {
		File file = getPhotoBean().getById(getFileId());
		fillFile(file);
		fillDimensions();
		getLoggingBean().countFilePreview(file);
		return "previewFile";
	}

	public String removeItem() throws Exception {
		getBasketBean().removeItem(getCurrentOrder(), getItemId());
		return SUCCESS;
	}

	public String addItem() throws Exception {
		getBasketBean().addItem(getCurrentOrder(), getFileId(),
				getSelectedDimensionId());
		return SUCCESS;
	}

	public String updateItem() throws Exception {
		getBasketBean().updateItem(getItemId(), getSelectedDimensionId());
		return SUCCESS;
	}

	public String empty() throws Exception {
		getBasketBean().emptyBaskey(getCurrentOrder());
		return SUCCESS;
	}
}
