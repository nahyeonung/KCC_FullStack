package ch09.sec05;

public class A {
	int a=10; //인스턴스 멤버변수
	void doIt() { } //인스턴스 메서드
	
	static int b; //정적 멤버변수
	static void doThat() {} //정적 메서드
	
	class B{
		int a = 20;
		void method1() {
			a = 30;
			b = 20;
		}
	}
	static class C{
		int a = 10;
		void method1() {
			b = 10;
			A a1 = new A();
			a1.a = 20;
		}
	}
}
