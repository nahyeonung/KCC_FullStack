package ch12.sec12.practice;

import java.util.HashSet;

public class StudentExample {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		System.out.println(hashSet.add(new Student("1")));
		System.out.println(hashSet.add(new Student("1")));
		System.out.println(hashSet.add(new Student("2")));
	}
}
