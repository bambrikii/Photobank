/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bambrikii.site.base.auth.model;

import java.util.List;

public class Group {

	private Integer id;
	private String name;
	private boolean active;
	private int order;
	private String password;
	private List<Privilege> privileges;
	private List<User> users;

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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}
}
