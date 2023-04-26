package ch16.sec04;

public class Person {
	public void action(Calcuable cal) {
		double result = cal.calc(10, 4);
		System.out.println("결과: " + result );
	}
}
