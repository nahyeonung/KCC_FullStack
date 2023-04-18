package ch04.sec03;

public class SwitchExample {
	public static void main(String[] args) {
		int num = (int)(Math.random()*6) + 1;
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break; //break가 없이 case가 1을 돈다면 밑의 case도 다 돌게 된다.
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default:
			System.out.println("6번이 나왔습니다.");
		
			
	}
		System.out.println("Hello World");	
	}
}
