package testPage.Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Bronze2 {
    Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            int[] arr = new int[N];
            for(int j=0; j<N; j++){
                int num = sc.nextInt();
                arr[j] = num;
            }
            int max = 0;
            
            for(int j=0; j<arr.length; j++){
                int sum = 0;
                for(int k=0; k<arr.length; k++){
                    if(k != j){
                        sum = sum + arr[k];
                    }
                }
                if(sum > 0){
                    for(int k=0; k<arr.length; k++){
                        int min_val = Integer.MAX_VALUE;
                        max = max + arr[k];
                        for(int l=0; l<arr.length; l++){
                            if(k != l){
                                max = max + arr[l];
                                if(arr[l] < 0){
                                    if(arr[l] < min_val){
                                        min_val = arr[l];
                                    }        
                                }
                            }
                        }
                        if(min_val != Integer.MAX_VALUE){
                            max = max - min_val;
                        }
                    }
                }
                else if(sum < 0){
                    int max_val = Integer.MIN_VALUE;
                    for(int k=0; k<arr.length; k++){
                        max = max + arr[k];
                        for(int l=0; l<arr.length; l++){
                            max = max + arr[l];
                            if(k != l){
                                if(arr[l] > 0){
                                    if(arr[l] > max_val){
                                        max_val = arr[l];
                                    }
                                }
                            }
                        }
                        if(max_val != Integer.MAX_VALUE){
                            max = max - max_val;
                        }
                    }
                }
                else if(sum == 0){
                    
                }
            }
            
            
            System.out.println(Math.abs(max) % 1000000007);
}