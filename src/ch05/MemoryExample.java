package ch05;

public class MemoryExample {
	public static void main(String[] args) {
		int number = 10; //stack영역에 변수로 들어감
		Pen p1 = new Pen("검정색"); //heap 영역에 들어가고 stack영역에서 heap영역에 저장된 객체의 주소값을 저장함
		Pen p2 = null; //이 코드는 stack에서 번지를 아직 저장하지 못했으니 NullPointerException이 발생한다.
		Pen p3 = new Pen("흰색");
		p3 = null; // p3변수는 흰색인 객체의 주소값을 가지고 있었는데, 주소값이 null로 바뀐다. 그래서 p3는 NullPointerException이 발생하고 객체는 힙영역에 
		//여전히 남아있다. 그러다가 garbage collector가 stack에  참조되지 않는 객체인 흰색 객체를 찾으면 힙영역에서 지워준다.
		
		Pen pen1 = new Pen("검정색");
		Pen pen2 = new Pen("빨강색");
		Pen pen3 = new Pen("파랑색");
		System.out.println("pen2 = null");
		pen2 = null;
		System.gc(); //강제로 gc 실행
		System.out.println("pen1=null");
		System.gc();
		System.out.println("pen3=null");
		pen3 = null;
		System.gc();
	}
	
} // end class

//메소드 영역에 올라가는 클래스
class Pen{
	public final String BRAND = "모나미"; //상수
	public static int count = 0; // 정적필드(static 변수)
	public String color; // 인스턴스 필드
	public Pen(String color) {
		this.color = color;
	}
	public void write() {
		System.out.println("Hello");
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("gc로 강제실행");
	}
}
