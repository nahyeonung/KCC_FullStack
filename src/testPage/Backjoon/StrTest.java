package testPage.Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StrTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        scan.nextLine();
        int result = 0;
        for(int i=0; i<loop; i++){
            int[] alpha = new int[26];
            String str = scan.nextLine();
            for(int j=0; j<str.length(); j++){
                if(j != 0) {
                    if(str.charAt(j-1) != str.charAt(j)){
                        if(alpha[str.charAt(j) - 97] != 0){
                            break;
                        }else{
                            alpha[str.charAt(j) - 97]++;
                        }
                    }else{
                        alpha[str.charAt(j) - 97]++;
                    }
                }
                else{
                    alpha[str.charAt(j) - 97]++;
                }
                if(j == str.length()-1){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
