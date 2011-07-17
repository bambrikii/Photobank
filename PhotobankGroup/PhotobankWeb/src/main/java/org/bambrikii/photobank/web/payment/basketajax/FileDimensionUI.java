package org.bambrikii.photobank.web.payment.basketajax;

public class FileDimensionUI {
	private Integer id;
	private String name;
	private String summary;

	public FileDimensionUI() {

	}

	public FileDimensionUI(Integer id2, String name2, String summary2) {
		setId(id2);
		setName(name2);
		setSummary(summary2);
	}

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

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}
}
