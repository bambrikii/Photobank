package org.bambrikii.kbManager.kb2.model;

public class ArtefactAsOperator extends Artefact {
	public enum Operator {
		ANY, SOME, NONE
	}

	private Operator operator;

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}
}
