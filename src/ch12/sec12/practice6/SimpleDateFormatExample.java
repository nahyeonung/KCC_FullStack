package ch12.sec12.practice6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		System.out.println(sdf.format(date));
	}
}
