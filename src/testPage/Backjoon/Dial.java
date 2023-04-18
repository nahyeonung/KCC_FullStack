package testPage.Backjoon;

import java.util.Scanner;


public class Dial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        int result = 0;
        String str = scan.nextLine();    
        for(int i=0; i<str.length(); i++){
            String word = String.valueOf(str.charAt(i));
            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr[j].length(); k++){
                    String word2 = String.valueOf(arr[j].charAt(k));
                    if(word.equals(word2)){
                        result += j + 3;
                    }
                }
            }
        }
        System.out.println(result);
    }
    
}
