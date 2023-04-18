package testPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
/***
 5 4
1 2
3 4
1 4
2 2
 */
public class CheckExam {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		int loop = scan.nextInt();

		int[] arr = new int[len];
		for(int i=0; i<len; i++){
			arr[i] = i+1;
		}
		for(int i=0; i<loop; i++){
			int start = scan.nextInt() - 1;
			int done = scan.nextInt() - 1; 
			int inner = (done - start) / 2;
			for(int j=0; j<=inner; j++){
				int temp = arr[start+j];
				arr[start+j] = arr[done - j];
				arr[done-j] = temp;	 
			}
		}
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + "\n");
		}
	}
}
