package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] scores = null;
        while(true){
            System.out.println("---------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("---------------------------------------------------");
            System.out.print("선택>");
            String select = scan.nextLine();
            if(select.equals("1")){
                System.out.print("학생수>");
                int num = scan.nextInt();
                scores = new int[num];
                scan.nextLine();
            }
            else if(select.equals("2")){
                for(int i=0; i<scores.length; i++){
                    int num = scan.nextInt();
                    scores[i] = num;
                    scan.nextLine();
                }
            }
            else if(select.equals("3")){
                for(int i=0; i<scores.length; i++){
                    System.out.println("scores[" + i + "]: " + scores[i] );
                }
            }
            else if(select.equals("4")){
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for(int data : scores){
                    sum += data;
                    if(data > max){
                        max = data;
                    }
                }
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + (double)sum / scores.length);
            }
            else if(select.equals("5")){
                break;
            }
            
            
        }
    }
}
