package org.bambrikii.photobank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class File {

	private Integer id;
	private String description;
	private Category category;
	private String fileName;
	private Date modificationTime;
	private List<IptcGroup> iptcGroups = new ArrayList<IptcGroup>();
	private boolean active;
	private int order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public List<IptcGroup> getIptcGroups() {
		return iptcGroups;
	}

	public void setIptcGroups(List<IptcGroup> value) {
		iptcGroups = value;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}
}
