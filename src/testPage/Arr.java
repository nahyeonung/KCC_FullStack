package testPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arr {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int compare = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(compare > arr[i]){
                bw.write(arr[i] + " ");
            }
        }        
        bw.close();
        // String arr[] = bf.readLine().split(" ");
        // String str = bf.readLine();
        // int cnt = 0;
        // for(int i=0; i<loop; i++){
        //     if(str.equals(arr[i])){
        //         cnt++;
        //     }
        // }
        // System.out.println(cnt);
    }
}
