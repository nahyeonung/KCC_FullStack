package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바";
		
		//String -> byte 배열(기본 : UTF-8 인코딩)
		byte[] arr1 = data.getBytes(); //byte[] arr1 = data.getBytes("UTF-8");
		System.out.println("arr1: " + Arrays.toString(arr1));
		
		//byte 배열 -> String(기본: UTF-8 디코딩)
		String str1 = new String(arr1);
		System.out.println("str1: " + str1);
		
		//String -> byte 배열(EUC-KR 인코딩)
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println("arr2: " + Arrays.toString(arr2));
		
		//byte 배열 -> String(기본: UTF-8 디코딩)
		String str2 = new String(arr2, "EUC-KR");
		System.out.println("str2: " + str2);
		
		//EUC-KR로 인코딩된 byte를 UTF-8로 디코딩하면 글자 당 바이트 수 차이 때문에 문자가 깨짐
		String str3 = new String(arr2);
		System.out.println("str3: " + str3);
	}
}
