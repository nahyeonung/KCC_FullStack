package ch09;

public class A {
	
	void doIt() {
		class B{} //Local class
	}
	
	static class C { //static member class
		void doIt() {
			System.out.println("A.C");
		}
	}
	
	class B{// instance member class
		void doIt() {
			System.out.println("A.B");
		}
	}
	
	
	

}
