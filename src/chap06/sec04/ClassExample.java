package chap06.sec04;

public class ClassExample {
	public static void main(String[] args) {
		Pen p1 = new Pen();
		// 클래스명 변수명 = new 생성자();
		Pen p2 = new Pen();
		p2.color = "red";
		Pen p3 = new Pen("rainbow");
		System.out.println(p1.color);
		System.out.println(p2.color);
		System.out.println(p3.color);
		p1.write();
	}
}
