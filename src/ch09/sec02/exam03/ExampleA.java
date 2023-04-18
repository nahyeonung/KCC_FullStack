package ch09.sec02.exam03;

public class ExampleA {
	public static void main(String[] args) {
		A a = new A();
//		A.B b = a.new B(); //private기 때문에 외부에서 접근 제한됨
		a.say();
	}
}
