package ch03.sec01;

public class IncDecExample {
	public static void main(String[] args) {
		//증감 연산자가 변수 앞에 붙으면 해당 라인 실행할 때 값에 적용된다.
		int i = 10;
		int result = ++i + 10;
		System.out.println(i);
		System.out.println(result);
		
		//증감 연산자가 변수 뒤에 붙으면 해당 라인이 종료한 후에 값에 적용된다.
		int j = 10;
		int result2 = j++ + 10;
		System.out.println(j);
		System.out.println(result2);
		
	}
}
