package testPage.Backjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bronze2 {
    public static void main(String[] args) throws IOException {
		//리스트는 배열과 다르게 인덱스에 값을 넣으면 덮어 씌워지지 않고 기존 값이 뒤로 밀려 남.
		// ArrayList list = new ArrayList();
		// list.add(0, 1);
		// list.add(0, 2);
		// System.out.println(list);
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long num1 = Math.max(a,b);
		long num2 = Math.min(a,b);
		long result = lcd(num1, num2);
		System.out.println(result);

	}
	public static long gcd(long num1,long num2){
		while(num2 > 0){
			long tmp = num2;
			num2 = num1 % num2;
			num1 = tmp;
		}
		return num1;
	}

	public static long lcd(long num1, long num2){
		return num1 * num2 / gcd(num1, num2);
	}
}
