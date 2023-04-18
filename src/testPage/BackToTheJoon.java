package testPage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BackToTheJoon {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean[] bArr = new boolean[30];
		int[] two = new int[2];
		for(int i=0; i<28; i++){
			int num = scan.nextInt();
			bArr[num-1] = true;
		}
		for(int i=0; i<bArr.length; i++){
			if(bArr[i] == false){
				if(two[0] == 0){
					two[0] = i+1;
				}else{
					two[1] = i+1;
				}
			}
		}
		System.out.println(two[0]);
		System.out.println(two[1]);
	}
}
