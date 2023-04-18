package ch09.sec02.exam03;

public class A {
	private class B{
		public void say() {
			System.out.println("B클래스 실행");
		}
	}
	public void say() {
		B b = new B();
		b.say();
		System.out.println("A클래스 실행");
	}
}
