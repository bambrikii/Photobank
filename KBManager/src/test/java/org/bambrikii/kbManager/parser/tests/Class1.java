package org.bambrikii.kbManager.parser.tests;

public class Class1<T> {
	private static String property1	= "property1 value";
	public Class1(String str){
		setProperty1(str);
	}
	public void setProperty1(String property1) {
		Class1.property1 = property1;
	}
	public String getProperty1() {
		return property1;
	}
}
