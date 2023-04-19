package ch11.sec04.exam01;

public class SelectException {
	public static void main(String[] args) {
		try {
			doIt(0); //예외를 발생시킬지의 선택권을 가진 곳에 try문 처리
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("try문 종료");
	}
	
	public static void doIt(int data) throws ArithmeticException{
		int a = 1000/data; //예외가 발생할 가능성이 있음
		System.out.println(a);
	}
}
