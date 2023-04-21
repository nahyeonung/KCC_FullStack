package ch12.sec11.exam03;

import java.net.URL;

public class GetResourceExample {
	public static void main(String[] args) {
		Class clazz = Car.class;
		
		URL photo1Path = clazz.getResource("photo1.png");
		String photo1Path2 = clazz.getResource("photo1.png").getPath();
		System.out.println(photo1Path);
		System.out.println(photo1Path2);
	}
}
