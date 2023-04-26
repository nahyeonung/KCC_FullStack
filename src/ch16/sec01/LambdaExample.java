package ch16.sec01;

public class LambdaExample {
	public static void main(String[] args) {
		
		//인터페이스 함수 사용 방법1
		action(new MyCalc1());
		
		//인터페이스 함수 사용 방법2
		action(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println(x+y);
			}
		});
		
		//인터페이스 함수 사용 방법3
		action((x,y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});
		action((x,y) -> {
			int result = x - y;
			System.out.println("result2: " + result);
		});
		
		
	}
	public static void action(Calculable cal) {
		int x = 10;
		int y = 4;
		//데이터처리
		cal.calculate(x, y);
	}
}
