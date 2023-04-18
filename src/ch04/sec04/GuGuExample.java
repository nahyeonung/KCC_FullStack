package ch04.sec04;

public class GuGuExample {
	public static void main(String[] args) {
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.printf("%dx%d=%2d ", j,i,i*j);
			}
			System.out.println();
		}
	}
}
