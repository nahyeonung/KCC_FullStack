package ch14.sec03.exam02;

public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunner());
		t1.start();
		Thread t2 = new MyThread();
		t2.start();
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		System.out.println("Main");
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		}
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		}
	}
}
