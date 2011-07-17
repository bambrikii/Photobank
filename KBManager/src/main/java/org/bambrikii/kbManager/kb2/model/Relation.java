package org.bambrikii.kbManager.kb2.model;

public class Relation {
	private Integer id;
	private Artefact source;
	private Artefact destination;
	private Artefact kind;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSource(Artefact source) {
		this.source = source;
	}

	public Artefact getSource() {
		return source;
	}

	public void setDestination(Artefact destination) {
		this.destination = destination;
	}

	public Artefact getDestination() {
		return destination;
	}

	public void setKind(Artefact kind) {
		this.kind = kind;
	}

	public Artefact getKind() {
		return kind;
	}
}
