package ch05;

import java.util.Arrays;

public class ArrayManager {
    public static void main(String[] args) {
        //배열 - 크기를 변경할 수 없다. 동종모음
        //배열을 사용하려면 데이터의 개수를 기억하는 변수, 현재 위치를 기억하는 변수
        int[] array = new int[10];
        int count = 0;
        int index = -1; //0으로 했다가 배열에 아무런 값도 없으면 에러나기 때문. if문으로 index가 -1이면 배열 탐색 하지 않도록 해주면 에러가 나지 않는다.
        int[] array2 = null;

        // 배열에 데이터 추가하기
        array[count] = 30;
        count++;
        array[count++] = 40; //한줄로 count값도 이동시키며 배열에 데이터도 삽입할 수 있음
        array[count++] = 50; 
        array[count++] = 60;
        // count--; //맨 마지막 데이터 삭제(값을 지우는 형식이 아니라 출력을 -1만큼만 해주는 형식)
    
        
        // 배열에 삽입한 값만 출력하기
        for(int i=0; i<count; i++){
            System.out.println(array[i] + " ");
        }
        System.out.println();
        
        // 배열 데이터 검색 및 해당 인덱스 위치에 데이터 수정
        int searchData = 40;
        for(int i=0; i<count; i++){
            if(array[i] == searchData){
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(Arrays.toString(array));
        if(index != -1){
            array[index] = 45;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
        //데이터 삭제
        int deleteData = 45;
        for(int i=0; i<count; i++){
            if(array[i] == deleteData){
                index = i;
            }
        }
        for(int i=index; i<count-1; i++){
            array[i] = array[i+1]; 
        }
        count--; // 데이터가 한 칸씩 당겨졌기 때문에 삽입된 데이터만큼 늘어난 count에 -1를 해줘야함.
        System.out.println(Arrays.toString(array));
        for(int i=0; i<count; i++){
            System.out.println(array[i]);
        }
        System.out.println(count);
        //데이터 삽입
        index = 1; 
        for(int i=count; i>index; i--){
            array[i] = array[i-1];
        }
        array[index] = 80;
        count++;
        System.out.println(Arrays.toString(array));
    }
}
