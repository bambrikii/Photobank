package org.bambrikii.site.base.logging.model;

import java.util.Date;

public class Counter {
	private Integer id;
	private Date time;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}
}
