package ch12.sec12.practice8;

import java.util.regex.Pattern;

public class PatternMatcherExample {
	public static void main(String[] args) {
		String id = "5Angel1004";
		String id2 = "a5Angel1004";
//		String regexp = "[a-zA-Z][0-9a-zA-Z]{7,11}";
		String regexp = "[a-zA-Z]\\w{7,11}";
		boolean result = Pattern.matches(regexp, id2);
		if(result) {
			System.out.println("ID로 사용할 수 있습니다.");
		}else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}
}
