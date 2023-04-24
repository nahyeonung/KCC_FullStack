package ch12.sec12.practice2;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id + ": " + this.name;
	}
}
