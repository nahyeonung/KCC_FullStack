package ch07.sec01;

public class Student extends Person {
//	String name;
//	int age;
	String studentId;

	public Student(String name, int age, String studentId) {
		super(name, age);
//		this.name = name; //생성자에서도 부모의 필드를 참조할 수 있음
//		this.age = age;
		this.studentId = studentId;
	}
	
	
	@Override
	public String getDetails() {
		return super.getDetails() + "\t학번: " + studentId;
	}
}
