package com.pluralsight.corejava8.general;

public class Nesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		B.C obj = new B().new C();

	}

}

class A {

	int val;

	A(int v) {
		val = v + 39;
	}

}

class B extends A {

	int val = 1;

	B() {
		super(2);
	}

	class C extends A {

		int val = 3;

		C() {

			super(4);
			System.out.println(B.this.val);
			System.out.println(C.this.val);
			System.out.println(super.val);

		}
	}

}