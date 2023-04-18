package ch07.sec04.exam00;

import java.nio.charset.MalformedInputException;

public class VirtualMethodInvocationExample {
    public static void main(String[] args) {
        A a = new B(); //A라는 틀에 B객체가 들어간 것
        a.doIt();
        a = new C(); //A라는 틀에 C객체가 들어간 것
        a.doIt();
        // a.doThat(); // C객체가 들어가긴 했지만 A라는 틀에 doThat이라는 메서드가 없기 때문에 사용할 수 없다.
        C c = (C)a;
        c.doThat();
        A a2 = new A();
        // B b2 = (B)a2; //runtime error 생성 자체를 부모 객체로 생성하면 자식 객체로 타입 변환이 안되는 것 같다.
    }
}
class A{
    public void doIt(){
        System.out.println("A");
    }
}
class B extends A{
    public void doIt(){
    System.out.println("B");
}
}
class C extends A{
    public void doIt(){
        System.out.println("C");
    }

    public void doThat(){
        System.out.println("dothat");
    }
}