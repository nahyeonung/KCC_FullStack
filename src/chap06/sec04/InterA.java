package chap06.sec04;

public interface InterA {
	int NUMBER = 10;
	default void doIt() {
		System.out.println("InterA.doIt");
	}
}

abstract class AbsA {
	int NUMBER = 20;
	public void doIt() {
		System.out.println("AbsA.doIt");
	}
}
