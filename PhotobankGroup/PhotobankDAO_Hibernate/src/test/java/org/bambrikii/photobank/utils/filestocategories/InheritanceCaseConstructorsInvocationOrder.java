package org.bambrikii.photobank.utils.filestocategories;

import org.junit.Test;

public class InheritanceCaseConstructorsInvocationOrder {
	class A {
		public A() {
			System.out.println("In A ctor");
		}

		public void method1() {
			System.out.println("In A method1");
		}
	}

	class B extends A {
		public B() {
			// super();
			System.out.println("In B ctor");
		}

		public void method1() {
			System.out.println("In B method1");
		}
	}

	@Test
	public void main() {
		B obj = new B();
		obj.method1();
	}
}
