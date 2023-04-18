package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyExmple2 {
	public static void main(String[] args) {
		//길이가 3인 배열
		String[] oldStrArray = {"java", "array","copy"};
		//길이가 5인 배열을 새로 생성
		String[] newStrArray = new String[5];
		//배열 항목 복사
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		//배열 항목 출력
		for(int i=0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ", ");
		}
		System.out.println();
		oldStrArray[0] = "dd";
		System.out.println(Arrays.toString(oldStrArray));
		System.out.println(Arrays.toString(newStrArray));
	}
}
