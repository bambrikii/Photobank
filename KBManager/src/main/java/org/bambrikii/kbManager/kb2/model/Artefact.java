package org.bambrikii.kbManager.kb2.model;

import java.util.List;

public class Artefact {
	private Integer id;
	private String key;

	private List<Relation> srcParents;
	private List<Relation> dstParents;
	private List<Relation> kndParents;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setSrcParents(List<Relation> asSrcParents) {
		this.srcParents = asSrcParents;
	}

	public List<Relation> getSrcParents() {
		return srcParents;
	}

	public void setDstParents(List<Relation> asDstParents) {
		this.dstParents = asDstParents;
	}

	public List<Relation> getDstParents() {
		return dstParents;
	}

	public void setKndParents(List<Relation> asKndParents) {
		this.kndParents = asKndParents;
	}

	public List<Relation> getKndParents() {
		return kndParents;
	}
}
