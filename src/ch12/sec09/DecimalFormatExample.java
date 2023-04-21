package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;
		double num2 = 1234;
		DecimalFormat df;
		
		//정수 자리까지 표기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		//무조건 소수 첫째 자리까지 표기
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
		
		//소수 첫째 자리에 값이 있으면 표기
		df = new DecimalFormat("#,###.#");
		System.out.println(df.format(num2));
		
		df = new DecimalFormat("#,###.# %");
		System.out.println(df.format(num2));
		
		df = new DecimalFormat("#,###.# %");
		System.out.println(df.format(12.56789));
	}
}
