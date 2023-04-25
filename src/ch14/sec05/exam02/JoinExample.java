package ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try{
			//sumThread가 종료될 때까지 main스레드를 일시정지 시킴
			sumThread.join();
		}catch(InterruptedException e) {
			
		}
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}
