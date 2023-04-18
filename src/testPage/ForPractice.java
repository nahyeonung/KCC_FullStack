package testPage;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ForPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine()); //Int
        for(int i=0; i<T; i++){
            st = new StringTokenizer( bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
            System.out.println("ddd");
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        } 
       bw.close(); //닫힐 때 출력
       
            
       
                
    }
}
