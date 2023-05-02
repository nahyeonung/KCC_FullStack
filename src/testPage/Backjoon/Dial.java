package testPage.Backjoon;

import java.util.Arrays;
import java.util.Scanner;


public class Dial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int result = 0;
        int i = 1;
        while(true){
            if(i == 1){
                result = 1;
                if(result >= num){
                    break;
                }
                i++;
            }
            else{
                result = result + (6*(i-1));
                if(result >= num){
                    break;
                }
                i++;    
            }
        }
        System.out.println(i);
    }
    
}