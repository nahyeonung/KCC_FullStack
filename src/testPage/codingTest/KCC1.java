package testPage.codingTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class KCC1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop = scan.nextInt();
        for(int i=0; i<loop; i++){
            int w = -1;
            int h = -1;
            int len = scan.nextInt();
            scan.nextLine();
            String[][] arr = new String[len][len];
            int result = 0;
            int H = 0;
            for(int j=0; j<len; j++){
                String data = scan.nextLine();
                arr[j] = data.split(" ");
                for(int k=0; k<len; k++){
                    if(arr[j][k].equals("X")){
                      h = j;
                      w = k;  
                    }
                }
            }
            for(int k=w-1; k>=0; k--){
                // System.out.println(k);;
                if(arr[h][k].equals("Y")) break;
                if(arr[h][k].equals("H")){
                    H++;
                }
                if(H == 2){
                    H = 0;
                    result++;
                    break;
                }
            }
            for(int k=w+1; k<len; k++){
                if(arr[h][k].equals("Y")) break;
                if(arr[h][k].equals("H")){
                    H++;
                }
                if(H == 2){
                    H = 0;
                    result++;
                    break;
                }
            }
            for(int k=h-1; k>=0; k--){
                if(arr[k][w].equals("Y")) break;
                if(arr[k][w].equals("H")){
                    H++;
                }
                if(H == 2){
                    H = 0;
                    result++;
                    break;
                }
            }
            for(int k=h+1; k<len; k++){
                // System.out.println("dd" + arr[k][w]);
                if(arr[k][w].equals("Y")) break;
                if(arr[k][w].equals("H")){
                    H++;
                }
                if(H == 2){
                    H = 0;
                    result++;
                    break;
                }
            }
            bw.write("#" + (i+1) + " " + result + "\n");
            System.out.println("w: " + w + "h: " + h);
            
        }
        bw.close();
        scan.close();
        
    }
}
