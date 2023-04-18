package ch08.sec02;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn();
		
		//교체시킴
		rc = new Audio();
		rc.turnOn();
	}
}
