package ch02.sec12;

public class PrintExample {
	public static void main(String[] args) {
		String name = "홍길동";
		int age = 25;
		//홍길동님의 나이는 25세이다.
		System.out.println("Hello");
		System.out.println("World");
		System.out.print("Hello");
		System.out.print("World");
		System.out.println("123456789");
		System.out.print("\n"); // == println();
		System.out.println(name + "님의 나이는" + age + "입니다.");
		System.out.printf("%s님의 나이는 %d입니다.\n" , name, age);
		System.out.printf("%s님의 나이는 %5d입니다.\n" , name, age);
		System.out.printf("%s님의 나이는 %-5d입니다.\n" , name, age);
		System.out.printf("%s님의 나이는 %05d입니다.\n" , name, age);
		
		double area = 3.141592 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%f\n 소수점 뒤를 2자리만 남기면? %.2f", 10 ,area, area);
		
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
		
	}
}
