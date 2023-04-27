package testPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();
        int dec = scan.nextInt();
		int size = 0;
		while(true){
			int a = (int)Math.pow(dec, size);
			if(a > score){
				break;
			}
			else if(a == score){
				size++;
				break;
			}
			size++;
		}
		if(size == 0) size=1;
		int[] arr = new int[size];
		char[] result = new char[size];
		for(int i=0; i<size; i++){
			arr[i] = score % dec;
			if(arr[i] >= 10){
				result[i] = (char)(arr[i] + 55);	
			}else {
				result[i] = (char)(arr[i] + 48);
			}
			score = score / dec;
		}
		for(int i=size-1; i>=0; i--){
			bw.write(result[i]);
		}
		bw.close();
    }
}
