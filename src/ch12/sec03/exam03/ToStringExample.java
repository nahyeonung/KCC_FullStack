package ch12.sec03.exam03;

public class ToStringExample {
	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");
		
		Object strObj = myPhone;
		System.out.println(strObj);
		
		System.out.println(myPhone);
	}
}
