package ch04.sec02;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score= scan.nextInt();
		if(score > 100) {
			System.out.println("점수를 잘못 입력했습니다.");
		}else {
			if(score>=90) {
				if(score>=95) {
					System.out.println("A+");
				}else {
					System.out.println("A");
				}
			}else if(score>=0) {
				System.out.println("you need to study hard");
			}else {
				System.out.println("minus score is not");
			}
		}
		scan.close(); //close도 리소스를 사용하는 것이기 때문에 원하는 프로그램을 다 쓴 다음에 close를 써주는 것이 더 빠르게 프로그램을 돌릴 수 있는 방법이다.
	}
}
