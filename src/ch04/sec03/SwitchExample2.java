package ch04.sec03;

public class SwitchExample2 {
	public static void main(String[] args) {
		int a = 7;
		char b = switch(a) {
			case 10,9,8 -> 'A';
			case 7,6,5 -> {char c = 'B';
							yield c;}
			default -> 'C';
		};
		System.out.println(b);
	}
}
