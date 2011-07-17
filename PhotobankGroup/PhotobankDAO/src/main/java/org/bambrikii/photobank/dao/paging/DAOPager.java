package org.bambrikii.photobank.dao.paging;

import java.util.List;

public class DAOPager<T> {

	private Integer start;
	private Integer length;
	private Integer totalRecordsCount;
	private List<T> records;

	public DAOPager(Integer start, Integer length) {
		this.setStart(start);
		this.setLength(length);
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getStart() {
		return start;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getLength() {
		return length;
	}

	public void setTotalRecordsCount(Integer totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}

	public Integer getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public List<T> getRecords() {
		return records;
	}
}
