package ch04.sec04;

public class ForExample {
	public static void main(String[] args) {
		for(int i=0 /*1번째*/; i<10 /*2번째*/; i++ /*4번쨰*/) {
			//System.out.println(i); /*3번째*/
		}
		//위와 같은 결과의 코드
		for(int i=0; i<10; ) {
			//System.out.println(i);
			i++;
		}
		
		int[] arr = {1,2,3,4,5,6,7,8,9}; //배열
		//arr 배열의 모든 값을 더하면?
		for(int a : arr) {
			System.out.println(a);
		}
	}
}
