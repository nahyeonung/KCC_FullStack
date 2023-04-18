package ch07;

public class AbstractExample {
	public static void main(String[] args) {
//		Phone myPhone = new Phone("홍길동");
		SmartPhone myPhone = new SmartPhone("홍길동");
		myPhone.turnOn();
		myPhone.internetSearch();
		myPhone.turnOff();
		
		Phone yourPhone = new SmartPhone("홍길서");
		yourPhone.turnOn();
		yourPhone.internetSearch();  
		yourPhone.turnOff();
	}
}
