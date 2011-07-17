package org.bambrikii.photobank.dao;

import org.bambrikii.photobank.model.File;

public class FileFullTextWeight extends File {
	private Float weight;

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getWeight() {
		return weight;
	}
}
