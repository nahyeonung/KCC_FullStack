package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyExample {
	public static void main(String[] args) {
		int[] intArr = {3,5,7,9,11};
		int[] intArr2 = intArr;
		intArr[0] = 300;
		int sum = 0;
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(intArr2));
		for(int i=0; i<intArr.length; i++) {
			sum += intArr[i];
		}
		System.out.println(sum);
		int sum2 = 0;
		for(int num : intArr2) {
			sum2 += num;
		}
		System.out.println(sum2);
	}
}
