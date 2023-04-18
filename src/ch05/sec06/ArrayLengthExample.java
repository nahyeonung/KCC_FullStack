package ch05.sec06;

import java.util.Arrays;

public class ArrayLengthExample {
    public static void main(String[] args) {
        //배열 변수 선언과 배열 대입
        int[] scores = { 84, 90, 96};

        //배열 항목의 총합 구하기
        int sum=0;
        for(int i=0; i<scores.length; i++){
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);

        //배열 항목의 평군 구하기
        double avg = (double)sum / scores.length;
        System.out.println("평균 : " + avg);

        int[][] a = new int[2][3];
        System.out.println(Arrays.toString(a[0]));
    }
}
