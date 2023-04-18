package ch05.sec05;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		// 자바의 생성자는 객체를 만드는 용도, 객체 생성시 상태를 초기화 하는 용도
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		String s3 = "Hello";
		String s4 = "Hello";
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		s4 = "World";
		System.out.println(s3==s4);
		s4 = "Hello";
		System.out.println(s3==s4);
		System.out.println(s1.equals(s2));
		s1 = "Hello안녕하세요";
		System.out.println(s1);
		System.out.println(s1.length()); 
		//문자열의 길이는 .length(), 배열의 길이 .length, 컬렉션의 크기는 .size()
		char a = s1.charAt(5);
		System.out.println(a);
		// Hello -> World
		System.out.println(s1.replace("Hello", "World"));
		System.out.println(s1);
		s1 = s1.replace("Hello", "World"); //재할당 해야 바뀐다.
		System.out.println(s1.substring(0, 5));
		System.out.println(s2.concat("World"));
		s2 = s2.concat("World");
		System.out.println(s2);
		System.out.println(s2.indexOf("Wol"));
		System.out.println(s2.contains("d"));
		System.out.println(s2.indexOf('W'));
		System.out.println(s2.indexOf('o', 5));
		System.out.println(s2.indexOf('o'));
		String numbers = "1 2 3;4 5 6";
		String[] nums = numbers.split("[ ;]");
		System.out.println(java.util.Arrays.toString(nums));
	}
}
