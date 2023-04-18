package ch02.sec02;

public class LongExample {
	public static void main(String[] args) {
		long var1 = 10;
		long var2 = 20L;
//		long var3 = 100000000000; 컴파일러는 int로 간주하기 때문에 저장가능 범위 초가로 error발생
		long var4 = 100000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
		
		float f1 = 123456.123456456F; //자바는 기본적으로 실수가 들어오면 double 타입으로 받으려고 한다. 그래서 f를 붙여줘야 float타입으로 인식한다.
		float f2 = 1.23456F*1000;
		float f3 = 1.23456e3F; //지수승으로 표현 가능
		System.out.println(f2 + "|" +  f3);
		
		float f4 = 1.23456E3F;
		System.out.println(f4);
		
	}
}
