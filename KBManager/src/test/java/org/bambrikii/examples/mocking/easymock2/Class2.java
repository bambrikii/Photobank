package org.bambrikii.examples.mocking.easymock2;

public class Class2 {
	private Interface1 class1;
	private String str1;

	public Class2(Interface1 class1Mock) {
		this.class1 = class1Mock;
	}

	public void method1(String someStr1) {
		str1 = class1.method1(someStr1);
	}

	public String getStr1() {
		return str1;
	}
}
