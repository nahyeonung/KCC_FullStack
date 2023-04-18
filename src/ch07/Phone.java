package ch07;

public abstract class Phone {
	String owner; 
	
	public Phone() {
		
	}
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	
	abstract void internetSearch();
}
