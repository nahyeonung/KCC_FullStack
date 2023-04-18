package ch06.sec06.exam02;

public class CarExample {
	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();
		
		//Car 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		//Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도" + myCar.speed);
		
		//기본 생성자가 아닌 다른 생성자로 생성
		Car myCar2 = new Car("그렌저", "검정", 250);
		System.out.println(myCar2.model + myCar2.color);
	}
}

class Car{
	//필드 선언
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	//기본생성자
	Car(){};
	
	//생성자 선언
	Car(String model, String color, int maxSpeed){
		this.model = model; this.color = color; this.maxSpeed = maxSpeed;
	}
}
