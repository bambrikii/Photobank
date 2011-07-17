package org.bambrikii.site.base.model;

import org.bambrikii.site.base.auth.model.User;

public class Phone {
	private Integer id;
	private String number;
	private PhoneTypeEnum type;
	private User user;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setType(PhoneTypeEnum type) {
		this.type = type;
	}

	public PhoneTypeEnum getType() {
		return type;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
