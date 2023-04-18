package ch09;

import ch09.A.C;

public class InnerExample {
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); //A.B b = new A().new B();
		b.doIt();
		
		A.C c = new A.C();
		c.doIt();
	}
}
