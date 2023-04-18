package homework;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 
 * 다음 지시대로 데이터를 읽는 프로그램을 작성하세요.
 * 맨 처음 입력한 숫자는 테스트 케이스입니다.
 * 각 테스트별로 입력 데이터의 개수와 그 입력 데이터만큼의 데이터가 입력되어야 합니다.
 * 입력 예시
 * 3
 * 5
 * 1 2 3 4 5
 * 1
 * 9
 * 4
 * 3 3 3 3 3
 * 각 테스트 케이스별로 데이터의 합을 아래 형식으로 출력해야 합니다.
 * 출력 예시
 * #1 15
 * #2 9
 * #3 12
 */
public class First {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		int[] result = new int[testCase];
		for(int j=1; j<=testCase; j++) {
			int num1 = scan.nextInt();
			int sum = 0;
			for(int i=0; i<num1; i++) {
				sum += scan.nextInt();
			}
			result[j-1] = sum;
		}
		for(int i=0; i<testCase; i++) {
			System.out.printf("#%d %d \n", i+1, result[i]);
		}
		scan.close();
//        Scanner scan = new Scanner(System.in);
//        int loop = scan.nextInt();
//        int[] result = new int[loop];
//        for(int i=0; i<loop; i++){
//            int num1 = scan.nextInt();
//            int num2 = scan.nextInt();
//            result[i] = num1 + num2;
//        }
//        for(int i=0; i<loop; i++){
//            System.out.println(result[i]);
//        }
	}
}

