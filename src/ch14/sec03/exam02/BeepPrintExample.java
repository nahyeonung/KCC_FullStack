package ch14.sec03.exam02;

public class BeepPrintExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("딩");
					try {
						Thread.sleep(500); 
					}catch(Exception e) {}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("동");
					try {
						Thread.sleep(500);
					}catch(Exception e) {
						
					}
				}
			}
		});
		thread.start();
		thread2.start();
	}
}
