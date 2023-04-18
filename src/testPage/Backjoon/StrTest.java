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
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        String num1 = scan.next();
        String num2 = scan.next();
        String result1 = "";
        String result2 = "";
        for(int i=2; i>=0; i--){
            result1 += num1.charAt(i);
            result2 += num2.charAt(i);
        }
        if(Integer.parseInt(result1) > Integer.parseInt(result2)){
            System.out.println(Integer.parseInt(result1));
        }else{
            System.out.println(Integer.parseInt(result2));
        }
    }
}
