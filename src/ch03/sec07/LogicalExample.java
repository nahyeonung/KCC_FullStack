package ch03.sec07;

public class LogicalExample {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a++>10 && ++b>20); //&가 두개면 오른쪽 연산이 false이면 왼쪽은 실행되지 않는다.
		System.out.println(b);
		
		System.out.println(a++>10 & ++b>20); //&가 하나면 오른쪽 연산이 false여도 왼쪽 연산이 실행된다.
		System.out.println(b);
		
		//||은 앞이 true면 왼쪽 실행 x
		int x = 10;
		int y = 20;
		System.out.println(x++>=10 || ++y>20);
		System.out.println(y);
		System.out.println(x++<10 | ++y>20);
		System.out.println(y);
		
	}
}
