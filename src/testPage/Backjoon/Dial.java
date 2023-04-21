package testPage.Backjoon;

import java.util.Arrays;
import java.util.Scanner;


public class Dial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] arr = new String[5][15];
        String[] test = new String[15];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(arr[i], "?");
            test = scan.nextLine().split("");
            for(int j=0; j<test.length; j++){
                arr[i][j] = test[j];
            }
        }
        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(arr[i][j].equals("?")){

                }else{
                    System.out.print(arr[i][j]);
                }
            }
        } 
    }
    
}
