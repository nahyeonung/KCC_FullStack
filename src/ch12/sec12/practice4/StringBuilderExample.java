package ch12.sec12.practice4;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<100; i++) {
			str.append(i);
		}
		System.out.println(str);
	}
}
