package ch07.sec01;

public class Person extends Object{
	String name;
	int age;
	
	public Person() {};
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getDetails() {
		return "이름: " + name + "\t나이: " + age; 
	}
}
