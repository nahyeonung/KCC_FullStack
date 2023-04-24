package ch12.sec12.practice5;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String s1 = "아이디,이름,패스워드";
		StringTokenizer st = new StringTokenizer(s1, ",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
