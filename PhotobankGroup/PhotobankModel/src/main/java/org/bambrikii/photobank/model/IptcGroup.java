/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bambrikii.photobank.model;

import java.util.Date;
import java.util.List;

public class IptcGroup {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File value) {
		this.file = value;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	private List<IptcField> fields;

	public List<IptcField> getFields() {
		return fields;
	}

	public void setFields(List<IptcField> list) {
		fields = list;
	}

	private Date modificationTime;

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date value) {
		modificationTime = value;
	}
}
