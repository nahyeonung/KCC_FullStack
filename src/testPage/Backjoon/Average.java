package testPage.Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        int[] result = new int[loop];
        scan.nextLine();
        for(int i=0; i<loop; i++){
            int sum = 0;
            double avg = 0;
            int top = 0;
            String[] temp = scan.nextLine().split(" ");
            int[] arr = new int[Integer.parseInt(temp[0])];
            for(int j=0; j<arr.length; j++){
                arr[j] = Integer.parseInt(temp[j+1]);
                sum += arr[j];
            }
            avg = (double)sum / arr.length;
            for(int j=0; j<arr.length; j++){
                if(arr[j] > avg) top++;
            }
            System.out.println(String.format("%.3f", (double)top/arr.length * 100) + "%");
        }
    }
}
