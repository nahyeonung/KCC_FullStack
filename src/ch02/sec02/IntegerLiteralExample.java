package ch02.sec02;

public class IntegerLiteralExample {
	public static void main(String[] args) {
		int var = 0b01100110; //2진수 0b
		int var2 = 0146; //8진수 0
		int var3 = 102; //10진수
		int var4 = 0x66; //16진수 0x
		int e = 0b01100110_00000111; //2진수는 보기 힘드니까 8자리 수 마다 언터스토어..?_를 넣어줄 수 있음

		float result = 1.2f + 3.4f;
		
		byte b6 = (byte)129;
		System.out.println(b6);
		
		
		int num = 129;
		byte answer = (byte)num;
		
		System.out.println("var: " + var);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println(e);
	}
}
