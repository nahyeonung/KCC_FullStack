package testPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class remain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = "";
        while((str = bf.readLine()) != null){
            st = new StringTokenizer(str);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 == 0 && num2 == 0){
                break;
            }else{
                bw.write(num1 + num2 + "\n");
            }
        }
        bw.close();
    }
    
}
