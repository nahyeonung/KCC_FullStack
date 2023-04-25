package ch14;

public class BombExample {
	public static void main(String[] args) {
		CounterRunner cr = new CounterRunner();
		QuestionRunner qr = new QuestionRunner();
		Thread t1 = new Thread(cr);
		Thread t2 = new Thread(qr);
		t1.start();
		t2.start();
	}
}
