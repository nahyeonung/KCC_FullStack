package ch12.sec04;

public class MeasureRunTimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime(); //프로그램 시작 시간
		int sum = 0;
		for(int i=0; i<=1000000; i++) {
			sum += 1;
		}
		long time2 = System.nanoTime(); //프로그램 종료 시간
		
		System.out.println("for문의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1) + "나노초가 소요되었습니다.");
	}
}
