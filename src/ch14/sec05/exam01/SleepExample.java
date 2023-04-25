package ch14.sec05.exam01;

public class SleepExample {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println("딩");
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
