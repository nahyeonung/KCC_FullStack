package ch04.sec07;

public class BreakExample {
	public static void main(String[] args) {
//		int i = 10;
//		while(i) {
//			System.out.println(i);
//		}
		while(true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
