package chap06.sec04;

public class Pen {
	String color = "black";
	//생성자가 없으면 컴파일러가 추가해줌
	public Pen() {
		this("black"); //현재 클래스내의 다른 생성자를 호출 즉, 아래에 있는 생성자를 호출하게 됨.
	}; //기본생성자 : 인자가 없는 생성자
	public Pen(String color) {
		this.color = color;
	}
	/*
	 * 메서드
	 * 접근제한자 사용제한자 리턴타입 이름(매개변수 선언, ...){
	 * 	코드
	 * 	return 반환할 값; 리턴타입이 void가 아닐 경우 반드시 추가해야 함
	 * }
	 * 메서드 정의, 메서드 호출시 객체를 이용해서 호출함
	 */ 
	void write(){
		System.out.println("글을 씁니다.");
	}
	void write(String message){
		System.out.println(message + "를 씁니다.");
	}
}
