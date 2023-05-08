package testPage.Backjoon;

import java.util.Scanner;

public class Dial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        int maximum = scan.nextInt();
        int min = Integer.MAX_VALUE;
        int[] arr = new int[loop];
        for(int i=0; i<loop; i++){
            arr[i] = scan.nextInt();
        }
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= maximum){
                        if(min >= maximum - sum){
                            min = maximum - sum;
                        }
                    }
                }
            }
        }
        System.out.println(maximum - min);
    }
    
}