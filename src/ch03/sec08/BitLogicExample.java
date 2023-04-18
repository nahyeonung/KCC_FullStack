package ch03.sec08;

public class BitLogicExample {
	public static void main(String[] args) {
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45: " + ~45);
		System.out.println("--------------------------------------");
		
		byte receiveData = -120;
		
		//방법1: 비트 논리곱 연산으로 Unsigned 정수 얻기
		int unsigned1 = receiveData & 255;
		System.out.println(unsigned1);
		
		//방법2: 자바 API를 이용해서 Unsigned 정수 얻기
		int unsigned2 = Byte.toUnsignedInt((byte)-120);
		//Unsinged는 말 그대로 부호가 없다는 뜻으로, 음수 없이 양수로만 이루어진 비트로 계산한 값을 반환해준다.
		System.out.println(unsigned2);
		
		int test = 136;
		byte btest = (byte) test;
		System.out.println(btest);
	}
}
