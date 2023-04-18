package ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        //인터페이스 변수 선언과 구현 객체 대입
        Vehicle vehicle = new Bus();

        //인터페이스를 통해서 호출
        vehicle.run();
        // vehicle.checkFare() Vehicle인터페이스에는 checkFare가 없기 때문에 안됨

        Bus bus = (Bus)vehicle;
        bus.checkFare(); //강제 타입 변환 후 호출
        
    }
}
