package ch07.sec01;

public class InheritanceExample {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 20, "123456");
		s1.name = "나현웅"; //부모 클래스의 필드를 받아와서 사용할 수 있음
		s1.age = 20;
		s1.studentId = "123456789";
		System.out.println(s1.getDetails());
	}
}
