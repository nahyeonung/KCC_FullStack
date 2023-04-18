package ch03.sec10;

public class AssignmentOperatorExample {
	public static void main(String[] args) {
		int data = 10;
		data += 5;
		System.out.println(data);
		int data2 = 30;
		data2 =+ 5; // =뒤에 나오는 + or -는 연산자가 아닌 부호로 간주한다.
		System.out.println(data2);


		byte data3 = 5;
		//		data3 = data3 + 5 자동 타입 변환으로 int타입으로 바껴서 에러가 난다.
		data3 += 3; //복합할당 연산자는 원래 타입을 유지한다.(즉, 여기선 byte 타입을 유지한 것)
		System.out.println(data3);

		int a = 10;
		int b = 10;
		boolean result = (a++>10) & (++a>10); //오른쪽 연산에서 false가 나온 후 a++가 된다. 그리고 괄호가 벗겨지고 왼쪽 연산이 실행된다고 생각하면 된다.
		boolean resultt = b++>10 & ++b>10;
		System.out.println(b);
		System.out.println(result);
		System.out.println(a);

		int result1 = 0;
		result1 += 10;
		System.out.println("result1: " + result1);
		result1 -= 5;
		System.out.println("result1: " + result1);
		result1 *= 3;
		System.out.println("result1: " + result1);
		result1 /= 5;
		System.out.println("result1: " + result1);
		result1 %= 3;
		System.out.println("result1: " + result1);
	}
}
