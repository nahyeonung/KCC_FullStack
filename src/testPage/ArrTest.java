package testPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrTest {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int loop = scan.nextInt();
		int max = 0;
		int[] arr = new int[loop];
		double sum = 0;
		for(int i=0; i<loop; i++){
			int num = scan.nextInt();
			arr[i] = num;			
		}
		for(int i=0; i<loop; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		for(int data : arr){
			System.out.println(data);
			sum += ((double)data / max * 100);
		}
		System.out.println(sum/loop);
	}
}
