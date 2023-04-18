package ch02.sec13;

import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws IOException {
//		int data = System.in.read(); //입력한 1byte(100을 입력해도 1만 받음)를 저장해주고 ASCII코드로 반환
//		System.out.println(data);
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 2개를 입력하세요");
//		int data = scan.nextLine(); 컴퓨터는 String으로 받기 때문에 숫자를 nextLine으로 받을 수 없고 String으로 받아서 parseInt해줘야함.

		int data = scan.nextInt();
		int data2 = scan.nextInt();
		System.out.println(data + "|" + data2);
		scan.nextLine();
		System.out.println("이름을 입력하세요");
		String name = scan.nextLine();
		System.out.println("이름: " + name);
		
		
		System.out.println("nextLine으로 정수 사용");
		String num = scan.nextLine();
		int realNum = Integer.parseInt(num);
		System.out.println(realNum);
		
		while(true) {
			System.out.print("입력 문자열: ");
			String result = scan.nextLine();
			if(result.equals("p")) {
				System.out.println("종료");
				break;
				}
			
			System.out.println("출력 문자열: " + result);
			System.out.println();
			
		}
		scan.close(); //scanner는 입력을 요청하는 것이기 때문에 입력이 끝나면 닫아줘야 한다.
		
	}
}
