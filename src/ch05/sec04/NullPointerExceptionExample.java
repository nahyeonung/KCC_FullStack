package ch05.sec04;

import java.util.Scanner;

public class NullPointerExceptionExample {
	public static void main(String[] args) {
		int[] intArray = null;
//		intArray[0] = 10; // NullPointerException
		
		String str = null;
//		System.out.println("총 문자 수: " + str.length()); //NullPointerException
        String result = "";
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int cnt = num / 4;
        for(int i=0; i<cnt; i++){
            result += "long ";
        }
        result += "int";
        System.out.println(result);
	}
	
	
}
