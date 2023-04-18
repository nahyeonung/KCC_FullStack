package ch05.sec12;

public class Max {
    public static void main(String[] args) {
        int[] array = {-1,-2,-3};
        int max = Integer.MIN_VALUE;
        System.out.println(max);
        for(int data : array){
            if(data> max){
                max = data;
            }
        }
        System.out.println(max);

        int[][] arr = {{95,86}, {83,92,96}, {78,83,93,87,88}};
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                sum += arr[i][j];
                cnt++;
            }
        }
        System.out.println("합: " + sum + "평균: " + (double)sum / cnt);
    }
    
}
