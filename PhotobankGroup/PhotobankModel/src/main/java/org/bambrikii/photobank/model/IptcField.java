/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bambrikii.photobank.model;

import java.util.Date;

public class IptcField {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	private IptcGroup group;

	public IptcGroup getGroup() {
		return group;
	}

	public void setGroup(IptcGroup value) {
		group = value;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

	private String val;

	public String getValue() {
		return val;
	}

	public void setValue(String value) {
		val = value;
	}

	private Date modificationTime;

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date value) {
		modificationTime = value;
	}
}
