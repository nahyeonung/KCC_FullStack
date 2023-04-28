package testPage;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String score = scan.next();
        int sum = 0;
        int[] num = new int[score.length()];
        int dec = Integer.parseInt(scan.next());
        
        for(int i=0; i<score.length(); i++){
            if(score.charAt(i)>=65){
                num[i] = score.charAt(i) - 55;
            }else{
                num[i] = score.charAt(i) - 48;}
        }
        // System.out.println(Arrays.toString(num));
        for(int i=num.length-1; i>=0; i--){
            // System.out.println(Math.pow(dec, (num.length-1)-i) + "   " + num[i]);
            sum += Math.pow(dec, (num.length-1)-i) * num[i];
        }
        System.out.println(sum);

    }
}
