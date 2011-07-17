package org.bambrikii.kbManager.parser.model;

public class Relation {
	private Integer id;
	private Knowledge knowledge;
	private Knowledge first;
	private Knowledge last;
	private Knowledge direction;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setFirst(Knowledge first) {
		this.first = first;
	}

	public Knowledge getFirst() {
		return first;
	}

	public void setLast(Knowledge last) {
		this.last = last;
	}

	public Knowledge getLast() {
		return last;
	}

	public void setDirection(Knowledge direction) {
		this.direction = direction;
	}

	public Knowledge getDirection() {
		return direction;
	}
}
