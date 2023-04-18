package ch04.sec04;

public class FloatCounterExample {
	public static void main(String[] args) {
		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.print(x);
		}
		System.out.println();
		for(double x=0.1; x<=1.0; x+=0.1) {
			System.out.print(x);
		}
	}
}
