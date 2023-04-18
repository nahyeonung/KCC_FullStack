package ch05.sec12;

import java.util.Arrays;

public class EnumExample {
	public static void main(String[] args) {
		int day = Weekday.THRUSDAY;
		day = 6; // type safety 하지 않다.
		Week today = Week.THURSDAY;

		
		System.out.println(today);
		switch(today) {
		case MONDAY:
			System.out.println("월요일"); break;
		case TUESDAY:
			System.out.println("화요일"); break;
		case WEDNESDAY:
			System.out.println("수요일"); break;
		case THURSDAY:
			System.out.println("목요일"); break;
		case FRIDAY:
			System.out.println("금요일"); break;
		case SATURDAY:
			System.out.println("토요일"); break;
 		case SUNDAY:
			System.out.println("일요일"); break;
 		}

		//만들었던 함수를 사용
		switch(today.getValue()){
			case 1:
			System.out.println("숫자 월요일"); break;
			case 2:
			System.out.println("숫자 화요일"); break;
			case 3:
			System.out.println("숫자 수요일"); break;
			case 4:
			System.out.println("숫자 목요일"); break;
			case 5:
			System.out.println("숫자 금요일"); break;
			case 6:
			System.out.println("숫자 토요일"); break;
			case 7:
			System.out.println("숫자 일요일"); break;
 		}
		
	}
}

class Weekday{
	static final int MONDAY = 1; //static에다 final까지 붙으면 이렇게 진한 파란색이 됨
	static final int TUSDAY = 2;
	static final int WENDESDAY = 3;
	static final int THRUSDAY = 4;
	static final int FRIDAY = 5;
}
