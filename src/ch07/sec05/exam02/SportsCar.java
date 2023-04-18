package ch07.sec05.exam02;

public class SportsCar extends Car {
    @Override
    public void speedUp(){
        speed += 10;
    }

    //부모 클래스에 있지 않는 메서드는 Override할 수 없다.
    // @Override
    // public void stop(){
    //     System.out.println("스포츠카를 멈춤");
    //     speed = 0;
    // }
}
