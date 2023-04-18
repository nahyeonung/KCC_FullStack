package testPage;

public class Example {
	public static void main(String[] args) {
		String a = "첫번째";
		int address = System.identityHashCode(a);
		System.out.println(address);
		a = "두번째";
		address = System.identityHashCode(a);
		System.out.println(address);
		String b = "첫번째";
		address = System.identityHashCode(b);
		System.out.println(address);
		
		int pencils = 534;
		int students = 30;
		int pencilsPerStudent = pencils / students;
		int pencilLeft = pencils % students;
		System.out.println(pencilsPerStudent + "|" + pencilLeft);
		
		int val = 795;
		System.out.println(val / 100 * 100);
		
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop+lengthBottom) * height * 1.0 / 2;
		double area2 = (double)(lengthTop + lengthBottom) * height / 2;
		System.out.println(area);
		System.out.println(area2);
		
		int x_6 = 10;
		int y_6 = 5;
		System.out.println((x_6>7)&&(y_6<=5));
		System.out.println((x_6%3 == 2) || (y_6%2 != 1));
		
	}
}
