package ch02.sec03;

public class CharExample {
	public static void main(String[] args) {
//		ASCII-7bit, EBCDIC-8bit 둘다 한글은 표현 못해서 uniCode를 씀
//		큰따옴표""는 값을 하나 넣는다고 유니코드로 변환되지 않기 때문에 char형에서 ""쓰면 에러가 난다.
		char c = 'B';
		char c1 = 'A'; //컴퓨터는 A 문자와 매핑되는 유니코드 숫자: 65를 대입
		char c2 = 65; //유니코드로 직접 저장
		
		String a = new String("문자열");
		String b  = "입니다";
		a = "다른거";
		
		
//		System.identityHashCode(x)		
		System.out.println(a + b);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1 + c2);
		System.out.println(c + c1);
		
		
		char testC = '\0';
		System.out.println("testC의 값은?" + testC);
	}
}
