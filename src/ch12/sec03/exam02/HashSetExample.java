package ch12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
//HashSet은 동등 객체를 중복 저장하지 않는 특징을 가져서, 자동으로 hashCode와 equals 메소드를 이용해서 동등 객체인지 판단한다.
//여기서 Student 클래스에서 hashCode를 재정의해서 내부 데이터를 비교했지만 재정의하지 않으면 객체의 주소를 해쉬코드로 비교하므로 s1,s2,s3가 전부 담길 수 있다.
		Student s1 = new Student(1,"홍길동");
		hashSet.add(s1);
		System.out.println("저장된 객체 수: " + hashSet.size());
		
		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2);
		System.out.println("저장된 객체 수: " + hashSet.size());
		
		Student s3 = new Student(2, "홍길동");
		hashSet.add(s3);
		System.out.println("저장된 객체 수: " + hashSet.size());
	}
}
