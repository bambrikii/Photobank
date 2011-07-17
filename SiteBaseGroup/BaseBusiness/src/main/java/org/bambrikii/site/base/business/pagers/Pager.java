package org.bambrikii.site.base.business.pagers;

import java.util.List;

public class Pager<T> implements Cloneable {
	private Integer rowsCount;
	private Integer colsCount;
	private Integer currPage;
	private Integer totalRecordsCount;
	private List<T> records;

	public Pager(int cols, int rows) {
		this.colsCount = cols;
		this.rowsCount = rows;
	}

	public Pager(int cols, int rows, int currPage) {
		this.colsCount = cols;
		this.rowsCount = rows;
		this.currPage = currPage;
	}

	public Pager(Integer cols, Integer rows, Integer currPage, Integer records) {
		this.colsCount = cols;
		this.rowsCount = rows;
		this.currPage = currPage;
		this.totalRecordsCount = records;
	}

	public Integer getStart() {
		return rowsCount * colsCount * currPage;
	}

	public Integer getLength() {
		return rowsCount * colsCount;
	}

	public Pager<T> clone() {
		Pager<T> pager = new Pager<T>(colsCount, rowsCount, currPage,
				totalRecordsCount);
		return pager;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> list) {
		this.records = list;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public Integer getColsCount() {
		return colsCount;
	}

	public void setColsCount(Integer colsCount) {
		this.colsCount = colsCount;
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}

	public Integer getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setTotalRecordsCount(Integer recordsCount) {
		this.totalRecordsCount = recordsCount;
	}
}
