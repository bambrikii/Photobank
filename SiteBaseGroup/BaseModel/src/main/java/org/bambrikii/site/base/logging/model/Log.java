package org.bambrikii.site.base.logging.model;

import java.util.Date;

public class Log {
	private Integer id;
	private String name;
	private String text;
	private Date time;
	private LogLevelEnum level;
	private Source source;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setLevel(LogLevelEnum level) {
		this.level = level;
	}

	public LogLevelEnum getLevel() {
		return level;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Source getSource() {
		return source;
	}
}
