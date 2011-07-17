/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bambrikii.site.base.auth.model;

import java.util.List;

public class Privilege {

	private Integer id;
	private String name;
	private int order;
	private List<Group> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

}
