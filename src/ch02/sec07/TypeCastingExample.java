package ch02.sec07;

public class TypeCastingExample {
	public static void main(String[] args) {
		int a = 984;
		byte b = (byte) a;
		System.out.println(b);
		System.out.println(5/2.); //정수와 정수의 연산은 정수로 return하기 때문에 실수를 넣어주기 위해 2뒤에 .을 붙여준 것

		byte x = 10;
		byte y = 20;
		byte z = (byte)(x+y);
		int r = x + y;
		byte l = 10 + 20;
		System.out.println(z + "|" + r + "|" + l);
		
	
	}
}
