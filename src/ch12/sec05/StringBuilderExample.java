package ch12.sec05;

public class StringBuilderExample {
	public static void main(String[] args) {
		String data = new StringBuilder()
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();
		StringBuilder data2 = new StringBuilder("ABC");
		data2.append("DEF");
		System.out.println(data);
		System.out.println(data2);
	}
}
