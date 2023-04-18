package ch02.sec11;

public class VariableScopeExample {
	public static void main(String[] args) {
		int v1 = 15;
		if(v1>10) {
			int v2 = v1 - 10;
			System.out.println(v2);
		}
//		System.out.println(v2); 지역변수 잘못 사용 시 에러
	}
}
