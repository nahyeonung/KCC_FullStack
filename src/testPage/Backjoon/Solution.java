package testPage.Backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[26];
        int max = -1;
        int result = 0;
        String str = scan.nextLine().toUpperCase();
        for(int i=0; i<str.length(); i++){
            int location = str.charAt(i) - 65;
            arr[location]++;
        }
        for(int i=0; i<arr.length; i++){
            if(max == arr[i]){
                result = 1;
            }
            else if(arr[i] > max){
                max = arr[i];
                result = 0;
            }
        }
        if(result == 0){
            for(int i=0; i<arr.length; i++){
                if(max == arr[i]){
                    System.out.println(Character.toChars(i + 65));
                }
            }
        }else{
            System.out.println("?");
        }
    }
}
