package ch05.sec05;

public class EqualsExample {
	public static void main(String[] args) {
//		String strVar1 = "홍길동";
//		String strVar2 = "홍길동";
//		// 자바의 생성자는 객체를 만드는 용도, 객체 생성시 상태를 초기화 하는 용도
//		String s1 = new String("Hello");
//		String s2 = new String("Hello");
//		String s3 = "Hello";
//		
//		
//		if(strVar1 == strVar2) {
//			System.out.println("strVar1과 strVar2는 참조가 같음");
//		}else {
//			System.out.println("strVar1과 strVar2는 참조가 다름");
//		}
//		
//		if(strVar1.equals(strVar2)) {
//			System.out.println("strVar1과 strVar2는 문자열이 같음");
//		}
		
		String ss = "Hello안녕하세요.";
		char a = ss.charAt(5);
		System.out.println(a);
		// Hello - > World
		System.out.println(ss);
		System.out.println(ss.replace("Hello", "World"));
		System.out.println(ss);
		ss = ss.replace("Hello", "World"); //재할당 해야 바뀐다.
		System.out.println(ss);
	}
}
