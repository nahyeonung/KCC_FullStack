package ch07;

public class SmartPhone extends Phone {
	public SmartPhone(String owner) {
		super(owner);
	}
	
	void internetSearch() {
		System.out.println("인터넷을 검색합니다.");
	}
	
}
