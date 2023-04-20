package testPage.Backjoon;

import java.util.Arrays;
import java.util.Scanner;


public class Dial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int w = scan.nextInt();
        int[][] arr1 = new int[h][w];
        int[][] arr2 = new int[h][w];
        int[][] result = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                arr1[i][j] = scan.nextInt();
            }
        }
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                arr2[i][j] = scan.nextInt();
            }
        }
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                result[i][j] = arr1[i][j] + arr2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
    
}
