package org.bambrikii.photobank.model;

import java.util.Date;
import java.util.List;

public class Category {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Category parent;

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	private Date modificationTime;

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	private boolean active;

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private Integer order;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	private CategoryTypeEnum categoryType;

	public CategoryTypeEnum getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryTypeEnum categoryType) {
		this.categoryType = categoryType;
	}

	protected List<Category> children;

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> list) {
		children = list;
	}

	protected List<File> files;

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> list) {
		files = list;
	}

	private File coverFile;

	public File getCoverFile() {
		return coverFile;
	}

	public void setCoverFile(File coverFile) {
		this.coverFile = coverFile;
	}
}
